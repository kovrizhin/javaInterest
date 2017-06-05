import java.util.Arrays;

/**
 * Created by oleg on 8/17/16
 */
public class MergeSort {


    public int[] sort(int[] input){
        if (input.length >= 2) {
            int sizeFirst = input.length / 2;
            int sizeSecond = input.length - sizeFirst;
            int[] first = new int[sizeFirst];
            int[] second = new int[sizeSecond];
            System.arraycopy(input, 0, first, 0, sizeFirst);
            System.arraycopy(input, sizeFirst, second, 0, sizeSecond);
            sort(first);
            sort(second);
            return merge(input, first, second);

        } else {
            return input;
        }


    }

    private int[] merge(int[] input, int[] first, int[] second) {
        int indexFirst = 0;
        int indexSecond = 0;
        for (int i = 0; i < input.length; i++) {
            if (indexSecond >= second.length ||(indexFirst < first.length && (first[indexFirst] <= second[indexSecond]))) {
                input[i] = first[indexFirst++];
            } else {
                input[i] = second[indexSecond++];
            }
        }
        return input;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MergeSort().sort(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(new MergeSort().sort(new int[]{1, 2, 4, 5, 6, 7, 8, 9, 3})));
        System.out.println(Arrays.toString(new MergeSort().sort(new int[]{9,8,7,6,5,4,3,2,1})));
        System.out.println(Arrays.toString(new MergeSort().sort(new int[]{100, 1231,4364,2341,6865,352,56960,76,235,241,3,645,89})));
    }
}
