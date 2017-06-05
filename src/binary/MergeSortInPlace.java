package binary;

import java.util.Arrays;

/**
 * Created by oleg on 8/17/16
 */
public class MergeSortInPlace {


    public int[] sort(int[] input){
        return sort(input, 0, input.length);
    }
    private int[] sort(int[] input, int firstPoint, int secondPoint){
        int size = secondPoint - firstPoint;
        if (size >= 2) {
//            int size = firstPoint + (secondPoint - firstPoint) / 2;
            int firstSize = (int) Math.round(size / 2.0);
            int secondSize = size - firstSize;

            sort(input, firstPoint, firstPoint + firstSize);
            sort(input,  firstPoint + firstSize, firstPoint + size);
            return merge(input, firstPoint, secondPoint, firstSize, secondSize);

        } else {
            return input;
        }


    }

    private int[] merge(int[] input, int firstPoint, int secondPoint, int firstSize, int secondSize) {
        int indexFirst = 0;//firstPoint;
        int indexSecond = 0;//firstPoint + firstSize;
        int startPointFirst = firstPoint;
        int startPointSecond = firstPoint + firstSize;
        boolean leftSwitch =true;
        for (int i = firstPoint; i < firstPoint + Math.round((secondPoint - firstPoint) / 2.); i++) {
            if(leftSwitch){
                if (startPointSecond + indexSecond >= secondPoint ||(startPointFirst + indexFirst < firstPoint + firstSize && (input[startPointFirst + indexFirst] <= input[startPointSecond + indexSecond]))) {
                    input[i] = input[startPointFirst + indexFirst++];
                } else {
                    int temp = input[startPointFirst + indexFirst];
                    input[i] = input[startPointSecond + indexSecond++];
                    input[startPointSecond + indexSecond - 1] = temp;
                    leftSwitch = false;
                }
            } else {
                if (startPointSecond + indexSecond >= secondPoint ||startPointSecond + indexFirst < secondPoint && (input[startPointSecond + indexFirst] <= input[startPointSecond + indexSecond])) {
                    int tmp = input[i];
                    input[i] = input[startPointSecond + indexFirst++];
                    input[startPointSecond + indexFirst - 1] = tmp;
                    if(indexFirst == indexSecond ){
                        leftSwitch = true;
                    }
                } else {
                    int temp = input[startPointFirst  + indexSecond];
                    input[i] = input[startPointSecond + indexSecond++];
                    input[startPointSecond + indexSecond - 1] = temp;
                }
            }
//            if (indexSecond < secondPoint ||(indexFirst < firstPoint + firstSize && (input[indexFirst] <= input[indexSecond]))) {
//                input[i] = input[indexFirst++];
//            } else {
//                input[i] = input[indexSecond++];
//            }
        }
        return input;
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
//        System.out.println(Arrays.toString(new MergeSortInPlace().sort(new int[]{4,3,2,1,8,7,6,9})));
        System.out.println(Arrays.toString(new MergeSortInPlace().sort(new int[]{4,3,2,1,8,7,6,9})));
        System.out.println(Arrays.toString(new MergeSortInPlace().sort(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(new MergeSortInPlace().sort(new int[]{1, 2, 4, 5, 6, 7, 8, 9, 3})));
        System.out.println(Arrays.toString(new MergeSortInPlace().sort(new int[]{1, 2, 3, 7, 8, 4, 2, 6, 9})));
        System.out.println(Arrays.toString(new MergeSortInPlace().sort(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(new MergeSortInPlace().sort(new int[]{9,9,7,6,5,4,3,2,1})));
        System.out.println(Arrays.toString(new MergeSortInPlace().sort(new int[]{100, 1231,4364,2341,6865,352,56960,76,235,241,3,645,89})));
    }
}
