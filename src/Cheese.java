/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 5/25/14
 * Time: 1:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cheese {
    public static void main(String[] args) {
        int maxHeight = 7, maxWeight = 7;
        int[][] tableMove = new int[8][8];
        String[][] tablePoint = new String[8][8];
        int[][][] tablePreviosMove = new int[8][8][2];
        int[][] move = {{-1, 2},
                        {1, 2},
                        {2, 1},
                        {2, -1},
                        {1, -2},
                        {-1, -2},
                        {-2, -1},
                        {-2, 1}
        };
        for (int i = 0; i < tableMove.length; i++) {
            tableMove[i] = new int[8];
            for (int j = 0; j < tableMove[i].length; j++) {
                tableMove[i][j] = 9;
            }
        }
        for (int i = 0; i < tablePoint.length; i++) {
            tablePoint[i] = new String[8];
            for (int j = 0; j < tablePoint[i].length; j++) {
                tablePoint[i][j] = "XXX";
            }
        }
        for (int i = 0; i < tablePreviosMove.length; i++) {
            int[][] ints = tablePreviosMove[i];
            ints = new int[8][2];
            for (int j = 0; j < ints.length; j++) {
                ints[j] = new int[2];
                ints[j][0] = 9;
                ints[j][1] = 9;
            }
        }
        int[] enterPoint = {1,1};
        int[] outPutPoint = {6,6};
        tableMove[enterPoint[0]][enterPoint[1]] = 1;
        for (int countMove = 1; countMove < 15; countMove++) {
            for (int j = 0; j < tableMove.length; j++) {
                for (int i = 0; i < tableMove[j].length; i++) {
                    if(countMove == tableMove[j][i]){
//                        System.out.println(i + " " + j);
                        for (int countPoint = 0;  countPoint < move.length; countPoint++) {
                            int currentX = i + move[countPoint][0];
                            int currentY = j + move[countPoint][1];
                            if(currentX > 0 && currentX < maxHeight &&
                                currentY > 0 && currentY < maxWeight && tableMove[currentY][currentX] > countMove + 1){
                                tableMove[currentY][currentX] = countMove + 1;
                                tablePoint[currentY][currentX] = (i) + "," + (j);
                                tablePreviosMove[currentY][currentX][0] = (j);
                                tablePreviosMove[currentY][currentX][1] = (i);

                                System.out.println(i + " , " + j + " -> " + currentX + " , " + currentY + " move point =" + move[countPoint][0] + " , " + move[countPoint][1]);
                                if(currentX ==  outPutPoint[0] && currentY == outPutPoint[1]){
                                    System.out.println("Find x = " + currentX + " y = " + currentY + " move = " + (countMove + 1));
                                    printTable(tableMove);
                                    printTable(tablePoint);
                                    printTable(tablePreviosMove);
                                    printMoves(tablePreviosMove, enterPoint, outPutPoint);
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void printMoves(int[][][] tablePreviosMove, int[] enterPoint, int[] outPutPoint) {
        int[] destPoint = outPutPoint;
        for (int j = 0; j < tablePreviosMove.length; j++) {
            for (int i = 0; i < tablePreviosMove[j].length; i++) {
                int[] currentMove = tablePreviosMove[i][j];
                if(i == destPoint[0] && j == destPoint[1]){
                    System.out.println("\n"+ i + " ,,," +j);
                    System.out.println(currentMove[0] + " ,,," +currentMove[1]);
                    if(currentMove[0] == enterPoint[0] && currentMove[1] == enterPoint[1]){
                        System.out.println(currentMove[0] + " ,,," +currentMove[1]);
                        return;
                    }

                    destPoint = currentMove;
                    i = 0;
                    j = 0;
                }
            }
        }
    }

    private static void printTable(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(" " + table[i][j]);

            }

        }
    }
    private static void printTable(int[][][] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(" " + table[i][j][0] + ","  + table[i][j][1]);

            }

        }
    }
    private static void printTable(String[][] table) {
        for (int j = 0; j < table.length; j++) {
            System.out.print("\n");
            for (int i = 0; i < table[j].length; i++) {
                System.out.print(" " + table[j][i]);

            }

        }
    }

}
