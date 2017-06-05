/**
 * Created by oleg on 4/14/16.
 */
public class Switches {

    public static void main(String[] args) {
        String a = "AaAaAaAa";
        String b = "AaAaAaBB";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        String test = "AaAaAaAa";
        switch (test){
            case "AaAaAaAa":
                System.out.println(1);
                break;
            case "AaAaAaBB":
                System.out.println(2);
                break;
            default:
                System.out.println(3);
                break;
        }

    }
}
