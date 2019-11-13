package tests;

import methods.AccountsPageSteps;
import methods.BaseMethods;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAccountsPage extends BaseClass {
    private static AccountsPageSteps AccountsPageSteps = new AccountsPageSteps();
    private static BaseMethods BaseMethods = new BaseMethods();

    @BeforeClass
    public static void before() {
        AccountsPageSteps.openLoginPage();
        AccountsPageSteps.loginSystem("oleg.kutc@gmail.com", "Pass#12345");
        AccountsPageSteps.switchToAccountsPage();
    }

    @Test
    public void test_01_Check_Number_Of_Users_In_Table() {
        AccountsPageSteps.assertNumberOfUsersInTable(8);
    }
}
