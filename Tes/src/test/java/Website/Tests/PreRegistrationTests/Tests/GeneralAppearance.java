package Website.Tests.PreRegistrationTests.Tests;

import Global.Helpers.GeneralMethods;
import Website.Tests.PreRegistrationTests.PageElements.LeftMenu.LeftMenu;
import Website.Tests.PreRegistrationTests.PageElements.LeftMenu.LeftMenuCSS;
import Website.WebsiteCore;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Website.Tests.PreRegistrationTests.PageElements.LeftMenu.LeftMenu.LeftMenuButton.HOME;

public class GeneralAppearance extends WebsiteCore {

    @Override
    @BeforeMethod
    public void basicWebclientSetup() {
        WebDriver driver =  getDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get("https://www.youtube.com");
    }

    @Test
    public void CheckIfLeftMenuClickable() {
        GeneralMethods.sleep(3000);
        LeftMenu.navigate(LeftMenu.LeftMenuButton.TRENDING);
    }



}
