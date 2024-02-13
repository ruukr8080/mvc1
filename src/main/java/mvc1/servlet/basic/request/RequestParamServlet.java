package mvc1.servlet.basic.request;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import java.io.IOException;

/*
1. 파라미터 전송 기능
  localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {



        System.out.println(" =======전체파라미터 조회 Start========= ");
        req.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName +" = " + req.getParameter(paramName)));
        System.out.println(" =======전체파라미터 조회 End========= ");
        req.getParameterNames();
        System.out.println();
        System.out.println("단일 파라미터 조회");
        String name = req.getParameter("username");
        String age = req.getParameter("age");

        System.out.println("username : " + name + " age : " + age);

        String[] usernames = req.getParameterValues("username");
        for (String username : usernames) {
            System.out.println("username = " + username);
        }
        res.getWriter().write("okok");

    }
}

