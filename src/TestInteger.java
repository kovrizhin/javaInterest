/**
 * Created by oleg on 7/22/15.
 */
public class TestInteger {
    public static void main(String[] args) {
        String a = "resourses/test";
        String b = new String("tes" + "t").intern();
        System.out.println(a == b);

//        int i1 = new Integer(14);
//        int i2 = new Integer(14);
//        System.out.println(i1 == i2);
    }
}
