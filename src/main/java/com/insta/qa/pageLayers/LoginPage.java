package com.insta.qa.pageLayers;

import com.insta.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory or object repository
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//button[@class=' _acan _acap _acas _aj1- _ap30']")
    WebElement loginButton;

    @FindBy(xpath = "//span[text()='Sign up']")
    WebElement signUpButton;

    @FindBy(xpath = "//div[text()='Not now']")
    WebElement notNow;

    @FindBy(xpath = "//span[@style='----base-line-clamp-line-height: 18px; --lineHeight: 18px;']")
    WebElement forgotPassword;

    public LoginPage() {
        PageFactory.initElements(driver,this);

    }
    public String validateLoginPageTittle(){

        return driver.getTitle();
    }

    public void forgotPassword()  throws InterruptedException {
        Thread.sleep(3000);
        forgotPassword.click();
    }

    public void login(String un, String pw) throws InterruptedException {
        Thread.sleep(5000);

        this.username.sendKeys(un);
      this.password.sendKeys(pw);
        this.loginButton.click();
        Thread.sleep(5000);

    notNow.click();
    Thread.sleep(5000);



    }

    public void multipleUserLogin(String emailId, String password) throws InterruptedException {
        Thread.sleep(5000);
        this.username.sendKeys(emailId);
        this.password.sendKeys(password);
        this.loginButton.click();

    }
}
