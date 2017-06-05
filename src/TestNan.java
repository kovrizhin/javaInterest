/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 5/26/15
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestNan {
    public static void main(String[] args) {
        Float f1 = new Float(Float.NaN);
        Float f2 = new Float(Float.NaN);
        System.out.println( ""+ (f1 == f2)+" "+f1.equals(f2)+ " "+(Float.NaN == Float.NaN));
    }
}
