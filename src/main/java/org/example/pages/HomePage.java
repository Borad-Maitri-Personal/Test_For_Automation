package org.example.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement cookies;

    @FindBy(xpath = "//a[@class='c5eb115ad c6fd11aca']")
    WebElement signUp;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@name='action']")
    WebElement registerButton;

    @FindBy(xpath = "//input[@placeholder='Telephone number (inc. country code)*']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@placeholder='First name*']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last name*']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='Company name*']")
    WebElement company;

    @FindBy(xpath = "//input[@id='country']")
    WebElement location;

    @FindBy(xpath = "//select[@name='role']")
    WebElement role;

    @FindBy(xpath = "//select[@name='seniority']")
    WebElement experience;

    @FindBy(xpath = "//span[@class='jsx-1211472146 checkmark']")
    WebElement termsAndCondition;

    @FindBy(xpath = "(//button[normalize-space()='Save'])[1]")
    WebElement saveButton;

    @FindBy(xpath = "//nav[@class='css-1badijy']//div[@class='css-68tk0t']")
    WebElement profile;

    @FindBy(xpath = "//span[normalize-space()='Sign out']")
    WebElement signOut;

    @FindBy(xpath = "//button[@class='c227b20f2 c8e6e34f8 c06daa549 c0fe4fa86 cf42875ec']")
    WebElement loginButton;

    @FindBy(xpath = "//span[@id='error-element-password']")
    WebElement errorMessage;

    public void acceptCookies(){
        clickOnElement(cookies);
        log.info("Accept cookies : " + cookies.toString());
    }

    public void clickOnSignUp(){
        clickOnElement(signUp);
        log.info("Click on sign up : " + signUp.toString());
    }

    public void enterCredentials(){
      String email = getRandomString(8) + "@gmail.com";
      String password = "Password@123";
      sendTextToElement(emailField,email);
      sendTextToElement(passwordField,password);
      log.info("Enter email : " + email + " and password : " + password + emailField.toString());
    }

    public void clickOnRegister(){
        clickOnElement(registerButton);
        log.info("Click on Register Button : " + registerButton.toString());
    }

    public void addAdditionalInfo() throws InterruptedException {
        sendTextToElement(phoneNumber,"07852321456");
        sendTextToElement(firstName,"bingo");
        sendTextToElement(lastName,"game");
        sendTextToElement(company,"Mmas");
        selectByValueFromDropDown(location,"United Kingdom");
        selectByValueFromDropDown(role,"Creative");
        selectByVisibleTextFromDropDown(experience,"Mid Level Manager");
        clickOnElement(termsAndCondition);
        Thread.sleep(2000);
        clickOnElement(saveButton);
    }

    public void compareSignOut() throws InterruptedException {
        clickOnElement(profile);
        Thread.sleep(500);
        String expected = getTextFromElement(signOut);
        Assert.assertEquals("Sign out",expected);
    }

    public void enterEmail(String email){
        sendTextToElement(emailField,email);
    }

    public void enterPassword(String password){
        sendTextToElement(passwordField,password);
    }

    public void clickOnLogin(){
        clickOnElement(loginButton);
    }

    public String getErrorMessage(){
        return getTextFromElement(errorMessage);
    }
}
