package Global;
import Website.WebsiteConstants;
import com.sun.jna.platform.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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

    /**
     *
     * @param testResult The testresults
     * takeScreenShotOnFailure will take a picture of the current state of chrome if a test fails (debugging benefits)
     * The screenshot will be saved in the local folder.
     */
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
            org.apache.commons.io.FileUtils.copyFile(scrFile, new File("Error during run with test \\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() // Close browser after tests are done so I'm not left with 40000 browsers.
    {
        getDriver().quit();
    }

    }



