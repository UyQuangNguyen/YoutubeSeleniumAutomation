package Global.Helpers;

import Global.Core;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GeneralMethods {
    public static void clickWithCSS(String cssSelector) {
        try {
            WebDriver driver = Core.getDriver();
            // GeneralMethods.waitForPresenceOfElement(cssSelector, 10); // GeneralMethods.waitElementToBeVisible(cssSelector, 10);
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
            Assert.fail("Can't click on the element! It may not be presented on the page! \n Control's CSS:" +
                    cssSelector);
        }
    }

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
            Assert.fail("Can't click on the element! It may not be presented on the page! \n Control's xpath:" +
                    xpath);
        }
    }

    public static void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
        WebDriver driver = Core.getDriver();
        if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
            Actions action = new Actions(driver);
            action.dragAndDrop(sourceElement, destinationElement).build().perform();
            GeneralMethods.sleep(3000); //to make the form to refresh after drag and drop
        } else {
            System.out.println("Element was not displayed to drag");
        }
    }

    public static void dragAndDropNoWait(WebElement sourceElement, WebElement destinationElement) {
        WebDriver driver = Core.getDriver();

        try {
            if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
                Actions action = new Actions(driver);
                action.dragAndDrop(sourceElement, destinationElement).build().perform();
            } else {
                System.out.println("Element was not displayed to drag");
            }
        } catch (Exception e) {
        }
    }

    public static void enterTextWithCSS(String cssValue, String text) {
        WebDriver driver = Core.getDriver();

        try {
            WebElement textField = driver.findElement(By.cssSelector(cssValue));
            textField.clear();
            textField.sendKeys(text);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static void scrollToElement(WebElement element) {
        WebDriver driver = Core.getDriver();

        ((JavascriptExecutor) driver).executeScript(
                "try{arguments[0].scrollIntoView(true);} catch(err){}", element);
    }


    public static void sleep(int waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (Exception ex) {
        }
    }

    public static WebElement waitElementToBeVisibleCSS(String elementCSS, int duration) {
        WebDriver driver = Core.getDriver();

        try {
            return new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementCSS)));
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static void waitUntilElementInvisible(String elementCSS, int duration) {
        new WebDriverWait(Core.getDriver(), duration).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(elementCSS)));
    }

    public static WebElement waitForPresenceOfElementCSS(String elementCSS, int duration) {
        WebDriver driver = Core.getDriver();

        return new WebDriverWait(driver, duration).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementCSS)));
    }

    public static WebElement waitForElementClickableCSS(String elementCSS, int duration) {
        WebDriver driver = Core.getDriver();
        return new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(By.cssSelector(elementCSS)));
    }
}
