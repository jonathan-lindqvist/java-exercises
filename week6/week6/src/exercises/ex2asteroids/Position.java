package exercises.ex2asteroids;

public abstract class Position {
    private double x;
    private double y;
    private final double width;
    private final double height;
    private double dx;
    private double dy;

    public Position(double x, double y, double width, double height, double dx, double dy){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dx = dx;
        this.dy = dy;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void move(){
        x += dx;
        y += dy;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getMaxX(){
        return x+width;
    }

    public double getMaxY(){
        return y+height;
    }
}
