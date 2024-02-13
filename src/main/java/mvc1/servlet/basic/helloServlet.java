package mvc1.servlet.basic;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "helloServlet",urlPatterns = "/home")
public class helloServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        System.out.println("helloServlet.service");
        System.out.println("req = " + req);
        System.out.println("req = " + req);


        String name =  req.getParameter("name");
        System.out.println("name1 = " + name);

        res.setCharacterEncoding("utf-8");
        res.getWriter().write("hello~~"+name);

    }

}

