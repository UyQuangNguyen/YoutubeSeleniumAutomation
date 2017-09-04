package Global;
import Global.Helpers.TestListener;
import Website.WebsiteConstants;
import com.sun.jna.platform.FileUtils;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 *  This class is the superclass of all the tests. This ensures that all tests have the driver available,
 *  and that they can call the driver from wherever. It contains methods that will always run for initiating the driver
 *  and also contains teardown method and a method for taking screenshot when a test has finished and failed.
 */

@Listeners({ TestListener.class })
public class Core {
    protected static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    /**
     * The first method that runs regardless of test, and it's mandatory.
     * It sets up chromedriver, and makes it easy for us later when we want to call it throughout the tests.
     */

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
                }
                threadDriver.remove();
            }
        }
    }

    /**
     * Sets the driver together with the desired settings.
     */
    public static WebDriver setDriver() {
        WebDriver driver = null;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WebsiteConstants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(WebsiteConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        return driver;
    }

    /**
     * Returns the driver, can be called from basically all the tests that is set up (which is the main point of doing this)
     */

    public static WebDriver getDriver() {

        return threadDriver.get();
    }

    /**
     *
     * takeScreenShotOnFailure will take a picture of the current state of chrome if a test fails (debugging benefits)
     * The screenshot will be saved in the local folder, which in will be use for future allure reports.
     *
     */

    @Attachment(value = "Page screenshot" , type = "image/png")
    public static byte[] captureScreenshot(String screenshotName) {

        try {
            DateFormat df = new SimpleDateFormat("yyyy.MM.dd-HH.mm");
            String reportDate = df.format(Calendar.getInstance().getTime());

            new File("target/picture-for-allure/").mkdirs();
            byte[] screenShotInBytes = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            String screenShotFilePath = "target/picture-for-allure/" + reportDate +  "-" + screenshotName + ".png";
            File scrShotPng =  new File(screenShotFilePath);
            org.apache.commons.io.FileUtils.copyFile(scrFile, scrShotPng);

            return screenShotInBytes;

        } catch (Exception ex) {

        }

        System.out.println("Failed to take a sceenshot!");
        return null;
    }

    /**
     * Teardown will close the browser after each test has been done, so that the user is not left with a million browsers.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        getDriver().quit();
    }

    }



