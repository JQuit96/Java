/**
 * Point class
 * Created by Julian D. Quitian on 12/31/2015.
 */
import java.util.Comparator;

public class Point {
    private double x, y;
    public static final Comparator<Point> sortX = new compareX();
    public static final Comparator<Point> sortY = new compareY();

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

    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }

    private static class compareX implements Comparator<Point>{
        //comparator for comparing x-coordinates
        public int compare(Point o1, Point o2) {
            if (o1.x < o2.x) return -1;
            if (o1.x > o2.x) return +1;
            return 0;
        }
    }

    private static class compareY implements Comparator<Point>{
        //comparator for comparing y-coordinates
        public int compare(Point o1, Point o2) {
            if (o1.y < o2.y) return -1;
            if (o1.y > o2.y) return +1;
            return 0;
        }
    }
}
