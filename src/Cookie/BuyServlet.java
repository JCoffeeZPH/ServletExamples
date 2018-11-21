package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ${PACKAGE_NAME}
 * Administrator
 * 2018/11/21
 * 8:06
 */
@WebServlet(name = "BuyServlet")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        Book book = DB.getAll().get(id);
        HttpSession session = request.getSession();
        List<Book> list = (List)session.getAttribute("list");
        if(list == null){
            list = new ArrayList<Book>();
            session.setAttribute("list",list);
        }
        list.add(book);
        String url = response.encodeRedirectURL(request.getContextPath() + "/ListCartServlet");
        System.out.println(url);
        response.sendRedirect(url);
    }
}
