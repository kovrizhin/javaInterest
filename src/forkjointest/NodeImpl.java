package forkjointest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by oleg on 5/19/16.
 */
public class NodeImpl implements Node {
    private List<Node> nodes;

    @Override
    public Collection<Node> getChildren() {
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        return nodes;
    }

    @Override
    public long getValue() {
        return 1;
    }
}
