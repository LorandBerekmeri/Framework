package com.proiect.steps;

import com.proiect.pageobjects.MainScreen;
import com.proiect.util.ActionsHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Steps {

    private WebDriver driver = Hooks.driver;
    private MainScreen mainScreen = new MainScreen(driver);

    @Given("^I navigate on the page$")
    public void navigation() throws Throwable {
        mainScreen.navigation(driver);
    }

    @When("^I choose to sign in$")
    public void iChooseToSignIn() throws Throwable {
        mainScreen.iChooseToSignIn();
    }

    @Then("^the \"([^\"]*)\" page is displayed$")
    public void thePageIsDisplayed(String page) throws Throwable {
        mainScreen.pageDisplayed(page);
    }

    @When("^I enter the \"([^\"]*)\" \"([^\"]*)\" for Log in$")
    public void iEnterTheForLogIn(String text, String type) throws Throwable {
        mainScreen.iEnterTheForLogIn(text, type.toLowerCase());
    }

    @When("^I click on the Submit button to Log in$")
    public void iClickOnTheSubmitButtonToLogIn() throws Throwable {
        mainScreen.clickSubmitButton();
    }

    @Then("^Application is displayed$")
    public void applicationIsDisplayed() throws Throwable {
        mainScreen.applicationDisplayed();
    }
}
