package hackerTest;

import javafx.util.Pair;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BikeRaces  {

    /*
     * Complete the bikeRacers function below.
     */
    static long bikeRacers(int[][] bikers, int[][] bikes, int k) {
        long[][] distances = new long[bikes.length][bikers.length];

        for (int j = 0; j < bikes.length; j++) {
            int[] bike = bikes[j];
            for (int i = 0; i < bikers.length; i++) {
                int[] biker = bikers[i];
                distances[j][i] = (long) (Math.pow(biker[1] - bike[1],   2) + Math.pow(biker[0] - bike[0],   2));
            }
        }

        double max = 0.;
        int index = 0;
        TreeSet<long[]> longs = new TreeSet<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0], o2[0]);
            }
        });
        for (int i = 0; i < distances.length; i++) {
            long[] distance = distances[i];
            Arrays.sort(distance);
            long asDouble = Arrays.stream(distance, 0, k).sum();
            longs.add(new long[]{asDouble, i});


            Boolean a = null;
            if(distance.length != 5.){
                a = false;
            }

            Boolean c = a != null? Boolean.TRUE : a;
            System.out.println(c);
        }

        /*
         * Write your code here.
         */
        int i = Math.min(bikers.length, bikes.length);
        return Arrays.stream(distances[(int) longs.last()[1]]).min().getAsLong();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nmk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmk[0].trim());

        int m = Integer.parseInt(nmk[1].trim());

        int k = Integer.parseInt(nmk[2].trim());

        int[][] bikers = new int[n][2];

        for (int bikersRowItr = 0; bikersRowItr < n; bikersRowItr++) {
            String[] bikersRowItems = scanner.nextLine().split(" ");
            for (int bikersColumnItr = 0; bikersColumnItr < 2; bikersColumnItr++) {
                int bikersItem = Integer.parseInt(bikersRowItems[bikersColumnItr].trim());
                bikers[bikersRowItr][bikersColumnItr] = bikersItem;
            }
        }

        int[][] bikes = new int[n][2];

        for (int bikesRowItr = 0; bikesRowItr < n; bikesRowItr++) {
            String[] bikesRowItems = scanner.nextLine().split(" ");

            for (int bikesColumnItr = 0; bikesColumnItr < 2; bikesColumnItr++) {
                int bikesItem = Integer.parseInt(bikesRowItems[bikesColumnItr].trim());
                bikes[bikesRowItr][bikesColumnItr] = bikesItem;
            }
        }

        long result = bikeRacers(bikers, bikes, k);

        System.out.println(String.valueOf(result));
    }
}
