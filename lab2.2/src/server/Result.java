package server;

public class Result {
    private float x,y,r;
    private boolean inside;
    private String color;
    private boolean correct;

    public Result(){
        correct=false;
    }

    public Result(float x, float y, float r, boolean inside) {
        correct=true;
        this.x = x;
        this.y = y;
        this.r = r;
        this.inside = inside;
        int key = (int)(r*2);
        switch (key){
            case 2:
                color="#00FF00";
                break;
            case 3:
                color="#0000FF";
                break;
            case 4:
                color="#FFF000";
                break;
            case 5:
                color="#F000FF";
                break;
            default:
                color="#FF0000";
        }

    }

    @Override
    public String toString() {
        if (correct) return "<tr>"+tdString(x)+ tdString(y) + tdString(r)+ tdString(inside?"Есть пробитие":"Мимо")+"</tr>";
        else return "<tr><td colspan='6'><b>Неверные аргументы</b></td></tr>";
    }

    public String drawPoint(){
        if(correct) {
            String strR = String.format("%.1f", r).replace(",", ".");
            String strX = String.format("%.4f", x / r).replace(",", ".");
            String strY = String.format("%.4f", y / r).replace(",", ".");
            return String.format("drawPoint(%s,%s,%s,\'%s\');", strR, strX, strY, color);
        }else return "";
    }

    private String tdString(Object s){
        return String.format("<td>%s</td>",s.toString());
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public boolean isInside() {
        return inside;
    }
}
