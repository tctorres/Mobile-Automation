package screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.BaseScreen;

import java.util.Arrays;
import java.util.List;

public class DragScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Drag-drop-screen\")")
        WebElement dragScreen;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Drag and Drop\")")
    WebElement dragAndDropTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Drag-drop-screen\").childSelector(new UiSelector().className(\"android.widget.ImageView\"))")
    WebElement puzzleContainer;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"renew\")")
    WebElement renewBtn;

    List<WebElement> dragElements = Arrays.asList(
            dragScreen,
            dragAndDropTitle,
            puzzleContainer,
            renewBtn
    );

    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public Boolean isPageLoaded() {
        try{
            softAssert.assertTrue(areElementsVisible(dragElements));
            return true;
        } catch (AssertionError err){
            return false;
        }
    }

}
