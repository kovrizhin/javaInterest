package hackerTest;

import java.io.IOException;
import java.util.*;

public class TaskScheduling3 {


  static int taskScheduling(int d, int m) {
    return d - m;

  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    int t = Integer.parseInt(scanner.nextLine().trim());
    int[][] tasks = new int[t][4];
    int count1 = 0;
    int res = 0;
    int capacity = 0;
    for (int tItr = 0; tItr < t; tItr++) {
      String[] dm = scanner.nextLine().split(" ");
      int d = Integer.parseInt(dm[0].trim());
      int m = Integer.parseInt(dm[1].trim());
      int[] task = {d, m, 0, 0};

      int position = Math
          .abs(Arrays.binarySearch(tasks, 0, tItr, task, Comparator.comparingInt((v) -> v[0])) + 1);
//            System.out.println("position: " + position);

      int prev = position - 1;
      int count = prev >= 0 ? tasks[prev][3] : 0;
//            if(tItr < 10) {
      int test = count + task[1] - task[0];
      if (prev > 1 && test > task[0] && test > res) {
        count = count + tasks[prev][1];
        test = count - tasks[prev][0];
        if (count >= tasks[prev][0] && test > res) {
          res = test;
        }
        tasks[prev][2] = res;
        tasks[prev][3] = count;
      } else {
        System.arraycopy(tasks, position, tasks, position + 1, tItr - position);
        count1++;
        tasks[position] = task;
        for (int i = position; i < count1; i++) {
          count = count + tasks[i][1];
          test = count - tasks[i][0];
          if (count >= tasks[i][0] && test > res) {
            res = test;
          }
          tasks[i][2] = res;
          tasks[i][3] = count;
        }
      }
      System.out.println(res);
//            } else {
//                if(position == tItr - 1){
//                    if(res + maxDeadLine < task[position][0] ){
//
//                    }
///                } else
    }
  }

}
/*
*
3
47 778
20 794
32 387


9406 290    |   0
5640 989    |   0
15413 796   |   0
7144 145    |   0
8278 391    |   0
1291 341    |   0
12798 570   |   0
15011 233   |   0
8718 43     |   0
14097 118   |   0
11696 762   |   0
9986 310    |   0
12815 426   |   0
9285 368    |   0
5966 235    |   0
3787 627    |   0
7965 58     |   0
10295 169   |   0
13158 359   |   0
1057 387    |   0
15605 347   |   0
13127 995   |   0
13557 553   |   0
3643 530    |   0
14171 291   |   0
14656 971   |   0
7868 81     |   0
14768 594   |   0
12978 628   |   0
11385 887   |   0
14487 356   |   0
193 91      |   0
6421 480    |   0
7243 970    |   0

*/





