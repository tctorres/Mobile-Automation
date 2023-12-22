package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


public class BaseTest {
    public AndroidDriver driver;
    private static final String PROPERTIES_FILE= "src/test/resources/config.properties";
    private static final Properties properties = new Properties();

    @BeforeMethod
    public void mobileSetUp(){
        loadProperties();
        UiAutomator2Options capabilities = new UiAutomator2Options();
        setCapabilities(capabilities);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        }
        catch(MalformedURLException exception){
            System.out.println(exception.getMessage());
        }
    }

    @AfterMethod
    public void tearDownModule(){
        if(driver != null) driver.quit();
    }

    public AndroidDriver getDriver() {
        return driver;
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
        capabilities.setApp(getCapability("app"));
        capabilities.setPlatformName(getCapability("platformName"));
        capabilities.setAutomationName(getCapability("automationName"));

    }
    public static String getCapability(String capability){
        return properties.getProperty((capability));
    }
}

