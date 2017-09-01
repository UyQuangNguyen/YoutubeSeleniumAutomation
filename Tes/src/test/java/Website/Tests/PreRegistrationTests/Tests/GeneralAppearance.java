package Website.Tests.PreRegistrationTests.Tests;

import Website.Tests.PreRegistrationTests.PageElements.LeftMenu;
import Website.WebsiteCore;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GeneralAppearance extends WebsiteCore {

    @Override
    @BeforeMethod(alwaysRun = true)
    public void basicWebclientSetup() {
        WebDriver driver =  getDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get("https://www.youtube.com");
    }

    @Test(groups = "smokeBeforeReg")
    public void CheckIfLeftMenuClickable() {
        Assert.assertTrue(LeftMenu.navigate(LeftMenu.LeftMenuButton.HOME),"Couldn't press the Home button");
        Assert.assertTrue(LeftMenu.navigate(LeftMenu.LeftMenuButton.TRENDING),"Couldn't press the Trending button");
        Assert.assertTrue(LeftMenu.navigate(LeftMenu.LeftMenuButton.HISTORY),"Couldn't press the History button");
        Assert.assertTrue(LeftMenu.navigate(LeftMenu.LeftMenuButton.MUSIC),"Couldn't press the Music button");
        Assert.assertTrue(LeftMenu.navigate(LeftMenu.LeftMenuButton.SPORTS),"Couldn't press the Sports button");
        Assert.assertTrue(LeftMenu.navigate(LeftMenu.LeftMenuButton.GAMING),"Couldn't press the Gaming button");
        Assert.assertTrue(LeftMenu.navigate(LeftMenu.LeftMenuButton.FILMS),"Couldn't press the films or movies button");
        Assert.assertTrue(LeftMenu.navigate(LeftMenu.LeftMenuButton.NEWS),"Couldn't press the News button");
        Assert.assertTrue(LeftMenu.navigate(LeftMenu.LeftMenuButton.LIVE),"Couldn't press the Live button");
        Assert.assertTrue(LeftMenu.navigate(LeftMenu.LeftMenuButton.VIDEOS),"Couldn't press the Videos button");

    }



}
