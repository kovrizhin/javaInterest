package regexp;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitTest {

    final private Pattern pattern = Pattern.compile("(.*?)(\\d+)(.*)");
//    Matcher matcher = pattern.matcher(line);

    public static void main(String[] args) {
        String s = "oleg test";
        String[] split = s.split("(oleg)(test)");
        System.out.println(Arrays.toString(split));

    }
}
