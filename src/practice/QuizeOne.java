package practice;

import java.net.Proxy;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Created by oleg on 8/17/16
 */
public class QuizeOne {

    public static void main(String[] args) {
//        new java.lang.reflect.Proxy()
//        Proxy.g
//        java.lang.reflect.Proxy.getProxyClass()
        Scanner in = new Scanner(System.in);
        int firstDay = in.nextInt();
        int firstMonth = in.nextInt();
        int firstYear = in.nextInt();
        int secondDay = in.nextInt();
        int secondMonth = in.nextInt();
        int secondYear = in.nextInt();
        LocalDate firstLocalDate = LocalDate.of(firstYear, firstMonth, firstDay);
        LocalDate secondLocalDate = LocalDate.of(secondYear, secondMonth, secondDay);
        Period until = secondLocalDate.until(firstLocalDate);
        long fine = 0;
        if(until.getYears() > 0){
            fine += 10000 * until.getYears();
        }
        if(until.getMonths() > 0){
            fine += 500 * until.getMonths();
        }
        if(until.getDays() > 0){
            fine += 15 * until.getDays();
        }
        System.out.println(fine);

        List<Object> list = new ArrayList<>();
        Consumer consumer = System.out::println;
    }


}
