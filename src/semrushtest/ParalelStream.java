package semrushtest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

/**
 * Created by oleg on 10/17/16
 */
public class ParalelStream {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        Integer result
                =
 forkJoinPool
                .submit(() ->
                        IntStream
                                .range(1, 2000)
                                .parallel()
                                .reduce((x, y) -> x + y)
                                .orElse(0)

                ).get()
 ;
        System.out.println(result);

    }

}
