import java.io.File;

public class TestPath {
    public static void main(String[] args) {
        System.out.println("start");
        File file = new File("/test");
        System.out.println(file.getAbsolutePath());
    }
}
