import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * Created by oleg on 5/17/16.
 */
public class MethodHandler {

    public volatile Long a = 10L;
    public volatile long b = 10L;

    public static void main(String[] args) throws Throwable {

        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle concat = lookup.findVirtual(String.class, "concat", MethodType.methodType(String.class, String.class));
        MethodHandle f = concat.bindTo("f");
        String o = (String) concat.invoke("a", "b");
        String c = (String) f.invoke("b");
        System.out.println(o);
        System.out.println(c);

    }
}
