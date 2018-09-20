package hackerTest;

import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem

Consider a matrix with  rows and  columns, where each cell contains either a  or a  and any cell containing a  is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally; in other words, cell  is connected to cells , , , , , , , and , provided that the location exists in the matrix for that .

If one or more filled cells are also connected, they form a region. Note that each cell in a region is connected to zero or more cells in the region but is not necessarily directly connected to all the other cells in the region.

Task
Given an  matrix, find and print the number of cells in the largest region in the matrix. Note that there may be more than one region in the matrix.

Input Format

The first line contains an integer, , denoting the number of rows in the matrix.
The second line contains an integer, , denoting the number of columns in the matrix.
Each line  of the  subsequent lines contains  space-separated integers describing the respective values filling each row in the matrix.

Constraints

Output Format

Print the number of cells in the largest region in the given matrix.

Sample Input

4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0
Sample Output

5
Explanation

The diagram below depicts two regions of the matrix; for each region, the component cells forming the region are marked with an X:

X X 0 0     1 1 0 0
0 X X 0     0 1 1 0
0 0 X 0     0 0 1 0
1 0 0 0     X 0 0 0
The first region has five cells and the second region has one cell. Because we want to print the number of cells in the largest region of the matrix, we print .
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConnectedCellInaGrid {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for (int matrix_i = 0; matrix_i < n; matrix_i++) {
            for (int matrix_j = 0; matrix_j < m; matrix_j++) {
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        int result = connectedCell(matrix);
        System.out.println(result);
        in.close();
    }

    private static int connectedCell(int[][] matrix) {
        Set<Point> observedPoints = new HashSet<>();
        int maxValues = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                int cell = matrix[i][j];
                if(cell == 1 && !observedPoints.contains(new Point(i, j))){
                    Set<Point> aria = handleAria(matrix, i, j, matrix.length, row.length);
                    observedPoints.addAll(aria);
                    maxValues = Math.max(aria.size(), maxValues);
                }
            }
        }
        return maxValues;
    }

    private static Set<Point> handleAria(int[][] matrix, int i, int j, int sizeX, int sizeY) {
        Set<Point> aria = new HashSet<>();
        Stack<Point> stackAria = new Stack<>();
        stackAria.push(new Point(i,j));
        while ( !stackAria.empty()){
            Point pop = stackAria.pop();
            aria.add(pop);
            Set<Point> neighborhoods= findAllNeighborhoods(pop, matrix, sizeX, sizeY);
            for (Point neighborhood : neighborhoods) {
                if(!aria.contains(neighborhood) && !stackAria.contains(neighborhood)){
                    stackAria.push(neighborhood);
                }
            }
        }
        return aria;
    }

    private static Set<Point> findAllNeighborhoods(Point pop, int[][] matrix, int sizeX, int sizeY) {
        Set<Point> neighborhoods = new HashSet<>();
        if (pop.x - 1 >= 0 && pop.y - 1 >= 0 && matrix[pop.x - 1][pop.y - 1] == 1) {
            neighborhoods.add(new Point(pop.x - 1, pop.y - 1));
        }
        if (pop.x - 1 >= 0 && matrix[pop.x - 1][pop.y] == 1) {
            neighborhoods.add(new Point(pop.x - 1, pop.y));
        }
        if (pop.x - 1 >= 0 && pop.y + 1 < sizeY && matrix[pop.x - 1][pop.y + 1] == 1) {
            neighborhoods.add(new Point(pop.x - 1, pop.y + 1));
        }
        if (pop.y + 1 < sizeY && matrix[pop.x ][pop.y + 1] == 1) {
            neighborhoods.add(new Point(pop.x, pop.y + 1));
        }
        if (pop.x + 1 < sizeX && pop.y + 1 < sizeY && matrix[pop.x +1][pop.y + 1] == 1) {
            neighborhoods.add(new Point(pop.x + 1, pop.y + 1));
        }
        if (pop.x + 1 < sizeX && matrix[pop.x + 1][pop.y] == 1) {
            neighborhoods.add(new Point(pop.x + 1, pop.y));
        }
        if (pop.x + 1 < sizeX && pop.y - 1 >= 0 && matrix[pop.x + 1][pop.y - 1] == 1) {
            neighborhoods.add(new Point(pop.x + 1, pop.y - 1));
        }
        if (pop.y - 1 >= 0 && matrix[pop.x ][pop.y - 1] == 1) {
            neighborhoods.add(new Point(pop.x, pop.y - 1));
        }
        return neighborhoods;
    }

    static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
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
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
