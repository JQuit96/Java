/**
 * Closest Pair v1.0.0
 * Created by Julian D. Quitian on 1/2/2016.
 */
import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {
    private static Point[] closestPair = new Point[2];

    public static double getDistance(Point either, Point other){
        double distance = Math.sqrt(Math.pow(either.getX() - other.getX(), 2) + (Math.pow(either.getY() - other.getY(), 2)));
        return distance;

    }
    public static Point[] bruteForce(Point[] points) {
        double minDistance = Double.MAX_VALUE;
        double distance;
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j++){
                if(i == j) continue;
                distance = getDistance(points[i], points[j]);
                if(distance < minDistance) {
                    minDistance = distance;
                    closestPair[0] = points[i];
                    closestPair[1] = points[j];
                }
        }
    }
    return closestPair;
    }
    public static Point[] divideAndConquer(Point[] points){
        Point[] left, right, sorted;

        sorted = points;
        Arrays.sort(sorted, Point.sortX);

        return closest(sorted);
    }
    public static Point[] closest(Point[] set){
        Point[] left, right, bestLeft, bestRight;

        if(set.length < 3)
            return bruteForce(set);

        left = new Point[set.length / 2];
        right = new Point[set.length - set.length / 2];

        for(int i = 0; i < left.length; i++){
            left[i] = set[i];
        }
        for(int i = 0; i < right.length; i++){
            right[i] = set[set.length / 2 + i];
        }

        bestLeft = closest(left);
        bestRight = closest(right);

        return best(bestLeft, bestRight);
    }
    public static Point[] best(Point[] left, Point[] right){
        if(getDistance(left[0], left[1]) < getDistance(right[0], right[1]))
            return left;
        else
            return right;
    }
    public static void main(String[] args){
        Point[] a = {new Point(-50, -50), new Point(34, 68), new Point(-74, 90), new Point(90, -900), new Point(95, -70)};
        Point[] lowest = divideAndConquer(a);
        System.out.println(lowest[0].toString());
        System.out.println(lowest[1].toString());

    }
}
