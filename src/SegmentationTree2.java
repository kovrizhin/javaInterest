import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.min;

/**
 * Created by oleg on 9/17/18.
 */
public class SegmentationTree2 {
    int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] test = {3, 8, 6, 4, 2, 5, 9, 0, 7, 1};
        int[] tree = build_tree(test);
        String tree_str = Arrays.toString(tree);
        System.out.println(tree_str);
        int min = rmq_up(tree, 1, 9);
        System.out.println(min);
        for (int i = 0; i < test.length; i++) {
            for (int j = i + 1; j < test.length; j++) {

                int ans = rmq_up(tree, i , j );
                int testAns = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    testAns = min(testAns, test[k]);

                }
                System.out.println("i = " + i + " j = " + j + " ans = " + ans + " test = " + testAns);
            }

        }
    }



    static int[]  build_tree(int[] V)
    {

        int n;
        // размер, доведённый до степени двойки
        n = 16;
        int[] tree = new int[2* n];
        Arrays.fill(tree, Integer.MAX_VALUE);
        System.arraycopy(V, 0, tree, 0, V.length);

        // инициализируем листы
        for (int i = n; i < 2 * n; i++)
            tree[i] = tree[i - n];

        // и все остальные вершины
        for (int i = n - 1; i > 0; i--)
            tree[i] = min(tree[2 * i], tree[2 * i + 1]);
        return tree;
    }

    static int rmq_up(int[] T, int l, int r)
    {
        int ans = Integer.MAX_VALUE;
        int n = T.length / 2;
        l += n;
        r += n;
        while (l <= r)
        {
            // если l - правый сын своего родителя,
            // учитываем его фундаментальный отрезок
            if (l % 2 != 0)
                ans = min(ans, T[l]);
            // если r - левый сын своего родителя,
            // учитываем его фундаментальный отрезок
            if (r % 2 == 0)
                ans = min(ans, T[r]);
            // сдвигаем указатели на уровень выше
            l = (l + 1) / 2;
            r = (r - 1) / 2;
        }
        return ans;
    }
}
