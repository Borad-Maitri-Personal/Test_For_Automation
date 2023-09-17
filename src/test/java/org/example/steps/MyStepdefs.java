package org.example.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pages.HomePage;
import org.testng.Assert;

public class MyStepdefs {
    @Given("^I am on home page an accept all cookies$")
    public void iAmOnHomePageAnAcceptAllCookies() {
        new HomePage().acceptCookies();
    }

    @When("^I click on sign up$")
    public void iClickOnSignUp() {
        new HomePage().clickOnSignUp();
    }

    @And("^I enter email and password$")
    public void iEnterEmailAndPassword() {
        new HomePage().enterCredentials();
    }

    @And("^I click on register button$")
    public void iClickOnRegisterButton() {
        new HomePage().clickOnRegister();
    }

    @And("^I add additional information$")
    public void iAddAdditionalInformation() throws InterruptedException {
        Thread.sleep(2000);
        new HomePage().addAdditionalInfo();
    }

    @Then("^I can see sign out option$")
    public void iCanSeeSignOutOption() throws InterruptedException {
        Thread.sleep(2000);
        new HomePage().compareSignOut();
    }

    @And("^I click on login button$")
    public void iClickOnLoginButton() {
        new HomePage().clickOnLogin();
    }

    @Then("^I verify \"([^\"]*)\"$")
    public void iVerify(String email){
       new HomePage().enterEmail(email);
    }

    @When("^I enter \"([^\"]*)\" in email field$")
    public void iEnterInEmailField(String password){
       new HomePage().enterPassword(password);
    }

    @And("^I enter \"([^\"]*)\" in password field$")
    public void iEnterInPasswordField(String message){
        Assert.assertEquals(new HomePage().getErrorMessage(),message);
    }
}
