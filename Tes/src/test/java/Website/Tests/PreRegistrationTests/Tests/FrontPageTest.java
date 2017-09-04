package Website.Tests.PreRegistrationTests.Tests;

import Global.Helpers.WebDriverNavigation;
import Website.Tests.PreRegistrationTests.PageElements.LeftMenu;
import Website.Tests.PreRegistrationTests.PageElements.LeftMenuCSS;
import Website.Tests.PreRegistrationTests.PageElements.TopMenu;
import Website.WebsiteCore;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrontPageTest extends WebsiteCore {

    @Override
    @BeforeMethod(alwaysRun = true)
    public void basicWebclientSetup() {
        WebDriver driver =  getDriver();
        driver.get("https://www.youtube.com");
    }

    /**
     * leftMenuCheck checks all of the leftmenu of mainpage in www.youtube.com.
     * It checks the functionality and that the elements are visible on the page.
     * The resizing of the window is done to make sure that the context menu is available from start.
     */
    @Test(groups = "smokeBeforeReg")
    public void leftMenuCheck() { // Check if LeftMenu elements are visible and clickable.
        WebDriver driver = getDriver();
        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);
        WebDriverNavigation.waitElementToBeVisibleCSS(LeftMenuCSS.CONTEXTMENU,10);
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


    /**
     * topMenuCheck checks all of the topmenu of mainpage in www.youtube.com.
     * It checks the functionality and that the elements are visible on the page.
     */
    @Test(groups = "smokeBeforeReg")
    public void topMenuCheck() { // Check if LeftMenu elements are visible and usable
        WebDriver driver = getDriver();
        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);
        WebDriverNavigation.waitElementToBeVisibleCSS(LeftMenuCSS.CONTEXTMENU,10); // Checks if contextmenu is there
        Assert.assertTrue(TopMenu.navigate(TopMenu.TopMenuButton.CONTEXTMENU),"Couldn't press the Contextmenu button");
        WebDriverNavigation.sleep(1000);
        // Pressing the context menu makes it dissapear, so we have to check for that if the click did happen.
        WebDriverNavigation.waitUntilElementInvisible(LeftMenuCSS.CONTEXTMENU,10); // Checks if contextmenu is gone
        WebDriverNavigation.sleep(1000);
        Assert.assertTrue(TopMenu.navigate(TopMenu.TopMenuButton.CONTEXTMENU),"Couldn't press the Contextmenu button");
        WebDriverNavigation.sleep(1000);
        WebDriverNavigation.waitElementToBeVisibleCSS(LeftMenuCSS.CONTEXTMENU,10); // Checks if contextmenu is back
        Assert.assertTrue(TopMenu.navigate(TopMenu.TopMenuButton.YOUTUBELOGO),"Couldn't press the Youtube logo");
        Assert.assertTrue(TopMenu.navigate(TopMenu.TopMenuButton.TOPSEARCH),"Couldn't press the Topsearch bar");
        Assert.assertTrue(TopMenu.navigate(TopMenu.TopMenuButton.SEARCHBUTTON),"Couldn't press the Search button");
        Assert.assertTrue(TopMenu.navigate(TopMenu.TopMenuButton.UPLOADBUTTON),"Couldn't press the Upload button");
        Assert.assertTrue(TopMenu.navigate(TopMenu.TopMenuButton.GRIDBUTTON),"Couldn't press the Grid button");
        Assert.assertTrue(TopMenu.navigate(TopMenu.TopMenuButton.SETTINGS),"Couldn't press the Settings button");
    }

    /**
     * This method will search for a random videos with a certain string, and check that the
     * titles correspond to the search query.
     * The random video will be fetched from a list of pre-generated videos or from the front page of YouTube.
     * 
     */

    @Test(groups= "smokeBeforeReg")
    public void searchForRandomVideo() {
       

    }





}
