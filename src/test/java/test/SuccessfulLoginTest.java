package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import screen.LoginScreen;
import screen.SignUpScreen;
import utils.BaseTest;
import utils.NavBar;

public class SuccessfulLoginTest extends BaseTest {
    private NavBar navBarComponent;
    private LoginScreen loginScreen;
    private SignUpScreen signUpScreen;
    @BeforeMethod
    public void signUpTest(){
        navBarComponent = new NavBar(driver);
        loginScreen = new LoginScreen(driver);
        signUpScreen = new SignUpScreen(driver);
        this.signUpScreen = getSignUpScreen();

    }

    @Test(dataProvider="dataForLogin")
    public void successLoginTest(String email, String psswd){
        navBarComponent.goSignUpScreen();
        signUpScreen.enterData(email, psswd, psswd);
        signUpScreen.clickOnSignUp();
        signUpScreen.clickOkBtn();
        loginScreen.clickOnLoginContainer();
        loginScreen.enterData(email, psswd);
        loginScreen.clickOnLogin();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("You are logged in!", loginScreen.getSuccessLoginText());
        loginScreen.clickOnOkBtn();



    }
}
