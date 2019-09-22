package server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static server.AttributeSetter.*;

public class AreaCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HELLO FROM CHECK");
        System.out.println("BYE FROM CHECK");

        ResultsHolder holder = (ResultsHolder) request.getSession().getAttribute("results");
        float x = (Float)request.getAttribute(KEY_X);
        float y = (Float)request.getAttribute(KEY_Y);
        List<Float> r =(List<Float>) request.getAttribute(KEY_R);

        for(Float currentR:r){
            holder.add(new Result(x,y,currentR,inside(x,y,currentR)));
        }
        response.sendRedirect("index.jsp");
    }

    private boolean inside(float x, float y, float r){
        if(x>=0 && y<=0 && x*x+y*y<=r*r)return true;
        if(x<=0 && x>=-r/2 && y<=0 && y>=-r)return true;
        return x<=0 && y>=0 && y<=x+r;
    }
}
