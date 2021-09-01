package scenarios;

import data.DataProviderForMobile;
import data.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.nativeapp.NativeBudgetActivityPageObject;
import pageObjects.nativeapp.NativeLoginPageObject;
import pageObjects.nativeapp.NativeRegistrationPageObject;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    //    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    //    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
    //        getPo().getWelement("signInBtn").click();
    //        System.out.println("Simplest Android native test done");
    //    }

    @Test(groups = {"native"},
          description = "This test register new account and then sign in",
          dataProvider = "registerAndSignInProvider",
          dataProviderClass = DataProviderForMobile.class)
    public void registerNewAccountAndSignIn(User user){

        //click register new account button
        NativeLoginPageObject loginPage = new NativeLoginPageObject(getDriver());
        loginPage.clickRegisterNewAccountButton();

        //register new account
        NativeRegistrationPageObject registrationPage = new NativeRegistrationPageObject(getDriver());
        registrationPage.registerNewAccount(user);

        //sign in as user
        loginPage.login(user);

        //check that BudgetActivity page is opened
        NativeBudgetActivityPageObject budgetActivityPage = new NativeBudgetActivityPageObject(getDriver());
        Assert.assertTrue(budgetActivityPage.getBudgetActivityText().isDisplayed() & budgetActivityPage.getBudgetActivityText().getText().equals("BudgetActivity"));
    }
}
