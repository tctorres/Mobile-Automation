package test;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.NavBar;

public class NavMenuBarTest extends BaseTest {
    private NavBar navBarComponent;
    @Test
    public void verifyNavMenuBarSectionsTest(){
        navBarComponent = new NavBar(driver);
        navBarComponent.goHomeScreen();
        navBarComponent.goWebViewScreen();
        navBarComponent.goLoginScreen();
        navBarComponent.goSignUpScreen();
        navBarComponent.goFormsScreen();
        navBarComponent.goSwipeScreen();
        navBarComponent.goDragScreen();
    }
}
