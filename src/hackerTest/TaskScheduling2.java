package hackerTest;

import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class TaskScheduling2 {

    /*
 * Complete the taskScheduling function below.
 */
    static class Task {
        public int duration;
        public int deadline;
        public int diff;

        public Task(int duration, int deadline, int diff) {
            this.duration = duration;
            this.deadline = deadline;
            this.diff = diff;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "duration=" + duration +
                    ", deadline=" + deadline +
                    ", diff=" + diff +
                    '}';
        }
    }

    static int taskScheduling(int d, int m) {
        return d - m;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());
        TreeMap<Integer, TreeSet<Task>> tasks = new TreeMap<>();

        for (int tItr = 0; tItr < t; tItr++) {
            String[] dm = scanner.nextLine().split(" ");

            int d = Integer.parseInt(dm[0].trim());

            int m = Integer.parseInt(dm[1].trim());

//            int result = taskScheduling(d , m);

            Task task = new Task(m, d, d - m);
            tasks.putIfAbsent(task.diff, new TreeSet<>(Comparator.comparingInt(o2 -> o2.duration)));
            tasks.get(task.deadline).add(task);
            int count = 0;
            int maxDeadline = 0;
            int res = 0;
            for (Integer integer : tasks.keySet()) {
                for (Task taskSchedule : tasks.get(integer)) {
                    int i = count + taskSchedule.duration;
                    int i1 = i - taskSchedule.deadline;
                    System.out.println("i " + i1 + "S: " + count + " d: " + taskSchedule.deadline + " s: " + i + " time to dead line before: " + taskSchedule.diff);
                    count += taskSchedule.duration;
                    if(i > taskSchedule.deadline){
                        res += i - taskSchedule.deadline;

//                        res += taskSchedule.deadline;
//                        maxDeadline = Math.max(maxDeadline, taskSchedule.deadline);
                    }

                }
            }
            res -= maxDeadline;
            System.out.println(task);
            System.out.println(String.valueOf(res));

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





