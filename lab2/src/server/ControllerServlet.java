package server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ControllerServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO replace method if need
        System.out.println("CS - POST method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO replace method if need
        System.out.println("CS - GET method");


        System.out.println("START");
        System.out.println(req.getParameter("y"));
        System.out.println(req.getParameter("x"));
        System.out.println(Arrays.toString(req.getParameterValues("r")));
        boolean hi = AttributeSetter.validateY(req,req.getParameter("y"));
        hi&= AttributeSetter.validateX(req,req.getParameter("x"));
        hi&= AttributeSetter.validateR(req,req.getParameterValues("r"));
        System.out.println("CHECK (VALIDATION - CORRCT?) = "+hi);

        if(hi){
            req.getRequestDispatcher("check").forward(req,resp);
        }else
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
