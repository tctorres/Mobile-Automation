package screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.BaseScreen;

import java.util.Arrays;
import java.util.List;

public class WebViewScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Toggle navigation bar\")")
    WebElement menuBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Search\")")
    WebElement searchBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Welcome! How can I help?\")")
    WebElement textFloatingBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"__docusaurus_skipToContent_fallback\").childSelector(new UiSelector().className(\"android.view.View\"))")
    WebElement mainText;

    List<WebElement> webViewElements = Arrays.asList(
            menuBtn,
            searchBtn,
            textFloatingBtn,
            mainText
    );

    public WebViewScreen(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public Boolean isPageLoaded() {
        try{
            softAssert.assertTrue(areElementsVisible(webViewElements));
            return true;
        } catch (AssertionError err){
            return false;
        }
    }

}
