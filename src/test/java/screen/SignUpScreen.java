package screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.BaseScreen;

import java.util.Arrays;
import java.util.List;

public class SignUpScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Sign up Form\")")
    WebElement loginSignUpTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Login-screen\")")
    WebElement signUpScreen;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"button-sign-up-container\")")
    WebElement signUpContainerBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"You successfully signed up!\")")
    WebElement popUpSignedUp;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"OK\")")
    WebElement okSignUpBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"input-email\")")
    WebElement emailSignUp;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"input-password\")")
    WebElement passwordSignUp;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"input-repeat-password\")")
    WebElement confirmPasswordSignUp;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"button-SIGN UP\")")
    WebElement signUpBtn;

    List<WebElement> signupElements = Arrays.asList(
            loginSignUpTitle,
            signUpScreen,
            signUpBtn,
            signUpContainerBtn,
            popUpSignedUp,
            okSignUpBtn,
            emailSignUp,
            passwordSignUp,
            confirmPasswordSignUp
    );

    public SignUpScreen(AndroidDriver driver) {
        super(driver);
    }
    public void enterData(String email, String passwd, String passwd2){
        this.emailSignUp.sendKeys(email);
        this.passwordSignUp.sendKeys(passwd);
        this.confirmPasswordSignUp.sendKeys(passwd2);
    }
    public void clickOnSignUp(){
        signUpBtn.click();
    }
    public void clickOkBtn(){
        okSignUpBtn.click();
    }
    public String getSuccessSignUpText(){
        return popUpSignedUp.getText();
    }
    @Override
    public Boolean isPageLoaded() {
        try{
            softAssert.assertTrue(areElementsVisible(signupElements));
            return true;
        } catch (AssertionError err){
            return false;
        }
    }
}

