package unsafe;

import sun.misc.Unsafe;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;
import java.util.HashSet;

import static sun.nio.ch.IOStatus.normalize;

/**
 * Created by oleg on 9/19/16
 */
public class UnsafeTest {

    public static void main(String[] args) throws Exception {
        Unsafe unsafe = getUnsafe();
        System.out.println(unsafe);

        A o = (A) unsafe.allocateInstance(A.class);
        System.out.println(o.a());

        Guard guard = new Guard();
        guard.giveAccess();   // false, no access

        Field field = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
        unsafe.putInt(guard, unsafe.objectFieldOffset(field), 42); // memory corruption

        System.out.println(guard.giveAccess()); // true, access granted


//        long intClassAddress = normalize(getUnsafe().getInt(new Integer(0), 8L));
//        long strClassAddress = normalize(getUnsafe().getInt("", 8L));
//        getUnsafe().putAddress(intClassAddress + 40, strClassAddress);
//
//        String s = (String) (Object) (new Integer(666));
//        System.out.println(s);


        File f1 = new File("/home/oleg/Project/TestApp/out/production/TestApp/unsafe/TestAClass.class");
        byte[] classContents = getClassContent(f1);
        Permissions perms=new Permissions();
        perms.add(new RuntimePermission("accessDeclaredMembers"));
        ProtectionDomain protection = new ProtectionDomain(new CodeSource(f1.toURI().toURL(),(Certificate[])null),perms);
        Class c = getUnsafe().defineClass(null, classContents, 0, classContents.length, UnsafeTest.class.getClassLoader(),protection);
        System.out.println(c.getMethod("hello").invoke(c.newInstance(), null));


    }

    private static byte[] getClassContent(File f1) throws Exception {
        File f = f1;
        FileInputStream input = new FileInputStream(f1);
        byte[] content = new byte[(int)f1.length()];
        input.read(content);
        input.close();
        return content;
    }

    private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }

    class A {
        private long a; // not initialized value

        public A() {
            this.a = 1; // initialization
        }

        public long a() { return this.a; }
    }

    static class Guard {
        private int ACCESS_ALLOWED = 1;

        public boolean giveAccess() {
            return 42 == ACCESS_ALLOWED;
        }
    }

    static Object shallowCopy(Object obj) throws NoSuchFieldException, IllegalAccessException {
        long size = sizeOf(obj);
        long start = toAddress(obj);
        long address = getUnsafe().allocateMemory(size);
        getUnsafe().copyMemory(start, address, size);
        return fromAddress(address);
    }

    static long toAddress(Object obj) throws NoSuchFieldException, IllegalAccessException {
        Object[] array = new Object[] {obj};
        long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
        return normalize(getUnsafe().getInt(array, baseOffset));
    }

    static Object fromAddress(long address) throws NoSuchFieldException, IllegalAccessException {
        Object[] array = new Object[] {null};
        long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
        getUnsafe().putLong(array, baseOffset, address);
        return array[0];
    }

    private static long normalize(int value) {
        if(value >= 0) return value;
        return (~0L >>> 32) & value;
    }

    public static long sizeOf(Object object) throws NoSuchFieldException, IllegalAccessException {
        return getUnsafe().getAddress(
                normalize(getUnsafe().getInt(object, 4L)) + 12L);
    }

    public static long sizeOfCalc(Object o) throws NoSuchFieldException, IllegalAccessException {
        Unsafe u = getUnsafe();
        HashSet<Field> fields = new HashSet<Field>();
        Class c = o.getClass();
        while (c != Object.class) {
            for (Field f : c.getDeclaredFields()) {
                if ((f.getModifiers() & Modifier.STATIC) == 0) {
                    fields.add(f);
                }
            }
            c = c.getSuperclass();
        }

        // get offset
        long maxSize = 0;
        for (Field f : fields) {
            long offset = u.objectFieldOffset(f);
            if (offset > maxSize) {
                maxSize = offset;
            }
        }

        return ((maxSize/8) + 1) * 8;   // padding
    }


}
