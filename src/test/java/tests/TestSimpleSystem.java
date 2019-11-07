package tests;

import methods.BaseMethods;
import methods.SimpleSystemsMethods;
import org.junit.*;
import org.junit.runners.MethodSorters;
import pageObjects.SimpleSystemsPageObjects.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSimpleSystem extends BaseMethods {
    private static methods.SimpleSystemsMethods SimpleSystemsMethods = new SimpleSystemsMethods();
    private static methods.BaseMethods baseMethods = new BaseMethods();
    private static String EMAIL = "oleg.kutc@gmail.com";
    private static String PASSWORD = "Pass#12345";

    @BeforeClass
    public static void setUp() {
        baseMethods.upChrome77();
    }

    @Before
    public void before() {
        baseMethods.openPage("https://qasca-554.reallysimplesystems.com/login");
        SimpleSystemsMethods.LoginSystem(EMAIL, PASSWORD);
        SimpleSystemsMethods.SwitchToAccountsPage();
    }

    @AfterClass
    public static void afterClass() {
        baseMethods.webDriverDown();
    }

    @Test
    public void test_01_Check_Element_On_Page() {
        elementShouldHaveText(Accounts.USER_NAME_TITLE, "OLEG KUTC");
        elementShouldHaveText(Accounts.COMPANY_NAME_TITLE, "QASCA");
        listShouldHaveSize(Accounts.TABLE_USERS_LIST, 8);
    }
}
