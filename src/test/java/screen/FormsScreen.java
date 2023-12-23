package screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.BaseScreen;

import java.util.Arrays;
import java.util.List;

public class FormsScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Form components\")")
    WebElement formsTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Forms-screen\")")
    WebElement formsScreen;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"text-input\")")
    WebElement inputField;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"input-text-result\")")
    WebElement typedText;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"switch\")")
    WebElement switchBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"switch-text\")")
    WebElement switchText;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Dropdown\")")
    WebElement dropdown;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"button-Active\")")
    WebElement activeBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"button-Inactive\")")
    WebElement inactiveBtn;
    @AndroidFindBy(className = "android.widget.LinearLayout")
    WebElement itemPopUp;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Appium is awesome\")")
    WebElement item2;

    List<WebElement> formsElements = Arrays.asList(
            formsTitle,
            formsScreen,
            inputField,
            typedText,
            switchBtn,
            switchText,
            dropdown,
            activeBtn,
            inactiveBtn,
            itemPopUp,
            item2
    );

    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public Boolean isPageLoaded() {
        try{
            softAssert.assertTrue(areElementsVisible(formsElements));
            return true;
        } catch (AssertionError err){
            return false;
        }
    }

}
