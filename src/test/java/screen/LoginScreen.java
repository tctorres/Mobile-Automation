package screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseScreen;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class LoginScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Sign up Form\")")
    WebElement loginSignUpTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Login-screen\")")
    WebElement loginScreen;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"button-login-container\")")
    WebElement loginContainerBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"input-email\")")
    WebElement emailLogin;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"input-password\")")
    WebElement passwordLogin;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"button-LOGIN\")")
    WebElement loginBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"You are logged in!\")")
    WebElement successfulLogin;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"OK\")")
    WebElement okLoginBtn;

    List<WebElement> loginElements = Arrays.asList(
            loginSignUpTitle,
            loginScreen,
            loginContainerBtn,
            emailLogin,
            passwordLogin,
            loginBtn,
            successfulLogin,
            okLoginBtn
    );

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }
    public void enterData(String email, String passwd){
        this.emailLogin.sendKeys(email);
        this.passwordLogin.sendKeys(passwd);
    }
    public void clickOnLogin(){
        loginBtn.click();
    }
    public void clickOnLoginContainer(){
        loginContainerBtn.click();
    }
    public void clickOnOkBtn(){
        okLoginBtn.click();
    }
    public String getSuccessLoginText(){
        return successfulLogin.getText();
    }
    @Override
    public Boolean isPageLoaded() {
        try{
            softAssert.assertTrue(areElementsVisible(loginElements));
            return true;
        } catch (AssertionError err){
            return false;
        }
    }


}
