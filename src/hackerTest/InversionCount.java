package hackerTest;

import java.io.*;

public class InversionCount {
    static long merge(int[] arr, int l, int m, int h) {
        int n1 = m - l + 1;
        int n2 = h - m;
        int i = 0, j = 0, k = l;
        long invCount = 0;
        int[] t1 = new int[n1];
        int[] t2 = new int[n2];

        for (i = 0; i < n1; i++)
            t1[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            t2[j] = arr[m + j + 1];
        i = 0;
        j = 0;
        while (i < n1 && j < n2) {
            if (t1[i] <= t2[j])
                arr[k++] = t1[i++];
            else {
                arr[k++] = t2[j++];
                invCount += m - i + 1 - l; //The tricky one
    /* For printing pairs
                for(int ii=i;ii<n1;ii++)
                  System.out.println(t1[ii]+","+t2[j-1]);
    */
            }
        }
        while (j < n2)
            arr[k++] = t2[j++];
        while (i < n1)
            arr[k++] = t1[i++];
        return invCount;
    }

    static long mergeSort(int[] arr, int low, int high) {
        long invCount = 0;
        if (low < high) {
            int mid = (high + low) / 2;

            invCount = mergeSort(arr, low, mid);
            invCount += mergeSort(arr, mid + 1, high);

            invCount += merge(arr, low, mid, high);
        }
        return invCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 2};
        long invCount = mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++)
            System.out.printf(" " + arr[i]);

        System.out.println("\nInversion Count : " + invCount);
    }
}
