package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import screen.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;


public class BaseTest {
    public AndroidDriver driver;
    private static final String PROPERTIES_FILE= "src/test/resources/config.properties";
    private static final Properties properties = new Properties();

    @BeforeTest
    public void mobileSetUp(){
        loadProperties();
        UiAutomator2Options capabilities = new UiAutomator2Options();
        setCapabilities(capabilities);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }
        catch(MalformedURLException exception){
            System.out.println(exception.getMessage());
        }
    }
    @DataProvider(name="dataForLogin")
    public Object [][] getDataForLogin(){
        return new Object[][]{
                {"joabln@hotmail.com","contraseña123"},
                {"marvin03@hotmail.com","contraseña321"},
                {"mypersonalemail@hotmail.com","12345678"},
                {"mysecondaryemail@hotmail.com","password123"}
        };
    }
    @DataProvider(name="dataForSignUp")
    public Object [][] getDataForSignUp(){
        return new Object[][]{
                {"joabln@hotmail.com","contraseña123","contraseña123"},
                {"marvin03@hotmail.com","contraseña321","contraseña321"},
                {"mypersonalemail@hotmail.com","12345678","12345678"},
                {"mysecondaryemail@hotmail.com","password123","password123"}
        };
    }

    @AfterTest
    public void tearDownModule(){
        if(driver != null) driver.quit();
    }

    public AndroidDriver getDriver() {
        return driver;
    }
    public DragScreen getDragScreen(){
        return new DragScreen(driver);
    }
    public FormsScreen getFormsScreen(){
        return new FormsScreen(driver);
    }
    public HomeScreen getHomeScreen(){
        return new HomeScreen(driver);
    }
    public LoginScreen getLoginScreen(){
        return new LoginScreen(driver);
    }
    public SignUpScreen getSignUpScreen(){
        return new SignUpScreen(driver);
    }
    public SwipeScreen getSwipeScreen(){
        return new SwipeScreen(driver);
    }
    public WebViewScreen getWebViewScreen(){
        return new WebViewScreen(driver);
    }

    public void loadProperties(){
        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
            properties.load(fileInputStream);
        }
        catch(IOException e) {
            throw new RuntimeException("Error loading the properties file" + PROPERTIES_FILE);
        }
    }
    public static void setCapabilities(UiAutomator2Options capabilities){
        capabilities.setDeviceName(getCapability("deviceName"));
        capabilities.setApp(Paths.get(getCapability("app")).toAbsolutePath().toString());
        capabilities.setPlatformName(getCapability("platformName"));
        capabilities.setAutomationName(getCapability("automationName"));
        capabilities.setAppActivity(getCapability("appActivity"));
        capabilities.setAppPackage(getCapability("appPackage"));
    }
    public static String getCapability(String capability){
        return properties.getProperty((capability));
    }
}

