package com.insta.qa.pageLayers;

import com.insta.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePage extends TestBase {

    public MessagePage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//span[contains(text(),'Messages')]")
    WebElement msg;

    @FindBy(xpath="//button[@class='_a9-- _ap36 _a9_1']")
    WebElement notNow;
    @FindBy(xpath = "//div[@class=\"x9f619 x1ja2u2z x78zum5 x2lah0s x1n2onr6 x1qughib x6s0dn4 xozqiw3 x1q0g3np\"]")
    WebElement firstMessage;


    @FindBy(xpath = "//div[text()='Send message']")
    WebElement sendMessage;


    @FindBy(xpath = "//input[@autocomplete='off']")
    WebElement searchPerson;


    @FindBy(xpath = "//div[contains(text(),'Chat')]")
    WebElement chat;
    @FindBy(xpath = "//input[@aria-label='Toggle selection'][@dir='ltr']")
    WebElement toggleSelection;


   public String getTitleMessage() throws InterruptedException {
       Thread.sleep(6000);
       msg.click();
       Thread.sleep(4000);
       notNow.click();
       Thread.sleep(2000);
       return driver.getTitle();
   }

   public void firstMessage() throws InterruptedException {
       Thread.sleep(3000);
       msg.click();
       Thread.sleep(4000);
       notNow.click();
       Thread.sleep(4000);
       firstMessage.click();

   }
   public void sendMessage() throws InterruptedException {
       Thread.sleep(3000);
       msg.click();
       Thread.sleep(4000);
       notNow.click();
       Thread.sleep(4000);
       sendMessage.click();

   }
   public void chat(String personID) throws InterruptedException {
       msg.click();
       Thread.sleep(4000);
       notNow.click();
       Thread.sleep(3000);
       sendMessage.click();
       Thread.sleep(2000);
       searchPerson.click();
       Thread.sleep(2000);
       searchPerson.sendKeys(personID);
       Thread.sleep(2000);
       toggleSelection.click();
       Thread.sleep(2000);
       chat.click();

   }



}
