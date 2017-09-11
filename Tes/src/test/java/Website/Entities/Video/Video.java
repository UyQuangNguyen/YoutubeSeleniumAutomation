package Website.Entities.Video;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import static Global.Core.getDriver;

public class Video {

    public String title;
    public String duration;
    public String url;
    public String uploader;
    public String amountOfViews;
    public String uploadDate;
    public String category;

    Video (String title, String duration, String url, String uploader,
           String amountOfViews, String uploadDate, String category) {
        this.title = title;
        this.duration = duration;
        this.url = url;
        this.uploader = uploader;
        this.amountOfViews = amountOfViews;
        this.uploadDate = uploadDate;
        this.category = category;
    }

    public String returnTitlefromPage () {
        WebDriver driver = getDriver();
        return driver.findElement(By.cssSelector(VideoCSS.TITLE)).getText();
    }

    public String returnDurationfromPage () {
        WebDriver driver = getDriver();
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.cssSelector("video.video-stream"))).perform();
        return driver.findElement(By.cssSelector(VideoCSS.DURATION)).getText();
    }


    public String returnUploaderfromPage () {
        WebDriver driver = getDriver();
        return driver.findElement(By.cssSelector(VideoCSS.UPLOADER)).getText();
    }

    public String returnAmountOfViewsfromPage () {
        WebDriver driver = getDriver();
        return driver.findElement(By.cssSelector(VideoCSS.VIEWS)).getText();
    }

    public String returnUploadDateFromPage () {
        WebDriver driver = getDriver();
        return driver.findElement(By.cssSelector(VideoCSS.UPLOADDATE)).getText();
    }

    public String returnCategoryFromPage () {
        WebDriver driver = getDriver();
        return driver.findElement(By.cssSelector(VideoCSS.CATEGORY)).getText();
    }



}
