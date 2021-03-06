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

import com.sun.org.apache.xpath.internal.SourceTree;

import java.time.LocalDateTime;
import java.util.*;

public class MaximizingMissionPoints3 {
    public static void main(String[] args) {
        TreeMap<Integer, Point> floors = new TreeMap<>();
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
        }
        Set<Integer> set = floors.keySet();
        Integer[] levels = set.toArray(new Integer[set.size()]);
        TreeSet<Point> prevPointsX = new TreeSet<>(Comparator.comparingLong(o -> o.points));
        for (Integer level : levels) {

//            int start = LocalDateTime.now().getNano();
            Point pointsX = floors.get(level);
            Iterator<Point> iterator = prevPointsX.descendingIterator();
            while (iterator.hasNext()) {
                Point prevItem = iterator.next();

                if (Math.abs(pointsX.x - prevItem.x) <= d_lat) {
                    if (Math.abs(pointsX.y - prevItem.y) <= d_long) {
                        if (pointsX.points + prevItem.points > pointsX.points) {
                            pointsX.points = pointsX.points + prevItem.points;
                        }
                        break;
                    }
                }
            }
            if(pointsX.points > 0) {
                prevPointsX.add(pointsX);
            }
            int stop = LocalDateTime.now().getNano();
//            double dur = (stop - start) / 1_000_000_000.;
//            System.out.println("Level :" + level + " duration: " + dur);
        }
        System.out.println(floors.values().stream().mapToLong(Point::getPoints).max().getAsLong());

        in.close();
    }
    static class Point {
        final int x;
        final int y;
        long points;
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
