package hackerTest;

import java.util.Date;
import java.util.Optional;

public class FlatMapTest {

  @Deprecated
  public static void main(String[] args) {
//    Optional.of("")
//        .flatMap(FlatMapTest::getOptional)
//        .orElseGet(() -> getOptional)
    String format = String
        .format("Configuration not fount for customer %s and language %s.", "test a", "test b");
    System.out.println(format);
  }


  public static Optional<String> getOptionalNull(String a){
    return Optional.empty();
  }

  public static Optional<String> getOptional(String b){
    return Optional.of(new Date().toString());
  }
}
