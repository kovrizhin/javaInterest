/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 4/15/15
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestString {

    public static class HolderString {
        public String string;

        public HolderString(String string) {
            this.string = string;
        }
    }

    public static void main(String[] args) {
        HolderString a1 = new HolderString("a1");
        HolderString a2 = new HolderString(args[0]);
        String intern = a1.string.intern();
        a2.string.intern();
        System.out.println(a1.string == a2.string);



//        System.out.println(a1 instanceof HolderString);
    }

    public static void doIt(String String) { //1
        int i = 10;
        i : for (int k = 0 ; k< 10; k++) { //2
            System.out.println( String + i); //3
            if( k*k > 10) continue i; //4
        }
    }

}


