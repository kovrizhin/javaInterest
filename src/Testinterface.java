import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 9/26/13
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Testinterface {

    public static void method(Cloneable cloneable){

    }

//    public static void method(Serializable cloneable){
//
//    }



    public static void main(String[] args) {

        TestClonSer testClonSer = new TestClonSer();
        method(testClonSer);
    }


}
class TestClonSer implements Cloneable, Serializable{

}
