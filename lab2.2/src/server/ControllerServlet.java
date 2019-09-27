package server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ControllerServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO replace method if need
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO replace method if need


        boolean forAreaCheck = req.getParameter("x")!=null&&
                req.getParameter("y")!=null&&
                req.getParameterValues("r")!=null;

        if(forAreaCheck){
            req.getRequestDispatcher("check").forward(req,resp);
        }else
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    //control?x=0.5&y=1&r=2.5&submit_btn=
    //x=0.4779&y=0.4779&r=3&click=true
}
