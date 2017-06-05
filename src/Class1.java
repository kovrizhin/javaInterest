/**
 * Created by oleg on 5/18/16.
 */
public class Class1 {

    public static void main(String[] args) {
        Class2 threadLock = new Class2();
        threadLock.doSomething();
    }
    public synchronized void  doSomething(){
        synchronized (this) {
            System.out.println("Parent");
        }
    }

    private static class Class2 extends Class1 {
        @Override
        public synchronized void doSomething() {
            System.out.println("Hey");
            super.doSomething();
            System.out.println("Fuck");
        }
    }
}



