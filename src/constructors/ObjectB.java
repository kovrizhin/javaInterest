package constructors;

/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 6/30/15
 * Time: 1:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class ObjectB  extends ObjectA{
    protected Integer a;

    public ObjectB(Boolean bool) {
//        super(bool);
        this(bool, 4);

    }

    protected ObjectB(Boolean bool, Integer in) {
        super(bool, in);
        a = 10;
    }

    public static void main(String[] args) {
        new ObjectB(true).printA();

    }
}
