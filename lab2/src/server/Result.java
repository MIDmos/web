package server;

public class Result {
    private final float x,y,r;
    private final boolean inside;

    public Result(float x, float y, float r, boolean inside) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.inside = inside;
    }

    @Override
    public String toString() {
        return "<tr>"+tdString(x)+ tdString(y) + tdString(r)+ tdString(inside?"Есть пробитие":"Мимо")+"</tr>";
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
