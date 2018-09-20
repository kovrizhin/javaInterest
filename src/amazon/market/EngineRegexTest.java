package amazon.market;

import static org.junit.jupiter.api.Assertions.*;

class EngineRegexTest {
    @org.junit.jupiter.api.Test
    void process() {
        EngineRegex engineRegex = new EngineRegex();
        String[][] market = {{"apple", "orange", "anything"},{"orange", "apple"}};
        String[] customer = {"apple", "orange", "apple", "carrot","banana","orange", "apple"};
        assertTrue(engineRegex.process(customer, market));

        market = new String[][]{{"apple", "orange"}, {"orange", "apple"}};
        customer = new String[]{"apple", "orange", "apple", "carrot", "banana", "orange"};
        assertFalse(engineRegex.process(customer, market));

        market = new String[][]{{"apple", "orange"}, {"apple", "carrot"}, {"banana", "orange"}};
        customer = new String[]{"apple", "orange", "apple", "carrot", "banana", "orange"};
        assertTrue(engineRegex.process(customer, market));

        market = new String[][]{{"apple", "orange"}, {"aple", "carrot"}, {"banana", "orange"}};
        customer = new String[]{"apple", "orange", "apple", "carrot", "banana", "orange"};
        assertFalse(engineRegex.process(customer, market));
    }

}