package codewar;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;




public class SumTest1 {

    Sum s = new Sum();

    @Test
    public void Test1()
    {
        assertEquals(-1, s.GetSum(0, -1));
        assertEquals(1, s.GetSum(0, 1));
    }

}