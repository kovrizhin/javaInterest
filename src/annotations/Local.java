package annotations;

/**
 * Created by oleg on 2/7/17
 */
public class Local {
    int a;
    public class Inner{
        int a;
        Inner that;
        {
            try {
                that = new Inner();
                this.a = Local.this.a++;
                System.out.println(a);
            } catch (StackOverflowError s) {
                System.out.println("StackOverflowError");
            }
        }
        {
            System.out.println(a);
        }
    }
}
