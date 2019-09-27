package server;
import com.sun.deploy.util.ArrayUtil;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
public class AttributeSetter {

    public static final String KEY_X="KEY_X";
    public static final String KEY_Y="KEY_Y";
    public static final String KEY_R="KEY_R";

    private static final float[] ALLOWED_X={2,1.5f,1,0.5f,0};
    private static final float[] ALLOWED_R={1,1.5f,2,2.5f,3};

    public static boolean validateX(HttpServletRequest req, String x){
        try {
            float floatX = Float.parseFloat(x);
            for (float allowedX : ALLOWED_X) {
                if (allowedX == abs(floatX)){
                    req.setAttribute(KEY_X,floatX);
                    return true;
                }
            }
            return false;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean validateY(HttpServletRequest req, String y){
        try {
            float floatY = Float.parseFloat(y);
            if(abs(floatY)<=3){
                req.setAttribute(KEY_Y,floatY);
                return true;
            }
            return false;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean validateR(HttpServletRequest req, String[] arrR){
        try {
            List<Float> validR = new ArrayList<Float>();
            for(String r:arrR){
                float floatR = Float.parseFloat(r);
                for (float allowedR : ALLOWED_R) {
                    if (floatR == allowedR) {
                        validR.add(floatR);
                    }
                }
                if(validR.size()>0){
                    req.setAttribute(KEY_R,validR);
                }
            }
            return validR.size()>0;
        }catch (NumberFormatException e){
            System.out.println("ERROR - R");
            return false;
        }
    }
}
