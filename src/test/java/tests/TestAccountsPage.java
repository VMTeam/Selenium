package tests;

import methods.AccountsPageSteps;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAccountsPage extends BaseClass {
    private static AccountsPageSteps AccountsPageSteps = new AccountsPageSteps();

    @BeforeClass
    public static void Before() {
        AccountsPageSteps.openLoginPage();
        AccountsPageSteps.loginSystem("oleg.kutc@gmail.com", "Pass#12345");
        AccountsPageSteps.switchToAccountsPage();
    }

    @Test
    public void test_01_Check_Number_Of_Users_In_Table() {
        AccountsPageSteps.assertNumberOfUsersInTable(8);
    }

    @Test
    public void test_02_Search_User_By_Name() {
        AccountsPageSteps.searchUser("Richmond");
        AccountsPageSteps.assertFirstUserNameInTable("Richmond Talent");
        AccountsPageSteps.assertNumberOfUsersInTable(1);
        AccountsPageSteps.assertInfoAboutUsersInTable("Records 1 to 1 of 1 (filtered from 8 total records)");
        AccountsPageSteps.resetSearchField();
        AccountsPageSteps.assertNumberOfUsersInTable(8);
    }

    @Test
    public void test_03_Search_User_By_Three_Symbols() {
        AccountsPageSteps.searchUser("Sab");
        AccountsPageSteps.assertFirstUserNameInTable("Sabbatical Holidays");
        AccountsPageSteps.assertNumberOfUsersInTable(1);
        AccountsPageSteps.assertInfoAboutUsersInTable("Records 1 to 1 of 1 (filtered from 8 total records)");
        AccountsPageSteps.resetSearchField();
        AccountsPageSteps.assertNumberOfUsersInTable(8);
    }

    @Test
    public void test_04_Search_Nonexistent_User() {
        AccountsPageSteps.searchUser("Ololosha");
        AccountsPageSteps.assertEmptyUsersTable("No matching records found");
        AccountsPageSteps.resetSearchField();
        AccountsPageSteps.assertNumberOfUsersInTable(8);
    }
}
