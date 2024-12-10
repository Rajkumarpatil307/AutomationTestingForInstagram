package com.insta.qa.pageLayers;

import com.insta.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignUpPage extends TestBase {
    @FindBy(name="emailOrPhone")
    WebElement emailOrPhone;

    @FindBy(name="password")
    WebElement password;

    @FindBy(name="fullName")
    WebElement fullName;

    @FindBy(name="username")
    WebElement username;

    @FindBy(xpath = "//span[text()='Sign up']")
    WebElement clickForSignUp;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signUpBtn;

    @FindBy(xpath = "//i[@role='img']")
    WebElement instraLogoSignUp;

    public SignUpPage(){

        PageFactory.initElements(driver, this);
    }

    public String validateSignUpPageTitle(){

        return driver.getTitle();
    }

    public boolean validateCRMImage(){

        return instraLogoSignUp.isDisplayed();
    }

    public HomePage signUp(String email, String pwd, String name, String un) throws InterruptedException {

        clickForSignUp.click();
        Thread.sleep(3000);
        emailOrPhone.sendKeys(email);
        password.sendKeys(pwd);
        fullName.sendKeys(name);
        username.sendKeys(un);
        signUpBtn.click();
        return new HomePage();


}

    public void multiPerson(String email, String pwd, String name, String un) throws InterruptedException {
        clickForSignUp.click();
        Thread.sleep(3000);
        emailOrPhone.sendKeys(email);
        password.sendKeys(pwd);
        fullName.sendKeys(name);
        username.sendKeys(un);
        signUpBtn.click();
        Thread.sleep(3000);
    }



}
