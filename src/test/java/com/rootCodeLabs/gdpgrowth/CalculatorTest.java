package com.rootCodeLabs.gdpgrowth;

import com.rootCodeLabs.gdpgrowth.utils.Calculator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTest {
    @Test
    public void GDPGrowth() {
        Calculator calculator = new Calculator();
        Assert.assertEquals((Double) 0.37398385817618257, calculator.GDPGrowth(546666677.8, 751111191.1) );
    }
}
