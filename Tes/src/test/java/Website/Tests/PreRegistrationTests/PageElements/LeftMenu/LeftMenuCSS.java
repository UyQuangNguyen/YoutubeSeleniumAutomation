package Website.Tests.PreRegistrationTests.PageElements.LeftMenu;

import org.openqa.selenium.TimeoutException;

public class LeftMenuCSS {
    // Unfortunately, by the way youtube is set up, we can only use xPath instead of css selectors for this menu
    public static String HOME = "//text()='Home')]";
    public static String TRENDING = "./text()='hello'";
    public static String HISTORY = "//*[contains(text(), 'History')]";
    public static String MUSIC = "//*[contains(text(), 'Music')]";
    public static String SPORTS = "//*[contains(text(), 'Sports')]";
    public static String GAMING = "//*[contains(text(), 'Gaming')]";
    public static String MOVIES = "//*[contains(text(), 'Movies')]";
    public static String NEWS = "//*[contains(text(), 'News')]";
    public static String LIVE = "//*[contains(text(), 'Live')]";
    public static String VIDEOS = "//*[contains(text(), '360° Video')]";


}
