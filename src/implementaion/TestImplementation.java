package implementaion;

/**
 * Created by oleg on 1/26/16.
 */
public class TestImplementation implements TestInterface, TestInterface2{
    @Override
    public void test() {

    }

    public static void main(String[] args) {
        TestImplementation testImplementation = new TestImplementation();
        testImplementation.test();
    }
}
