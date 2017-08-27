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
           // GeneralMethods.waitForPresenceOfElement(cssSelector, 10); // GeneralMethods.waitElementToBeVisible(cssSelector, 10);
            WebElement elementToClick = Core.getDriver().findElement(By.cssSelector(cssSelector));
            try {
                //Attempts to click it
                elementToClick.click();
            } catch (Exception ex) {
                //We scroll to it incase the exception was that it was out of sight..
                ((JavascriptExecutor) Core.getDriver()).executeScript(
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
            // GeneralMethods.waitForPresenceOfElement(cssSelector, 10); // GeneralMethods.waitElementToBeVisible(cssSelector, 10);
            WebElement elementToClick = Core.getDriver().findElement(By.xpath(xpath));
            try {
                //Attempts to click it
                elementToClick.click();
            } catch (Exception ex) {
                //We scroll to it incase the exception was that it was out of sight..
                ((JavascriptExecutor) Core.getDriver()).executeScript(
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
        if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
            Actions action = new Actions(Core.getDriver());
            action.dragAndDrop(sourceElement, destinationElement).build().perform();
            GeneralMethods.sleep(3000); //to make the form to refresh after drag and drop
        } else {
            System.out.println("Element was not displayed to drag");
        }
    }

    public static void dragAndDropNoWait(WebElement sourceElement, WebElement destinationElement) {
        try {
            if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
                Actions action = new Actions(Core.getDriver());
                action.dragAndDrop(sourceElement, destinationElement).build().perform();
            } else {
                System.out.println("Element was not displayed to drag");
            }
        } catch (Exception e) {
        }
    }

    public static void enterTextWithCSS(String cssValue, String text) {
        try {
            WebElement textField = Core.getDriver().findElement(By.cssSelector(cssValue));
            textField.clear();
            textField.sendKeys(text);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Core.getDriver()).executeScript(
                "try{arguments[0].scrollIntoView(true);} catch(err){}", element);
    }


    public static void sleep(int waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (Exception ex) {
        }
    }

    public static WebElement waitElementToBeVisibleCSS(String elementCSS, int duration) {
        try {
            return new WebDriverWait(Core.getDriver(), duration).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementCSS)));
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static WebElement waitForPresenceOfElementCSS(String elementCSS, int duration) {
        return new WebDriverWait(Core.getDriver(), duration).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementCSS)));
    }

    public static WebElement waitForElementClickableCSS(String elementCSS, int duration) {
        return new WebDriverWait(Core.getDriver(), duration).until(ExpectedConditions.elementToBeClickable(By.cssSelector(elementCSS)));
    }
}
