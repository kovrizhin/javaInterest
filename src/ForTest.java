import java.util.ArrayList;

/**
 * Created by oleg on 8/16/16
 */
public class ForTest {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        arrayList.add(0);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.add(1);
        }

        System.out.println(arrayList);
    }
}
