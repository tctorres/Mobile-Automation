package screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import utils.BaseScreen;
import utils.NavBar;

import java.util.Arrays;
import java.util.List;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\")")
    WebElement homeScreen;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Support\")")
    WebElement supportText;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Demo\")")
    WebElement descriptionText;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"WEBDRIVER\")")
    WebElement webDriverText;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().index(0)))")
    WebElement robotImage;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().index(2)))")
    WebElement webDriverImage;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().index(4)))")
    WebElement appleLogo;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().index(5)))")
    WebElement androidLogo;

    List<WebElement> homeElements = Arrays.asList(
            homeScreen,
            supportText,
            descriptionText,
            webDriverText,
            robotImage,
            webDriverImage,
            appleLogo,
            androidLogo
    );

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public Boolean isPageLoaded() {
        try{
            softAssert.assertTrue(areElementsVisible(homeElements));
            return true;
        } catch (AssertionError err){
            return false;
        }
    }
}
