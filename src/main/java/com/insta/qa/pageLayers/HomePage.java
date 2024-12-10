package com.insta.qa.pageLayers;

import com.insta.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[contains(text(),'Home')]")
    WebElement home;


    @FindBy(xpath="//span[contains(text(),'Reels')]")
    WebElement reels;
    @FindBy(xpath="//span[contains(text(),'Messages')]")
    WebElement msg;

    @FindBy(xpath="(//img[@alt=\"rajkumar_patil30's profile picture\"])[2]")
    WebElement   profile;

    @FindBy(xpath ="(//span[@class='x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft'])[12]")
    WebElement search;


    public String getHomePageTitle() throws InterruptedException {
        home.click();
        Thread.sleep(4000);
        return  driver.getTitle();
    }

    public String getReelsTittle() throws InterruptedException {
        reels.click();
        Thread.sleep(4000);
        return driver.getTitle();

    }
    public String getMsgTitle() throws InterruptedException {
        msg.click();
        Thread.sleep(4000);
        return driver.getTitle();

    }

    public String getProfileTitle() throws InterruptedException {
        profile.click();
        Thread.sleep(4000);
        return driver.getTitle();
    }
    public String getSearchTitle() throws InterruptedException {
        search.click();
        Thread.sleep(4000);
        return driver.getTitle();
    }


}
