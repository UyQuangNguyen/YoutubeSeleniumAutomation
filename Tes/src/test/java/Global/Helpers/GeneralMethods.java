package Global.Helpers;

import Global.Core;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/** This class consists exclusively of static methods that provides basic navigation for webdriver.
 *  The methods are for example click by using css selector, or xpath, and we also have wait methods such as
 *  waiting for an element to be visible or invisible.
 */
public class GeneralMethods {

    /**
     * Attempts to find an element through csselector.
     * If the element is found, it'll be hovered over and clicked.
     * If not clickable, we will scroll down to see if we can find it.
     * If not clickable after scrolling, it may not be presented on the page.
     * @param cssSelector the string that will be used in findElement by csselector.
     */

    public static void clickWithCSS(String cssSelector) {
        try {
            WebDriver driver = Core.getDriver();
            WebElement elementToClick = driver.findElement(By.cssSelector(cssSelector));
            try {
                //Attempts to click it
                Actions action = new Actions(driver);
                action.moveToElement(elementToClick).click().build().perform();
            } catch (Exception ex) {
                //We scroll to it incase the exception was that it was out of siaht..
                ((JavascriptExecutor) driver).executeScript(
                        "try{arguments[0].scrollIntoView(true);} catch(err){}", elementToClick);
                elementToClick.click();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail("The element is not clickable! This may be because it has not loaded yet, or is not present on the page.\n Control's CSS:" +
                    cssSelector);
        }
    }

    /**
     * Attempts to find an element through xpath.
     * If the element is found, it'll be hovered over and clicked.
     * If not clickable, we will scroll down to see if we can find it.
     * If not clickable after scrolling, it may not be presented on the page.
     * @param xpath the string that will be used in findElement by xPath.
     */

    public static void clickWithXpath(String xpath) {
        try {
            WebDriver driver = Core.getDriver();
            // GeneralMethods.waitForPresenceOfElement(cssSelector, 10); // GeneralMethods.waitElementToBeVisible(cssSelector, 10);
            WebElement elementToClick = driver.findElement(By.xpath(xpath));
            try {
                //Attempts to click it
                Actions action = new Actions(driver);
                action.moveToElement(elementToClick).click().build().perform();
            } catch (Exception ex) {
                //We scroll to it incase the exception was that it was out of sight..
                ((JavascriptExecutor) driver).executeScript(
                        "try{arguments[0].scrollIntoView(true);} catch(err){}", elementToClick);
                elementToClick.click();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail("The element is not clickable! This may be because it has not loaded yet, or is not present on the page. \n Control's xpath:" +
                    xpath);
        }
    }

    /**
     * Checks if sourcelement and destination element is displayed, and if so
     * drags sourcelement to destination element.
     * @param sourceElement the webelement that will be dragged
     * @param destinationElement the sourceElement will be dragged to this element
     */

    public static void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
        WebDriver driver = Core.getDriver();
        if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
            Actions action = new Actions(driver);
            action.dragAndDrop(sourceElement, destinationElement).build().perform();
        } else {
            System.out.println("One of the two elements are not visible on the page");
        }
    }


    /**
     * This method adds text into a WebElement that is capable of receiving text.
     * @param cssSelector the css value of the textfield to be used
     * @param text the text that will be sent into the textfield
     */
    public static void enterTextWithCSS(String cssSelector, String text) {
        WebDriver driver = Core.getDriver();
        try {
            WebElement textField = driver.findElement(By.cssSelector(cssSelector));
            textField.clear();
            textField.sendKeys(text);
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Scroll to element on the page.
     * @param element to be scrolled to
     */
    public static void scrollToElement(WebElement element) {
        WebDriver driver = Core.getDriver();

        ((JavascriptExecutor) driver).executeScript(
                "try{arguments[0].scrollIntoView(true);} catch(err){}", element);
    }

    /**
     * This method "pauses" the driver for a given time.
     * @param waitTime the waiting time desired in milliseconds.
     */
    public static void sleep(int waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (Exception ex) {
        }
    }

    /**
     * This method waits for an element to be visible on the page.
     * @param cssSelector the CSS value of the WebElement.
     * @param duration is the desired waiting duration.
     * @return returns if visible.
     */
    public static WebElement waitElementToBeVisibleCSS(String cssSelector, int duration) {
        WebDriver driver = Core.getDriver();

        try {
            return new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * This method waits for an element to be invisible on the page.
     * @param cssSelector the CSS value of the WebElement..
     * @param duration is the desired waiting duration.
     * @return if invisible.
     */
    public static void waitUntilElementInvisible(String cssSelector, int duration) {
        new WebDriverWait(Core.getDriver(), duration).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    /**
     * Wait for the presence of an element on the page.
     * @param elementCSS the CSS value of the WebElement.
     * @param duration is the desired waiting duration.
     * @return if presence is on page.
     */
    public static WebElement waitForPresenceOfElementCSS(String elementCSS, int duration) {
        WebDriver driver = Core.getDriver();

        return new WebDriverWait(driver, duration).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementCSS)));
    }

    /**
     * Wait for an element to be clickable. of an element on the page.
     * @param elementCSS the CSS value of the WebElement.
     * @param duration is the desired waiting duration.
     * @return if clickable
     */
    public static WebElement waitForElementClickableCSS(String elementCSS, int duration) {
        WebDriver driver = Core.getDriver();
        return new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(By.cssSelector(elementCSS)));
    }
}
