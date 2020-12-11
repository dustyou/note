import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CookiesTest")
public class CookiesTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//        boolean flag = false;
//        //获取所有的cookie
//        Cookie[] cookies = request.getCookies();
//        if (cookies!=null && cookies.length>0) {
//            for (Cookie cookie: cookies
//                 ) {
//                //获取cookie名称
//                String name = cookie.getName();
//
//                if ("lastTime".equals(name)) {
//                    //响应数据
//                    String value = cookie.getValue();
//                    response.getWriter().write("<h1>欢迎回来,您上次访问时间为:" + value + "</h1>");
//                    flag = true;
//                    break;
//                }
//
//            }
//        }
//        //第一次访问
//        if (!flag) {
//            response.getWriter().write("<h1>欢迎您首次访问</h1>");
//        }
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
//        String str_date = sdf.format(date);
//        Cookie lastTime = new Cookie("lastTime", str_date);
//        lastTime.setMaxAge(60*60*24*30);
//        response.addCookie(lastTime);
    
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
