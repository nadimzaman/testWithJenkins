package com.bb.framework.pages;
import com.bb.framework.util.SeleniumUtils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
public class LoginPage extends SeleniumUtils {


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    // page Factory/ Object repository
    @FindBy(xpath = ".//*[@id='root']//div[@class = 'button button_login']")
    private WebElement clickLoginLinkInHomePage;
    @FindBy(xpath = ".//*[@id='react-tabs-1']//input[@type= 'email']")
    private WebElement userName;
    @FindBy(xpath = ".//*[@id='react-tabs-1']//input[@type ='password' ]")
    private WebElement password;
    @FindBy(xpath = ".//*[@id='react-tabs-1']//input[@class='login__submit']")
    private WebElement LoginButton;
    @FindBy(xpath = ".//*[@id='root']//div[@class = 'cross-page-message__error']")
    private WebElement errorMessagefromInvalidLoginOrPassword;


    @FindBy(xpath = ".//*[@id='react-tabs-2']")
    private WebElement newAccountLink;
    @FindBy(xpath = ".//*[@id='react-tabs-3']//input[@type = 'text']")
    private WebElement emailForNewAccount;
    @FindBy(xpath = ".//*[@id='react-tabs-3']//input[@placeholder='Password']")
    private WebElement passwordForNewAccount;
    @FindBy(xpath = ".//*[@id='react-tabs-3']//input[@placeholder='Confirm password']")
    private WebElement confirmpasswordForNewAccount;
    @FindBy(xpath = ".//*[@id='react-tabs-3']//input[@value='Register']")
    private WebElement registerButton;
    @FindBy(xpath = ".//*[@id='root']//div[@class ='cross-page-message__error']")
    private WebElement errorMessagefromInvalidInputNewAccountFrom;


    public void clickLoginLinkInHomePage() {
        highlight(clickLoginLinkInHomePage);
        clickLoginLinkInHomePage.click();
    }

    public void veryFyLogInPageTitle(String title) {
        veryFyPageTitle(title);
    }


    public void loginWithIdAndPassword(String email, String passwordInput) {
        highlight(userName);
        userName.sendKeys(email);
        highlight(password);
        password.sendKeys(passwordInput);
        highlight(LoginButton);
        LoginButton.click();


    }


    public void loginWithIdAndPassword_errorMessage(String email, String passwordInput, String ErrorMessage) {
        highlight(userName);
        userName.sendKeys(email);
        highlight(password);
        password.sendKeys(passwordInput);
        highlight(LoginButton);
        LoginButton.click();

        waitForVisibilityOfElement(errorMessagefromInvalidLoginOrPassword);
        highlight(errorMessagefromInvalidLoginOrPassword);
        String text = errorMessagefromInvalidLoginOrPassword.getText();


        if (errorMessagefromInvalidLoginOrPassword.isDisplayed()) {
            if (text.equals("User none found or password is incorrect")) {
                System.out.println(" Error message: " + text);

                Assert.assertEquals(ErrorMessage, text);
            } else if (text.equals("Password is incorrect")) {
                System.out.println(" Error message: " + text);

                Assert.assertEquals(ErrorMessage, text);
            }

        } else
            System.out.println("  no text");

    }


    public void errorMessage_forInvalidInputs_inLOGIN(String ErrorMessage) {

        waitForVisibilityOfElement(errorMessagefromInvalidLoginOrPassword);
        highlight(errorMessagefromInvalidLoginOrPassword);
        String text = errorMessagefromInvalidLoginOrPassword.getText();


        System.out.println(" Error message: " + text);

        Assert.assertEquals(ErrorMessage, text);
    }

    public void newAccountRegistrationLink() {

        newAccountLink.click();
    }

    public void RegistrationForNewAccount(String email, String password, String confirmPassword) {
        highlight(emailForNewAccount);
        emailForNewAccount.sendKeys(email);

        highlight(passwordForNewAccount);
        passwordForNewAccount.sendKeys(password);

        highlight(confirmpasswordForNewAccount);
        confirmpasswordForNewAccount.sendKeys(confirmPassword);

        highlight(registerButton);
        registerButton.click();
    }

    public void errorMessage_forInvalidInputs_inNEWACCOUNT(String ErrorMessage) {
        waitForVisibilityOfElement(errorMessagefromInvalidInputNewAccountFrom);
        highlight(errorMessagefromInvalidInputNewAccountFrom);
        String text = errorMessagefromInvalidInputNewAccountFrom.getText();

        System.out.println(" Error message: " + text);

        Assert.assertEquals(ErrorMessage, text);
    }
}