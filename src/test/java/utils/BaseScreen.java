package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public abstract class BaseScreen {
    protected AndroidDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    protected Boolean areElementsVisible(List<WebElement> elements){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            for(WebElement element : elements) {
                if(!element.isDisplayed()) return false;
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Boolean isPageLoaded(){
        return false;
    };
}
