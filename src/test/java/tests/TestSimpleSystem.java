package tests;

import methods.BaseMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSimpleSystem {
    private static BaseMethods baseMethods = new BaseMethods();

    @Before
    public void before() {
        baseMethods.upChrome77();
    }

    @After
    public void after () {
        baseMethods.webDriverDown();
    }
}
