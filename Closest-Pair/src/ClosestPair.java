/**
 * Created by Julian D. Quitian on 1/1/2016.
 */
public class ClosestPair {
    private static Point[] closestPair = new Point[2];

    public static Point[] bruteForce(Point[] points) {
        double minDistance = Double.MAX_VALUE;
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j++){
                if(i == j) continue;
                if(points[i].getDistance(points[j]) < minDistance) {
                    minDistance = points[i].getDistance(points[j]);
                    closestPair[0] = points[i];
                    closestPair[1] = points[j];
                }
            }
        }
        return closestPair;
    }
    public static Point[] divideAndConquer(Point[] Points){

        return closestPair;
    }
    public static void main(String[] args){
        Point x = new Point(0,0), y = new Point(0,0);
        Point[] a = {new Point(1, -5.5), new Point(5, 3.4), new Point(4, 9), new Point(-.1, .2), new Point(0, .1)};
        x = bruteForce(a)[0];
        y = bruteForce(a)[1];
        System.out.println(x.toString() + " and " + y.toString());
    }
}