package test;

import org.testng.annotations.Test;
import screen.SwipeScreen;
import utils.BaseTest;
import utils.NavBar;

public class SwipeCardTest extends BaseTest {
    private NavBar navBarComponent;
    @Test
    public void swipeCardsTest(){
        navBarComponent = new NavBar(driver);
        navBarComponent.goSwipeScreen();
        SwipeScreen swipeScreen = new SwipeScreen(driver);
        swipeScreen.navToViewCard1();
        swipeScreen.navToViewCard2();
        swipeScreen.navToViewCard3();
        swipeScreen.navToViewCard4();
        swipeScreen.navToViewCard5();
        swipeScreen.navToViewCard6();

    }
}
