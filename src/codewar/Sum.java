package codewar;

import java.util.stream.IntStream;

public class Sum
{
    public int GetSum(int a, int b)
    {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return IntStream.range(min, max + 1).sum();
        //Good luck!
    }
}
