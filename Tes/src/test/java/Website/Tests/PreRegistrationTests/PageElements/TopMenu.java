package Website.Tests.PreRegistrationTests.PageElements;

import Global.Helpers.GeneralMethods;
import Website.WebsiteCore;
import com.sun.tools.javah.Gen;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.java2d.loops.FillRect;

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
            GeneralMethods.clickWithXpath(buttonCSS);
            return true;

        }
        catch (TimeoutException ex){
            return false;

        }
    }

}
