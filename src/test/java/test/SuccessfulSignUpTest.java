package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import screen.LoginScreen;
import screen.SignUpScreen;
import utils.BaseTest;
import utils.NavBar;

public class SuccessfulSignUpTest extends BaseTest {
    private NavBar navBarComponent;
    @Test(dataProvider = "dataForSignUp")
    public void successSignUpTest(String email, String psswd, String psswd2){
        navBarComponent = new NavBar(driver);
        SignUpScreen signUp = new SignUpScreen(driver);
        LoginScreen login = new LoginScreen(driver);
        navBarComponent.goLoginScreen();
        navBarComponent.goSignUpScreen();
        signUp.enterData(email, psswd, psswd2);
        signUp.clickOnSignUp();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("You successfully signed up!", signUp.getSuccessSignUpText());
        signUp.clickOkBtn();

    }
}
