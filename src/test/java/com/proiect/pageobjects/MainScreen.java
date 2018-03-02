package com.proiect.pageobjects;

import com.proiect.steps.Hooks;
import com.proiect.util.ActionsHelper;
import com.proiect.util.ConfigHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.apache.velocity.util.StringUtils;


public class MainScreen {
    WebDriver driver = Hooks.driver;

    private static final org.slf4j.Logger LOG = (org.slf4j.Logger) LoggerFactory.getLogger(Hooks.class);

    public MainScreen(WebDriver driver) {

        PageFactory.initElements(this.driver, this);
    }

    static String URL = ConfigHelper.INSTANCE.getProperty("url");

    @FindBy(xpath = "//img[contains(@class,'logo')]")
    WebElement logoLocator;

    @FindBy(xpath = "//a[@class='login']")
    WebElement signInLocator;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailLocator;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordLocator;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement submitButtonLocator;

    private WebElement construcPage(String page) {
        String pageToDisplay = StringUtils.capitalizeFirstLetter(page.toLowerCase());
        return driver.findElement(By.xpath("//h1[@class='page-heading'][contains(text(),'" + pageToDisplay + "')]"));
    }


    public void navigation(WebDriver driver) {
        driver.get(URL);
    }


    public void iChooseToSignIn() {
        ActionsHelper.clickElement(driver, signInLocator);
    }

    public void pageDisplayed(String page) {
        WebElement pageDisplayed = construcPage(page);
        Assert.assertTrue(pageDisplayed.isDisplayed());
        LOG.info("Page {} is displayed.", construcPage(page).getText());
    }

    public void iEnterTheForLogIn(String text, String type) {
        WebElement finalType = null;
        switch (type) {
            case "email": {
                finalType = emailLocator;
                break;
            }
            case "password": {
                finalType = passwordLocator;
                break;
            }
        }
        ActionsHelper.fillText(driver, finalType, text);

    }

    public void clickSubmitButton() {
        ActionsHelper.clickElement(driver, submitButtonLocator);
        LOG.info("Submit button was pressed.");
    }

    public void applicationDisplayed() {
        ActionsHelper.verifyWebElementPresent(driver, logoLocator);
    }
}