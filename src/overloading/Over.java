package overloading;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

public class Over extends Overload{

    @Override
    public void method(Object o) {
        super.method(o);
    }

//    @Override
    public void method(IOException i) throws Exception {

    }

//    @Override
    public void method(FileNotFoundException f) {
        super.method(f);
    }
}