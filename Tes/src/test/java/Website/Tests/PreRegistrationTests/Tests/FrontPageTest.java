package Website.Tests.PreRegistrationTests.Tests;

import Global.Helpers.WebDriverNavigation;
import Website.Entities.Video.Video;
import Website.Entities.Video.VideoJSONFactory;
import Website.Tests.PreRegistrationTests.PageElements.LeftMenu;
import Website.Tests.PreRegistrationTests.PageElements.LeftMenuCSS;
import Website.Tests.PreRegistrationTests.PageElements.TopMenu;
import Website.WebsiteCore;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrontPageTest extends WebsiteCore {

    @Override
    @BeforeMethod(alwaysRun = true)
    public void basicWebclientSetup() {
        WebDriver driver =  getDriver();
        driver.get("https://www.youtube.com");
        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);
    }

    /**
     * leftMenuCheck checks all of the leftmenu of mainpage in www.youtube.com.
     * It checks the functionality and that the elements are visible on the page.
     * The resizing of the window is done to make sure that the context menu is available from start.
     */
    @Test(groups = "smokeBeforeReg")
    public void leftMenuCheck() { // Check if LeftMenu elements are visible and clickable.
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
     * This method is one of the biggest tests due to all the double-checking of correct video searched for.
     * It will basically go to the main page, pick one of the trending videos visible on the screen, send the URL to YoutubeVideoMaker,
     * create a video object based on the URL through the Youtube API. The test will then search exactly for the name of the
     * video, check if one of the results matches the video object, and enter the matching one. The video object will
     * then be used to cross reference everything on the screen to make sure the title, description, view count etc, matches.
     * if it does, it shows that the search was successful.
     */

    @Test(groups= "smokeBeforeReg")
    public void searchForTrendingVideo() {
        WebDriver driver =  getDriver();
        WebElement videoRow = driver.findElement(By.cssSelector("div#contents div#contents div#items"));
        WebElement videoFromRow = videoRow.findElement(By.cssSelector("ytd-grid-video-renderer.style-scope:nth-child(3) a#thumbnail"));
        String idOfvideo = videoFromRow.getAttribute("href");

        VideoJSONFactory YoutubeVideoMaker = new VideoJSONFactory(idOfvideo);
        Video video;


        try { // We create the video object and uses information from YouTubes API.
            video = YoutubeVideoMaker.convertYoutubeObjectToVideo();

        } catch (Exception IOException) {

        }







}}
