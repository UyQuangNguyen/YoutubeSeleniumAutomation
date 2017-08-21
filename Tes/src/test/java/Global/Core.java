package Global;

import Website.WebsiteConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class Core {
    // Will always run first for tests that requires user to be signed in.
    // Future goal is also to make driver global, so that we can grab it from anywhere ;)
    @BeforeMethod(alwaysRun = true)
    public void basicWebclientSetup() {
        //Set environment blabla, to be featured later
        setupLogin("uytestautomation@gmail.com","testautomation");
    }

    // Will go to youtube.com, click log in manually, and proceed to log in.
    public void setupLogin(String name, String pass) {
            // Optional, if not specified, WebDriver will search your path for chromedriver.
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(WebsiteConstants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
            driver.get("https://www.youtube.com");

            // Currently using xPath because youtube has no consistent jss css that we can use for cssSelector.
            WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(), 'Sign in')]"));
            elementToClick.click();

            // Input the email
            WebElement inputFormEmail = driver.findElement(By.cssSelector("input[type='email']"));
            inputFormEmail.sendKeys(name);
            inputFormEmail.sendKeys(Keys.RETURN);

            // Input the password, will implement webdriverwait in the future.

        try {
            sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("gon wait");
        }
            WebElement inputFormPassword = driver.findElement(By.cssSelector("input[type='password']"));
            inputFormPassword.sendKeys(pass);
            inputFormPassword.sendKeys(Keys.RETURN);


    }

    }

