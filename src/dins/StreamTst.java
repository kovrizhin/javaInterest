package dins;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by oleg on 10/17/16
 */
public class StreamTst {

    public static void main(String[] args) {
        List<String> array = Arrays.asList("aaa", "bab", "bba", "aab", "aaa", "aba");
        Map<String, String> uppers = array.stream().collect(Collectors.toMap(d -> d, String::toUpperCase));
        System.out.println(uppers);
    }
}
