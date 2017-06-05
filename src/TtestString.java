/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 2/25/14
 * Time: 12:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class TtestString {
    public String a = "aaaa";
    public String b = "aaaa";
    public String c = new String("aaaa");
//    public  Integer aa = 127;
//    public  Integer bb = 127;
//    public  Integer cc = 128;
//    public  Integer dd = 128;
    public boolean asdas = true;

    public boolean isAsdas() {
        return asdas;
    }

    public void setAsdas(boolean asdas) {
        this.asdas = asdas;
    }

    public static void main(String[] args) {
        TtestString t = new TtestString();
        System.out.println(t.a == t.b);
        System.out.println(t.a == t.c);
//        System.out.println(t.aa == t.bb);
//        System.out.println(t.cc == t.dd);
        t.b = "a" + "a" + "a" + "a";
        System.out.println(t.a == t.b);
    }
}
