package server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

import static java.lang.Math.abs;

public class AreaCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO replace this if need
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO replace this if need

        RequestParser parser = new RequestParser(request);

        ResultsHolder holder = (ResultsHolder) request.getServletContext().getAttribute("results");
        float x,y,r;
        try {
            x = parser.getX();
            y= parser.getY();
            r = parser.getR();

            if(!parser.isFROM_FORM()){
                x*=r;
                y*=r;
            }
            holder.add(new Result(x, y, r, inside(x, y, r)));

        }catch (NumberFormatException e){
            holder.add(new Result());
        }

        response.setContentType("text/html; charset=UTF-8");
        Writer out = response.getWriter();
        out.write("<html><head>" +
                "<link rel=\"stylesheet\" href=\"main.css\">" +
                "<link rel=\"stylesheet\" href=\"colors.css\">" +
                "</head><body>");
        out.write(holder.toString());
        out.write("<a href=\"index.jsp\">back to input</a>");
        out.write("</body></html>");
//        response.sendRedirect("index.jsp");
    }

    private boolean inside(float x, float y, float r){
        if(x>=0 && y>=0 && x*x+y*y<=r*r)return true;
        if(x<=0 && x>=-r/2 && y>=0 && y<=r)return true;
        return x<=0 && y<=0 && y>=-x-r;
    }
}


class RequestParser{
    private static final float[] ALLOWED_X={-5,-4,-3,-2,-1,0,1,2,3};
    private static final float[] ALLOWED_R={1,1.5f,2,2.5f,3};

    private HttpServletRequest request;
    private final boolean FROM_FORM;

    public RequestParser(HttpServletRequest request) {
        this.request = request;
        FROM_FORM = request.getParameter("submit_btn")!=null;
    }

    public float getX() throws NumberFormatException{
        float floatX = (float)Float.parseFloat(request.getParameter("x"));
        if(FROM_FORM) {
            for (float allowedX : ALLOWED_X) {
                if (allowedX == abs(floatX))
                    return floatX;
            }
        }else {
            return floatX;
        }
        throw new NumberFormatException();
    }


    public float getR() throws NumberFormatException{
        float floatR = (float)Float.parseFloat(request.getParameter("r"));
        if(FROM_FORM) {
            for (float allowedR : ALLOWED_R) {
                if (allowedR == floatR)
                    return floatR;
            }
        }else {
            return floatR;
        }
        throw new NumberFormatException();
    }


    public float getY() throws NumberFormatException{
        float floatY = (float)Float.parseFloat(request.getParameter("y"));

        if(FROM_FORM) {
            if (abs(floatY) <= 3)
                return floatY;
        }else return floatY;

        throw new NumberFormatException();
    }

    public boolean isFROM_FORM() {
        return FROM_FORM;
    }
}
