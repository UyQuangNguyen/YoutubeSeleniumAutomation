package Global;
import Website.WebsiteConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class Core {
    // Will always run first for tests that requires user to be signed in.
    // Future goal is also to make driver global, so that we can grab it from anywhere ;)

    protected static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();


    @BeforeMethod(alwaysRun = true)
    public void globalSetup() {
        for (int driverSetAttempts = 0; driverSetAttempts < 5; driverSetAttempts++) {
            try {
                threadDriver.set(setDriver());
                break;
            } catch (Exception ex) {
                try {
                    getDriver().quit();
                } catch (NullPointerException nullPtrEx)
                {
                    //If it wasn't properly started, it can't be quitted
                }
                threadDriver.remove();
            }
        }
    }

    public static WebDriver setDriver() {
        WebDriver driver = null;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WebsiteConstants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(WebsiteConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        return driver;
    }

    public static WebDriver getDriver() {

        return threadDriver.get();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() // Close browser after tests are done so I'm not left with 40000 browsers.
    {
        getDriver().quit();
    }

    }



