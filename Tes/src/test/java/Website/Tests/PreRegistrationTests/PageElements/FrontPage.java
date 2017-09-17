package Website.Tests.PreRegistrationTests.PageElements;

import Website.WebsiteCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FrontPage extends WebsiteCore  {

    @Override
    public void basicWebclientSetup() {
    }

    public List<WebElement> getRandomCategoryRow() {
        WebDriver driver = getDriver();
        List<WebElement> categoryRows = driver.findElements(By.cssSelector(FrontPageCSS.CATEGORYROW));
        return categoryRows;

    }

    public List<WebElement> getRandomVideoRow() {
        WebDriver driver = getDriver();
        List<WebElement> videoRows  = driver.findElements(By.cssSelector(FrontPageCSS.VIDEOROWS));
        return videoRows;
    }
    
}
