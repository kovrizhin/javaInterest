package hackerTest;

import java.io.IOException;
import java.util.*;

public class TaskScheduling4 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 1; i <= 100000 + 1; i++) {
            free.add(i);
        }

        int t = Integer.parseInt(scanner.nextLine().trim());
        int res = 0;
        for (int tItr = 0; tItr < t; tItr++) {
            String[] dm = scanner.nextLine().split(" ");
            int d = Integer.parseInt(dm[0].trim());
            int m = Integer.parseInt(dm[1].trim());

            Integer first = free.higher(d);
            Integer last = first;

            while (!Objects.equals(first, free.first()) && m > 0) {
                first--;
                m--;
            }
            Integer finalFirst = first;
            free.removeIf((b) -> b < last && b >= finalFirst);

            res += m;
            System.out.println(res);
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





