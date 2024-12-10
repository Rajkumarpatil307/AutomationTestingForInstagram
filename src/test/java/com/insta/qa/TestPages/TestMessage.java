package com.insta.qa.TestPages;

import com.insta.listners.InstaListners;
import com.insta.qa.ExtentReporter.ExtentReporterNG;
import com.insta.qa.base.TestBase;
import com.insta.qa.pageLayers.HomePage;
import com.insta.qa.pageLayers.LoginPage;
import com.insta.qa.pageLayers.MessagePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ExtentReporterNG.class)
public class TestMessage extends TestBase {

    LoginPage loginPage;
    MessagePage messPage;
    public TestMessage(){
        super();
    }
    @BeforeMethod
    public void setup() throws InterruptedException {

        initialization();
        loginPage = new LoginPage();
        messPage = new MessagePage();
        loginPage.login(prop.getProperty("userName"), prop.getProperty("passWord"));
        Thread.sleep(9000);

    }

    @Test
    public void testGetTitle() throws InterruptedException {
       String title= messPage.getTitleMessage();
        Thread.sleep(5000);

        Assert.assertTrue(title.contains("Insta"));


    }

    @Test
    public void testFirstMessage() throws InterruptedException {
        log.info(" testFirstMessage Test Method Running .......");

        messPage.firstMessage();
        Thread.sleep(5000);

    }
    @Test
    public  void testsendMessage() throws InterruptedException {
         messPage.sendMessage();
         Thread.sleep(5000);
        log.info(" testsendMessage Test Method Running .......");

    }

    @Test
    public void testChat() throws InterruptedException {

        messPage.chat("sudhir_pawar7");
        Thread.sleep(5000);
        log.info(" testChat Test Method Running .......");

    }
    @AfterMethod
    public void afterMethod( ) throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }






}
