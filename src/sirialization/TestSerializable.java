package sirialization;

import java.io.*;

/**
 * Created by oleg on 9/3/15.
 */
public class TestSerializable {


    public static void main(String[] args) {

        ClassA a = new ClassA();
        ClassA b = new ClassA();
        a.setI(ClassB.CLASS_B);
        b.setI(ClassB.CLASS_B);
        System.out.println(a.getI() == b.getI());


        try {
            FileOutputStream fos = new FileOutputStream("temp.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(b);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("temp.out");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ClassA bD = (ClassA) ois.readObject();
            ois.close();
            System.out.println(b.getI() == bD.getI());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
