/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 6/4/14
 * Time: 3:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestExtended {
    public static void main(String[] args) {
        TestExtended2 extended2 = new TestExtended2();
        extended2.say();
        ((TestExtended) extended2).say();
    }

    public void say(){
        InnerClass inner = new InnerClass();
        inner.sayHello();
    }
    private static class InnerClass{
        public void sayHello() {
            System.out.println("Hello");
        }
    }
}
