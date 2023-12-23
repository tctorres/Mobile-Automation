package screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseScreen;

import java.util.Arrays;
import java.util.List;

public class SwipeScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe horizontal\")")
    WebElement swipeTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Swipe-screen\")")
    WebElement swipeScreenView;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(0)))")
    WebElement viewCard1;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))")
    WebElement viewCard2;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))")
    WebElement viewCard3;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))")
    WebElement viewCard4;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))")
    WebElement viewCard5;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))")
    WebElement viewCard6;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(0)))")
    WebElement dotItem1;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(1)))")
    WebElement dotItem2;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(2)))")
    WebElement dotItem3;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(3)))")
    WebElement dotItem4;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(4)))")
    WebElement dotItem5;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(5)))")
    WebElement dotItem6;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Swipe\")")
    WebElement btnSwipe;

    List<WebElement> swipeElements = Arrays.asList(
            swipeTitle,
            swipeScreenView,
            viewCard1,
            viewCard2,
            viewCard3,
            viewCard4,
            viewCard5,
            viewCard6,
            dotItem1,
            dotItem2,
            dotItem3,
            dotItem4,
            dotItem5,
            dotItem6,
            btnSwipe
    );

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }
    public void scrollToRight(WebElement element){
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, -800, 0).perform();
    }
    public void scrollToLeft(WebElement element){
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, 800, 0).perform();
    }
    public void navToViewCard1(){
        dotItem1.click();
    }
    public void getViewCard1(){
        viewCard1.isDisplayed();
    }
    public void navToViewCard2(){
        dotItem2.click();
    }
    public void navToViewCard3(){
        dotItem3.click();
    }
    public void navToViewCard4(){
        dotItem4.click();
    }
    public void navToViewCard5(){
        dotItem5.click();
    }
    public void navToViewCard6(){
        dotItem6.click();
    }

    @Override
    public Boolean isPageLoaded() {
        try{
            softAssert.assertTrue(areElementsVisible(swipeElements));
            return true;
        } catch (AssertionError err){
            return false;
        }
    }

}
