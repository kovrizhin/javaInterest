import java.io.Serializable;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 1/18/14
 * Time: 8:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class charArray implements Serializable{

    String a = "aaaa";
    String b = "aaaa";

    private static final long serialVersionUID = 7674750638197525650L;

    public static void main(String[] args) {
        char[] charArray = new char[100]; // something like  input from keybord
        Arrays.fill(charArray, 'a');
        int arraySize = 10;
        int countInput = 0;
        char[] inputArray  = new char[arraySize];
        for (char c : charArray) {

            if(countInput > arraySize -1){
                arraySize = arraySize * 2;
                inputArray = allocateNewArrayAndCopyValues(arraySize, inputArray);
            }
            inputArray[countInput] = c;
            countInput++;
        }
        System.out.println(inputArray);

    }

    private static char[] allocateNewArrayAndCopyValues(int arraySize, char[] inputArray) {
        char[] newCharArray = new char[arraySize];
        for (int i = 0; i < inputArray.length; i++) {
            char c = inputArray[i];
            newCharArray[i] = c;
        }
        return newCharArray;
    }
}
