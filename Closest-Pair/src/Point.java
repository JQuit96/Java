/**
 * Point class
 * Created by Julian D. Quitian on 12/31/2015.
 */
public class Point {
    private double x, y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getDistance(Point other){
        double distance = Math.sqrt(Math.pow(this.x - other.x, 2) + (Math.pow(this.y - other.y, 2)));
        return distance;
    }
    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }
}
