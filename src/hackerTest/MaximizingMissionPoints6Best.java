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

import java.util.*;

public class MaximizingMissionPoints6Best {
    public static void main(String[] args) {
        TreeMap<Integer, Point> floors = new TreeMap<>();

        TreeSet<Point> pointAllX = new TreeSet<>(Comparator.comparingInt(o -> o.x));
        TreeSet<Point> pointAllY = new TreeSet<>(Comparator.comparingInt(o -> o.y));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d_lat = in.nextInt();
        int d_long = in.nextInt();

        for (int a0 = 0; a0 < n; a0++) {
            int latitude = in.nextInt();
            int longitude = in.nextInt();
            int height = in.nextInt();
            int points = in.nextInt();
            Point e = new Point(latitude, longitude, points);
            floors.putIfAbsent(height, e);
//            pointAllX.add(e);
//            pointAllY.add(e);
        }
        Set<Integer> set = floors.keySet();
        Integer[] levels = set.toArray(new Integer[set.size()]);
        TreeSet<Point> prevPoint = new TreeSet<>(Comparator.comparingLong(o -> o.points));
        for (Integer level : levels) {

            Point point = floors.get(level);
            Point fromElement = new Point(point.x - d_lat, point.y - d_long, -1);
            Point toElement = new Point(point.x + d_lat, point.y + d_long, -1);
            SortedSet<Point> prevPointSliceX = pointAllX.subSet(fromElement, true, toElement, true);
            SortedSet<Point> prevPointSliceY = pointAllY.subSet(fromElement, true, toElement, true);
            if(prevPoint.size() < pointAllX.size() || prevPoint.size() < pointAllY.size()) {
                Iterator<Point> iterator;
                if (prevPointSliceX.size() < prevPointSliceY.size()) {
                    prevPointSliceX.retainAll(prevPointSliceY);
                    iterator = prevPointSliceX.iterator();
                } else {
                    prevPointSliceY.retainAll(prevPointSliceX);
                    iterator = prevPointSliceY.iterator();
                }

                long max = point.points;
                while (iterator.hasNext()) {
                    Point prevItem = iterator.next();
                    if (Math.abs(point.x - prevItem.x) <= d_lat) {
                        if (Math.abs(point.y - prevItem.y) <= d_long) {
                            max = Math.max(max, point.points + prevItem.points);
                        }
                    }
                }
                point.points = max;
            } else {
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
            if (point.points > 0) {
                prevPoint.add(point);
                pointAllX.add(point);
            }
        }
        System.out.println(floors.values().stream().mapToLong(Point::getPoints).max().getAsLong());

        in.close();
    }

    private static long getValue(int d_lat, int d_long, Point pointsX, Collection<TreeSet<Point>> pointValues) {

        for (TreeSet<Point> pointValue : pointValues) {
            NavigableSet<Point> points = pointValue.headSet(new Point(pointsX.x - d_lat, pointsX.y - d_long, -1), true);
            for (Point point : points) {
                if (Math.abs(pointsX.x - point.x) <= d_lat) {
                    if (Math.abs(pointsX.y - point.y) <= d_long) {
                        if (pointsX.points + point.points > pointsX.points) {
                            return pointsX.points + point.points;
                        }
                    }
                }

            }
        }
        return pointsX.points;
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

        public long getPoints() {
            return points;
        }
    }
}
