package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

/**
 * ${PACKAGE_NAME}
 * Administrator
 * 2018/11/19
 * 15:46
 */
@WebServlet(name = "IndexServlet")
//首页
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //request.getSession();//创建session 对象，在一次打开浏览器时共用一个session
        out.write("本网站有如下书：<br>");
        Set<Map.Entry<String,Book>> set = DB.getAll().entrySet();
        for (Map.Entry<String,Book> map : set)
        {
            Book book = map.getValue();
            String url = request.getContextPath() + "/BuyServlet?id=" + book.getId();
            url = response.encodeURL(url);
            out.println(book.getName() + "<a href='"+url+"'>购买</a><br/>");
        }
    }
}
