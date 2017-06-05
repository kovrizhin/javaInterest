/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 8/4/14
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestSingleTone {
    public static final TestSingleTone INSTANCE = getInstance();


    private static TestSingleTone getInstance() {
        System.out.println("Initialize");
        return new TestSingleTone();
    }
}
