package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import screen.*;

public class NavBar extends BaseScreen{
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home\")")
    WebElement navHomeScreenBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Webview\")")
    WebElement navWebViewScreenBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Login\")")
    WebElement navLoginScreenBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
    WebElement navSignUpScreenBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Forms\")")
    WebElement navFormsScreenBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Swipe\")")
    WebElement navSwipeScreenBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Drag\")")
    WebElement navDragScreenBtn;
    HomeScreen homeScreen = new HomeScreen(driver);
    WebViewScreen webviewScreen = new WebViewScreen(driver);
    LoginScreen loginScreen = new LoginScreen(driver);
    SignUpScreen signUpScreen = new SignUpScreen(driver);
    FormsScreen formsScreen = new FormsScreen(driver);
    SwipeScreen swipeScreen = new SwipeScreen(driver);
    DragScreen dragScreen = new DragScreen(driver);
    public void goHomeScreen(){
        navHomeScreenBtn.click();
        softAssert.assertTrue(homeScreen.isPageLoaded());
    }
    public void goWebViewScreen(){
        navWebViewScreenBtn.click();
        softAssert.assertTrue(webviewScreen.isPageLoaded());
    }
    public void goLoginScreen(){
        navLoginScreenBtn.click();
        softAssert.assertTrue(loginScreen.isPageLoaded());
    }
    public void goSignUpScreen(){
        navLoginScreenBtn.click();
        navSignUpScreenBtn.click();
        softAssert.assertTrue(signUpScreen.isPageLoaded());
    }
    public void goFormsScreen(){
        navFormsScreenBtn.click();
        softAssert.assertTrue(formsScreen.isPageLoaded());
    }
    public void goSwipeScreen(){
        navSwipeScreenBtn.click();
        softAssert.assertTrue(swipeScreen.isPageLoaded());
    }
    public void goDragScreen(){
        navDragScreenBtn.click();
        softAssert.assertTrue(dragScreen.isPageLoaded());
    }

    public NavBar(AndroidDriver driver) {
        super(driver);
    }
}
