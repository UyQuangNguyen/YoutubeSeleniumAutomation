package Website.Tests.PreRegistrationTests.PageElements;

import Global.Helpers.WebDriverNavigation;
import Website.WebsiteCore;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TopMenu extends WebsiteCore{
    // Unfortunately, by the way youtube is set up, we can only use xPath instead of css selectors for this menu
    public enum TopMenuButton {CONTEXTMENU, YOUTUBELOGO, TOPSEARCH, SEARCHBUTTON, UPLOADBUTTON, GRIDBUTTON, SETTINGS}



    public static String CONTEXTMENU = "button#guide-button";
    public static String YOUTUBELOGO = "yt-icon#logo-icon";
    public static String TOPSEARCH = "input#search]";
    public static String SEARCHBUTTON = "button[aria-label='Search']";
    public static String UPLOADBUTTON = "button[aria-label='Upload']";
    public static String GRIDBUTTON = "button[aria-label='YouTube apps']";
    public static String SETTINGS = "button[aria-label='Settings']";


    @Override
    public void basicWebclientSetup() {
    }

    public static boolean navigate (TopMenuButton leftMenuButton) {

        String buttonCSS = null;

        switch (leftMenuButton) {
            case CONTEXTMENU:
                buttonCSS = TopMenuCSS.CONTEXTMENU;
                break;
            case YOUTUBELOGO:
                buttonCSS = TopMenuCSS.YOUTUBELOGO;
                break;
            case TOPSEARCH:
                buttonCSS = TopMenuCSS.TOPSEARCH;
                break;
            case SEARCHBUTTON:
                buttonCSS = TopMenuCSS.SEARCHBUTTON;
                break;
            case UPLOADBUTTON:
                buttonCSS = TopMenuCSS.UPLOADBUTTON;
                break;
            case GRIDBUTTON:
                buttonCSS = TopMenuCSS.GRIDBUTTON;
                break;
            case SETTINGS:
                buttonCSS = TopMenuCSS.SETTINGS;
                break;
        }

        try {
            WebDriverNavigation.clickWithCSS(buttonCSS);
            return true;

        }
        catch (TimeoutException ex){
            return false;

        }
    }

    public static void search(String videoName) {
        WebDriver driver = getDriver();
        WebElement searchBar = driver.findElement(By.cssSelector(TopMenuCSS.TOPSEARCH));
        searchBar.sendKeys(videoName);
        searchBar.sendKeys(Keys.ENTER);

    }

    public static List<WebElement> returnSearchResults() {
        WebDriver driver = getDriver();
        List<WebElement> searchresults = new ArrayList<>();
        searchresults = driver.findElements(By.cssSelector("ytd-video-renderer.style-scope"));
        return searchresults;


    }

}
