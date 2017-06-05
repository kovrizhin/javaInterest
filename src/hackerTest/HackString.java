//package hackerTest;
//
//import java.util.HashMap;
//import java.util.Set;
//
///**
// * Created by oleg on 8/16/16
// */
//public class HackString {
//    public static final double MOD = 10e9 + 7;
//    static String input = "kkkkkkz";
//    static Integer out = 15;
//    static HashMap<Character, Integer> hashMap = new HashMap<>();
//
//
//
//    public static void main(String[] args) {
//        Long comb = 0l;
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            input.
//            if(hashMap.containsKey(c)){
//                Integer integer = hashMap.get(c);
//                hashMap.put(c, integer +1);
//            } else {
//                hashMap.put(c, 1);
//            }
//        }
//
//        Set<Character> characters = hashMap.keySet();
//        for (Character character : characters) {
//            Integer integer = hashMap.get(character);
//            if(integer > 4){
//                comb += fact(integer)/ (24 * fact((integer - 4)));
//            } else if(integer == 4){
//                comb += 1;
//            }
//            Double v = comb % MOD;
//            comb = v.longValue();
//        }
//        System.out.println(comb);
//
//    }
//
//    private static int fact(Integer integer) {
//        Integer fac = 1;
//        for (int i = 2; i <= integer; i++) {
//             fac *= i;
//        }
//        return fac;
//    }
//}
