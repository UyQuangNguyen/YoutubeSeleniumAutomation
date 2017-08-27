package Website.Tests.PreRegistrationTests.PageElements.LeftMenu;

import Global.Helpers.GeneralMethods;
import org.openqa.selenium.TimeoutException;
import sun.java2d.loops.FillRect;

public class LeftMenu {
    // Unfortunately, by the way youtube is set up, we can only use xPath instead of css selectors for this menu
    public enum LeftMenuButton {HOME, TRENDING, HISTORY, MUSIC, SPORTS, GAMING, MOVIES, NEWS, LIVE, VIDEOS}

    public static void navigate(LeftMenuButton leftMenuButton) {

        String buttonCSS = null;

        switch (leftMenuButton) {
            case HOME:
                buttonCSS = LeftMenuCSS.HOME;
                break;
            case TRENDING:
                buttonCSS = LeftMenuCSS.TRENDING;
                break;
            case HISTORY:
                buttonCSS = LeftMenuCSS.HISTORY;
                break;
            case MUSIC:
                buttonCSS = LeftMenuCSS.MUSIC;
                break;
            case SPORTS:
                buttonCSS = LeftMenuCSS.SPORTS;
                break;
            case GAMING:
                buttonCSS = LeftMenuCSS.GAMING;
                break;
            case MOVIES:
                buttonCSS = LeftMenuCSS.MOVIES;
                break;
            case NEWS:
                buttonCSS = LeftMenuCSS.NEWS;
                break;
            case LIVE:
                buttonCSS = LeftMenuCSS.LIVE;
                break;
            case VIDEOS:
                buttonCSS = LeftMenuCSS.VIDEOS;
                break;
        }

        try {
            System.out.println("TRYING OUR BEST");
            GeneralMethods.clickWithXpath(buttonCSS);
        }
        catch (TimeoutException ex){

        }
    }

}
