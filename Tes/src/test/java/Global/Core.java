package Global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Core {
    // Will always run first for tests that requires user to be signed in.
    @BeforeMethod(alwaysRun = true)
    public void basicWebclientSetup() {
        //Set environment blabla, to be featured later
        setupLogin();
    }

    public void setupLogin() {
        System.setProperty("webdriver.chrome.driver", "/Users/tidal");
            // Optional, if not specified, WebDriver will search your path for chromedriver.
         WebDriver driver = new ChromeDriver();
            driver.get("http://www.google.com/xhtml");
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("ChromeDriver");
            searchBox.submit();
            driver.quit();
        }

    }

