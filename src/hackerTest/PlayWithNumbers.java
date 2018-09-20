package hackerTest;

/*
https://www.hackerrank.com/challenges/playing-with-numbers/problem

Задаётся массив размером . Вы должны ответить на  запросов. Каждый запрос содержит одно число .
Необходимо добавить число  до каждого элемента массива, и определить сумму абсолютных значений в массиве.

Note : Изменения в массиве являются постоянными. Посмотрите на пример для разъяснения.

Формат входных данных

Первая строка содержит число , количество элементов массива.
Вторая строка содержит  целых чисел, разделённых пробелами.
Третья строка содержит число  (количество запросов).
Следующая строка содержит  целых чисел (число ).

Формат выходных данных

Для каждого запроса вывести сумму в новой строке.

Ограничения



ч
и
с
л
о
в
к
а
ж
д
о
м
з
а
п
р
о
с
е

з
н
а
ч
е
н
и
е
э
л
е
м
е
н
т
а
м
а
с
с
и
в
а

Пример входных данных

3
-1 2 -3
3
1 -2 3
Пример выходных данных

5
7
6
Объяснение

После запроса 1 :
После запроса 2 :
После запроса 3 :

Примечание : Входные/выходные данные могут быть большими.


*
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PlayWithNumbers {

    static int numbers[] = new int[4001];
    static long prepCache[] = new long[4001];
//    static int[] playingWithNumbers(int[] arr, int[] queries) {
//        // Complete this function
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        int[] arr = new int[(int)n];
        int max = 0;
        int min = 4000;
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            min = Math.min(min, 2000 - arr[arr_i]);
            max = Math.max(max, 2000 - arr[arr_i]);
            numbers[2000 - arr[arr_i]] += 1;
        }
        int q = in.nextInt();
        int[] queries = new int[q];
        for(int queries_i = 0; queries_i < q; queries_i++){
            queries[queries_i] = in.nextInt();
        }
//        IntStream negativeStream = Arrays.stream(arr, 0, indexZero);

//        int serchZero = 0;
//        int indexZero = Arrays.binarySearch(arr, 0);
//        int sumNeg = Arrays.stream(arr, 0, indexZero).sum();
//        int countNeg = (int) Arrays.stream(arr, 0, indexZero).count();
//
//        int sumPos = Arrays.stream(arr, indexZero, arr.length).sum();
//        int countPos = (int) Arrays.stream(arr, indexZero , arr.length).count();
//        int res= Math.abs(0 * countNeg + sumNeg) + (0 * countPos + sumPos);


        int prev = 0;
//        int origNeg = countNeg;
//        int origPos = countPos;
//        HashMap<Integer, Long> cache = new HashMap<>();
        int finalMin = min;
        int finalMax = max;

        for (int i = 0; i < prepCache.length; i++) {
            long r = 0;
            for (int j = finalMin; j <= finalMax; j++) {
                if (numbers[j] > 0) {
                    r += numbers[j] * Math.abs((2000 - j) + (2000 - i));
                }
            }
            prepCache[i] = r;
        }

        for (int query : queries) {
            prev = prev + query;
            long r = 0;
            if(prev <= 2000 && prev >= -2000){
                r = prepCache[2000 - prev];
            } else if (prev > 2000){
                r = prepCache[0] + n * (prev -2000l);
            } else {
                r = prepCache[4000] + n * (-prev - 2000l);
            }
            System.out.println(Long.toString(r));
        }

//        System.out.println("");


        in.close();
    }
}
