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

public class MaximizingMissionPoints {

    public static void main(String[] args) {
        TreeMap<Integer, List<Point>> floors = new TreeMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d_lat = in.nextInt();
        int d_long = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            int latitude = in.nextInt();
            int longitude = in.nextInt();
            int height = in.nextInt();
            int points = in.nextInt();
            floors.putIfAbsent(height, new ArrayList<>());
            floors.get(height).add(new Point(latitude, longitude, points));
        }
        int prev = -1;
        for (Integer integer : floors.keySet()) {
            List<Point> prevPoints = floors.get(prev);
            if(prevPoints != null) {
                List<Point> points = floors.get(integer);
                List<Point> save = new ArrayList<>();
                for (Point point : points) {
                    int max = point.points;
                    for (Point prevPoint : prevPoints) {
                        if (Math.abs(point.x - prevPoint.x) <= d_lat && Math.abs(point.y - prevPoint.y) <= d_long) {
                            max = Math.max(max, point.points + prevPoint.points);
                        }
                        if(prevPoint.points > 0){
                            save.add(prevPoint);
                        }
                    }
                    point.points = max;
                }
                points.addAll(save);
            }
            prev = integer;
        }
        System.out.println(floors.values().stream().flatMap(Collection::stream).mapToInt(Point::getPoints).max().getAsInt());

        in.close();
    }

    static class Point {
        final int x;
        final int y;
        int points;

        public Point(int x, int y, int points) {
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
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + points;
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", points=" + points +
                    '}';
        }

        public int getPoints() {
            return points;
        }
    }
}
