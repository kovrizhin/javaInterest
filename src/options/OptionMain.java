package options;

import java.util.Optional;

/**
 * Created by oleg on 5/19/17
 */
public class OptionMain {
    public static void main(String[] args) {
        Optional<String> asd = Optional.of("asd");
        asd.flatMap(s -> Optional.of(s.getBytes()));
    }

}
