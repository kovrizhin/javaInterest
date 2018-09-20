package hackerTest;


import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
https://www.hackerrank.com/challenges/short-palindrome/problem

Consider a string, , of  lowercase English letters where each character,  (, denotes the letter at index in . We define an  palindromic tuple of  to be a sequence of indices in  satisfying the following criteria:

, meaning the characters located at indices  and  are the same.
, meaning the characters located at indices  and  are the same.
, meaning that , , , and  are ascending in value and are valid indices within string .
Given , find and print the number of  tuples satisfying the above conditions. As this value can be quite large, print it modulo .

Input Format

A single string denoting .

Constraints

It is guaranteed that  only contains lowercase English letters.
Output Format

Print the the number of  tuples satisfying the conditions in the Problem Statement above. As this number can be very large, your answer must be modulo .

Sample Input 0

kkkkkkz
Sample Output 0

15
Explanation 0

The letter z will not be part of a valid tuple because you need at least two of the same character to satisfy the conditions defined above. Because all tuples consisting of four k's are valid, we just need to find the number of ways that we can choose four of the six k's. This means our answer is .

Sample Input 1

ghhggh
Sample Output 1

4
Explanation 1

The valid tuples are:

Thus, our answer is .

Sample Input 0

kkkkkkz
Sample Output 0

15
Sample Input 1

abbaab
Sample Output 1

4
Sample Input 2

akakak
Sample Output 2

2
Explanation 2

Tuples possible are



 */
public class ShortPalindrome {
    static int shortPalindrome(String s) {
        HashMap<String, Long> symbolCount = new HashMap<>();
        HashMap<String, Long> pairs = new HashMap<>();
        HashMap<String, Long> count = new HashMap<>();
        long result = 0l;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            Character c = s.charAt(i);
            String s1 = c.toString();

            for (char j = 'a'; j < 'z' + 1; j++) {
                String s2 = Character.toString(j);
                if(symbolCount.containsKey(s2)) {
                    result += count.get(s1 + s2) != null ? count.get(s1 + s2): 0l;
                    result %= 1000000009;
                    count.computeIfPresent(s2 + s1, (key, value) -> (value + (pairs.get(key) != null ? pairs.get(key): 0l))% 1000000009);
                    count.putIfAbsent(s2 + s1, pairs.get(s2 + s1));
                    pairs.computeIfPresent(s2 + s1 , (key, value) -> (value + (symbolCount.get(s2) != null ? symbolCount.get(s2): 0l)) % 1000000009);
                    pairs.putIfAbsent(s2 + s1, symbolCount.get(s2));
                }
            }
            symbolCount.computeIfPresent(s1, (key, value) -> value + 1);
            symbolCount.putIfAbsent(s1, 1l);





//            symbolCount.compute(a, (key, value)->{
//                symbolCount.computeIfPresent(rev, (key2 ,value2)->{
//                    pairs.compute(key2, (key3, value3)-> {
//                            if(value3 != null){
//                                 return (value2 + value3) % (1000000009);
//                            } else {
//                                return value2;
//                            }
//                    });
//                    return value2;
//                });
//
//                if (value != null){
//                    return value +1L;
//                } else {
//                    return 1L;
//                }
//
//
//
//            });


        }

//        int res = 0;
//        for (char j = 'a'; j < 'z' + 1; j++) {
//            String s1 = Character.toString(j);
//            pairs.remove(s1);
//            Set<String> strings = pairs.keySet();
//            for (String string : strings) {
//                String s2 = new StringBuilder(string).reverse().toString();
//                res += Math.min(pairs.get)
//            }
//
//        }
        return (int) (result % 1000000009);
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.next();
//        int result = shortPalindrome(s);
//        System.out.println(result);
//        in.close();
        shortPalindrome("kkkkkkz");
    }
}
