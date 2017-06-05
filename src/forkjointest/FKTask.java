package forkjointest;

import java.util.concurrent.ForkJoinTask;

/**
 * Created by oleg on 5/19/16.
 */
public class FKTask extends ForkJoinTask<Integer> {
    @Override
    public Integer getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Integer value) {

    }

    @Override
    protected boolean exec() {
        return false;
    }
}
