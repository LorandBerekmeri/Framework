package com.proiect.util;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.ErrorHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;


public class ActionsHelper {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(ActionsHelper.class);

    public static void clearText(WebDriver driver, WebElement element) {
        if (VerifyHelper.verifyWebElementPresent(driver, element)) {
            element.clear();
        }
    }

    public static Boolean verifyWebElementPresent(WebDriver driver, WebElement element) {
        Integer EXPLICIT_WAIT = 60;
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | NoSuchFrameException | NoSuchWindowException | ErrorHandler.UnknownServerException | TimeoutException e) {
            return false;
        }
    }

    public static void fillText(WebDriver driver, WebElement element, String fieldValue) {
        if (VerifyHelper.verifyWebElementPresent(driver, element)) {
            element.sendKeys(fieldValue);
        }
    }

    public static void clickElement(WebDriver driver, WebElement element) {
        if (VerifyHelper.verifyWebElementPresent(driver, element)) {
            element.click();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(ActionsHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String getTextFromElement(WebDriver driver, WebElement element) {
        String returnText = "";
        if (VerifyHelper.verifyWebElementPresent(driver, element)) {
            returnText = element.getText();
        }
        return returnText;
    }

    public static void switchToFrameByElement(WebDriver driver, WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    public static void switchToDefaultFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

}