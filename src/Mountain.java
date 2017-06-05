/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 5/26/15
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Mountain {
        static String name = "Himalaya";
        static Mountain getMountain() {
            System.out.println("Getting Name ");
            return null;
        }
        public static void main(String[ ] args) {
            Integer a = 120;
            Integer b = 120;
            Integer c = 130;
            Integer d = 130;
            System.out.println(a==b);
            System.out.println(c==d);



            System.out.println( getMountain().name );
        }
    }

