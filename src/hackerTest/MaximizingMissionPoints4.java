package hackerTest;

/*
https://www.hackerrank.com/challenges/maximizing-mission-points/problem
Xander Cage has a list of cities he can visit on his new top-secret mission. He represents each city as a tuple of . The values of , , and  are distinct across all cities.

We define a mission as a sequence of cities, , that he visits. We define the total  of such a mission to be the sum of the  of all the cities in his mission list.

Being eccentric, he abides by the following rules on any mission:

He can choose the number of cities he will visit (if any).
He can start the mission from any city.
He visits cities in order of strictly increasing .
The absolute difference in  between adjacent visited cities in his mission must be at most .
The absolute difference in  between adjacent visited cities in his mission must be at most .
Given , , and the definitions for  cities, find and print the maximum possible total  that Xander can earn on a mission.

Input Format

The first line contains three space-separated integers describing the respective values of , , and .
Each line  of the  subsequent lines contains four space-separated integers denoting the respective , , , and  for a city.

Constraints

Output Format

Print a single integer denoting the maximum possible  that Xander can earn on a mission.

Sample Input 0

3 1 1
1 1 1 3
2 2 2 -1
3 3 3 3
Sample Output 0

5
Explanation 0

Xander can start at city , then go to city , and then go to city  for a maximum value of total

image

Note that he cannot go directly from city  to city  as that would violate his rules that the absolute difference in  between adjacent visited cities be  and the absolute difference in  between adjacent visited cities be . Because  and , he cannot directly travel between those cities.

 */

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MaximizingMissionPoints4 {

    public static final int THRESHOLD_BY_POINTS = 500;

    public static void main(String[] args) {
        TreeMap<Integer, Point> floors = new TreeMap<>();
        TreeSet<Point> pointX = new TreeSet<>(Comparator.comparingInt(o -> o.x));
        TreeSet<Point> pointY = new TreeSet<>(Comparator.comparingInt(o -> o.y));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d_lat = in.nextInt();
        int d_long = in.nextInt();
        int max2 = 0;
        for (int a0 = 0; a0 < n; a0++) {
            int latitude = in.nextInt();
            int longitude = in.nextInt();
            int height = in.nextInt();
            int points = in.nextInt();
            max2 = Math.max(points, max2);
            Point e = new Point(latitude, longitude, points);
            floors.putIfAbsent(height, e);
        }
        int thresh = (int) (max2 - max2 / 3.5);
        TreeSet<Point> prevPoint = new TreeSet<>(Comparator.comparingLong(o -> o.points));
        int switchCounterByPoints = 0;
        int switchCounterByCoordinates = 0;
        SortedSet<Point> prevPointSliceX = null;
        SortedSet<Point> prevPointSliceY = null;
        long maxValue = 0;
        long start = new Date().getTime();
        for (Point point  : floors.values()) {
            if(switchCounterByPoints < THRESHOLD_BY_POINTS) {
                Point fromElement = new Point(point.x - d_lat, point.y - d_long, 0 -point.points);
                Point toElement = new Point(point.x + d_lat, point.y + d_long, 0 -point.points);
                prevPointSliceX = pointX.subSet(fromElement, true, toElement, true);
                prevPointSliceY = pointY.subSet(fromElement, true, toElement, true);
            }
            if(switchCounterByCoordinates > THRESHOLD_BY_POINTS || switchCounterByPoints < THRESHOLD_BY_POINTS && (prevPointSliceX.size() * 50 < prevPoint.size())) {
                long max = 0;
                switchCounterByCoordinates++;
                TreeSet<Point> tempSet = new TreeSet<>(prevPointSliceX);
                tempSet.retainAll(prevPointSliceY);
                    for (Point pointSliceX : tempSet) {
                        if (pointSliceX.points > max) {
                            max = pointSliceX.points;
                        }
                    }
                point.points += max;
            } else {
                switchCounterByPoints++;
                Iterator<Point> iterator = prevPoint.descendingIterator();
                while (iterator.hasNext()) {
                    Point prevItem = iterator.next();
                    if (Math.abs(point.x - prevItem.x) <= d_lat) {
                        if (Math.abs(point.y - prevItem.y) <= d_long) {
                            if (point.points + prevItem.points > point.points) {
                                point.points = point.points + prevItem.points;
                            }
                            break;
                        }
                    }
                }
            }
            if (point.points > thresh) {
                if(point.points > maxValue)
                    maxValue = point.points;
                if(switchCounterByCoordinates < THRESHOLD_BY_POINTS) {
                    prevPoint.add(point);
                }
                if(switchCounterByPoints < THRESHOLD_BY_POINTS) {
                    pointX.add(point);
                    pointY.add(point);
                }
            }
        }
        System.out.println(maxValue);
        long stop = new Date().getTime();
        double s= (stop - start) / 1000.;
        System.out.println(s);
        in.close();
    }

    static class Point {
        final int x;
        final int y;
        long points;

        public Point(int x, int y, long points) {
            this.x = x;
            this.y = y;
            this.points = points;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            if (y != point.y) return false;
            return points == point.points;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + (int) (points ^ (points >>> 32));
            return result;
        }
    }
}
