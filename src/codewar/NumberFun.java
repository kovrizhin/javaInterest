package codewar;

public class NumberFun {
    public static long findNextSquare(long sq) {
        double sqrt = Math.sqrt(sq);
        if(((sqrt == Math.floor(sqrt)) && !Double.isInfinite(sqrt))){
            return (long) Math.pow(sqrt+1, 2);
        } else {
            return -1;
        }
    }
}
