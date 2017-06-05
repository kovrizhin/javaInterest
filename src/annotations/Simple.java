package annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Created by oleg on 2/7/17
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Simple {
    final static String tet = Test.wtf();
//    String value() default tet;
    String test();


    public class Test {
        public static String wtf(){
            return "wtf";
        }
    }
}
