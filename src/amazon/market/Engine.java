package amazon.market;

import com.sun.istack.internal.NotNull;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Engine {
    public boolean process(@NotNull String[] customer, @NotNull String[][] market);
}
