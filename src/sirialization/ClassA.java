package sirialization;

import java.io.Serializable;

/**
 * Created by oleg on 9/3/15.
 */
public class ClassA implements Serializable {
    private ClassB i;

    public ClassB getI() {
        return i;
    }

    public void setI(ClassB i) {
        this.i = i;
    }
}
