package mvc1.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet",urlPatterns = "/home")
public class helloServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("helloServlet.service");
        System.out.println("req = " + req);
        System.out.println("req = " + req);


        String name =  req.getParameter("name");
        System.out.println("name1 = " + name);

        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello~~"+name);

    }

}

