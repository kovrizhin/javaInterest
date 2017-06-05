/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 6/24/14
 * Time: 6:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Increment {
    public static void main(String[] args) {
        Increment increment = new Increment();
        increment.recurs(0);
    }

    public  void recurs(int i){
        System.out.println(i);
        recurs(i++);
    }
}
