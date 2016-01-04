/**
 * Closest Pair v1.0.0
 * Created by Julian D. Quitian on 1/2/2016.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Random;

public class ClosestPair {
    private static Point[] closestPair = new Point[2];

    public static double getDistance(Point either, Point other) {
        return Math.sqrt(Math.pow(either.getX() - other.getX(), 2) + (Math.pow(either.getY() - other.getY(), 2)));
    }

    public static Point[] bruteForce(Point[] points) {
        double minDistance = Double.MAX_VALUE;
        double distance;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                distance = getDistance(points[i], points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPair[0] = points[i];
                    closestPair[1] = points[j];
                }
            }
        }
        return closestPair;
    }

    public static Point[] divideAndConquer(Point[] points) {
        Point[] sorted;

        sorted = points;
        Arrays.sort(sorted, Point.sortX);
        return closest(sorted);
    }

    public static Point[] closest(Point[] set) {
        if (set.length <= 3)
            return bruteForce(set);

        Point[] left, right, bestLeft, bestRight;
        double leftDis, rightDis, min;
        int median;

        median = set.length / 2;
        left = new Point[median];
        right = new Point[set.length - median];

        for (int i = 0; i < median; i++)
            left[i] = set[i];
        for (int i = median; i < set.length; i++)
            right[i - median] = set[i];

        bestLeft = closest(left);
        bestRight = closest(right);
        leftDis = getDistance(bestLeft[0], bestLeft[1]);
        rightDis = getDistance(bestRight[0], bestRight[1]);

        if (leftDis < rightDis) {
            closestPair = bestLeft;
            min = leftDis;
        } else {
            closestPair = bestRight;
            min = rightDis;
        }

        //Uses arraylist to find all points in center boundary
        ArrayList<Point> filtered = new ArrayList<Point>();
        double leftBoundary = set[median].getX() - min;
        double rightBoundary = set[median].getX() + min;
        for (int i = 0; i < set.length; i++) {
            if (leftBoundary < set[i].getX() && set[i].getX() < rightBoundary) {
                filtered.add(set[i]);
            }
        }

        //Algorithm
        for (int i = 0; i < (filtered.size() - 1); i++) {
            for (int j = i + 1; j < Math.min(filtered.size(), i + 7); j++) {
                double dist = getDistance(filtered.get(i), filtered.get(j));
                if (dist < min) {
                    min = dist;
                    closestPair[0] = filtered.get(i);
                    closestPair[1] = filtered.get(j);
                }
            }
        }

        return closestPair;
    }

    public static Point[] best(Point[] left, Point[] right) {
        System.out.println("Distance left = " + getDistance(left[0], left[1]));
        System.out.println("Distance right = " + getDistance(right[0], right[1]));
        if (getDistance(left[0], left[1]) < getDistance(right[0], right[1]))
            return left;
        else
            return right;
    }

    public static void main(String[] args) {
        int pointSize = 30000;
        //generate 30 random points for testing
        Point[] a = new Point[pointSize];
        Random ran = new Random();
        for (int i = 0; i < pointSize; i++) {
            a[i] = new Point(ran.nextInt(50000), ran.nextInt(50000));
        }
        for(int i = 0; i < pointSize; i++){
            for(int j = 0; j < pointSize; j++){
                if(j == i);
                else{
                    if(a[i].getX() == a[j].getX() && a[i].getY() == a[j].getY()){
                        a[i].x =+ .1;
                        a[i].y =+ .1;
                    }
                }
            }
        }



        Point[] closestPair = divideAndConquer(a);
        Point[] bruteforce = bruteForce(a);

        System.out.println("By the Brute Force method of O(n^2), the closest points are");
        System.out.println("Point:    x = " + bruteforce[0].getX() + " y= " + bruteforce[0].getY());
        System.out.println("Point:    x = " + bruteforce[1].getX() + " y= " + bruteforce[1].getY());
        System.out.println("The distances between them is " + getDistance(bruteforce[0], bruteforce[1]));
        System.out.println();
        System.out.println("By the divide and conquer method of O(nlog(n)), the closest points are:");
        System.out.println("Point:    x = " + closestPair[0].getX() + " y= " + closestPair[0].getY());
        System.out.println("Point:    x = " + closestPair[1].getX() + " y= " + closestPair[1].getY());
        System.out.println("The distances between them is " + getDistance(closestPair[0], closestPair[1]));

    }
}
