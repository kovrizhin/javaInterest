package sbertech;

/**
 * Created by oleg on 10/17/16
 */
public class ExceptionHandler {
    public static void main(String[] args) {
        System.out.println(new ExceptionHandler().foo());
    }

    public int foo(){
        try {
            throw new Exception();
        } catch (Exception e) {
            throw e;
        } finally {
            return 1;
        }

    }
}
