package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    private List<String> list = new ArrayList<>();
    
    public void destroy() {
    }
    
    public void doFilter(final ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException,
            IOException {
        //1. 创建代理对象, 增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(),
                req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是getParameter方法
                if (method.getName().equals("getParameter")) {
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(req, args);
                    if (value != null) {
                        for (String str : list
                        ) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "***");
                            }
                            
                        }
                    }
                    return value;
                }
                return method.invoke(req, args);
            }
        });
        //2. 放行
        chain.doFilter(proxy_req, resp);
    }
    
    public void init(FilterConfig config) throws ServletException {
        //1. 加载文件
        ServletContext servletContext = config.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
        System.out.println(realPath);
        //2. 读取文件
        try {
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            //3. 将文件的每一行数据添加到list中
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        
        
    }
    
}
