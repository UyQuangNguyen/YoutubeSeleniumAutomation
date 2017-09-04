package Website;

import Global.Core;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class WebsiteCore extends Core {


    @BeforeMethod(alwaysRun = true)
    public void basicWebclientSetup() {
        //Set environment blabla, to be featured later
        setupLogin("uytestautomation@gmail.com","testautomation");
    }

    // Will go to youtube.com, click log in manually, and proceed to log in.
    public void setupLogin(String name, String pass) {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        WebDriver driver =  getDriver();
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

        if(driver.findElements(By.cssSelector("div.vdE7Oc") ).size() != 0) { // If we have to do some nasty security check
            driver.findElement(By.id("knowledgeLoginLocationInput")).sendKeys("Oslo");
            driver.findElement(By.id("knowledgeLoginLocationInput")).sendKeys(Keys.RETURN);
            driver.findElement(By.cssSelector("div.vdE7Oc")).click();

        }

        // Attempts to find upload button, which is what should be on the screen when logged in.
        // Might sometimes fail due to youtube changing to the new design..
        driver.findElement(By.cssSelector("yt-icon.style-scope"));

    }



}
