package com.proiect.util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyHelper {

    public static Integer EXPLICIT_WAIT = 10;
    public static StringBuffer VERIFICATION_ERRORS = new StringBuffer();

    public static Boolean verifyWebElementPresent(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException e) {
            VERIFICATION_ERRORS.append("Element: " + element + " is not present on page \n -Caught exception: "
                    + e.getMessage() + "\n\n");
            return false;
        }
    }

}
