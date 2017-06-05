import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

// This is Java code.
public class PigLatin {

    public static String pigLatin(String word) {
        char firstLetter = word.charAt(0);
        if ("aeiou".indexOf(firstLetter) != -1) return word + "ay";
        return word.substring(1) + firstLetter + "ay";
    }

    public static void main(String args[]) {
        System.out.println(pigLatin("red"));
        System.out.println(pigLatin("orange"));


        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("1.00");
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        HashSet<BigDecimal> hashMap = new HashSet<BigDecimal>();
        TreeSet<BigDecimal> treeSet = new TreeSet<BigDecimal>();
        hashMap.add(a);
        hashMap.add(b);

        treeSet.add(a);
        treeSet.add(b);

        System.out.println("a");

    }
}