package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

/**
 * ${PACKAGE_NAME}
 * Administrator
 * 2018/11/21
 * 8:23
 */
@WebServlet(name = "ListCartServlet")
public class ListCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        List<Book> list = (List) session.getAttribute("list");
        if(list == null || list.size() == 0){
            out.write("您没有买过任何东西");
            return ;
        }

            out.write("您买过如下商品:<br>");
            for(Book book : list){
                out.write(book.getName() + "<br/>");
               // System.out.println(book.getName() + "<br>");
        }
    }
}
