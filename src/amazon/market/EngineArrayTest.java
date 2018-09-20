package amazon.market;

import static org.junit.jupiter.api.Assertions.*;

class EngineArrayTest {
    @org.junit.jupiter.api.Test
    void process() {
        EngineArray EngineArray = new EngineArray();
        String[][] market = {{"apple", "orange", "anything"},{"orange", "apple"}};
        String[] customer = {"apple", "orange", "apple", "carrot","banana","orange", "apple"};
        assertTrue(EngineArray.process(customer, market));

        market = new String[][]{{"apple", "orange"}, {"orange", "apple"}};
        customer = new String[]{"apple", "orange", "apple", "carrot", "banana", "orange"};
        assertFalse(EngineArray.process(customer, market));

        market = new String[][]{{"apple", "orange"}, {"apple", "carrot"}, {"banana", "orange"}};
        customer = new String[]{"apple", "orange", "apple", "carrot", "banana", "orange"};
        assertTrue(EngineArray.process(customer, market));

        market = new String[][]{{"apple", "orange"}, {"aple", "carrot"}, {"banana", "orange"}};
        customer = new String[]{"apple", "orange", "apple", "carrot", "banana", "orange"};
        assertFalse(EngineArray.process(customer, market));
    }
}