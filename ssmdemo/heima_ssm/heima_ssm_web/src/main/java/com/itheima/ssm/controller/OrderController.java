package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Order;
import com.itheima.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    private IOrderService orderService;
    //查询全部订单, 未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        System.out.println("findAll.do in order.findAll");
//        List<Order> orderList = orderService.findAll();
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("orderList", orderList);
//        mv.setViewName("orders-list");
//        return mv;
//    }
    //在使用JSR250注解时, 可以省略ROLE_前缀, 而在使用@Secured注解时不能省略前缀
    @Secured("ROLE_ADMIN")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size ) throws Exception {
//        System.out.println("findAll.do in order.findAll");
        List<Order> orderList = orderService.findAll(page, size);
        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(orderList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
    
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) int orderId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Order order = orderService.findById(orderId);
        mv.addObject("order", order);
        mv.setViewName("orders-show");
        
        return mv;
    }
    
}
