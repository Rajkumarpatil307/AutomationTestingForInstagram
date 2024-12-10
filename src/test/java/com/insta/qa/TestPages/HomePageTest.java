package com.insta.qa.TestPages;

import com.insta.listners.InstaListners;
import com.insta.qa.ExtentReporter.ExtentReporterNG;
import com.insta.qa.base.TestBase;
import com.insta.qa.pageLayers.HomePage;
import com.insta.qa.pageLayers.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ExtentReporterNG.class)
public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setup() throws InterruptedException {

        initialization();
        loginPage = new LoginPage();
          homePage = new HomePage();
        loginPage.login(prop.getProperty("userName"), prop.getProperty("passWord"));
        Thread.sleep(9000);


    }


    @Test
    public void homePageTitleTest() throws InterruptedException {
        Thread.sleep(5000);
        log.info(" homePageTitleTest Test Method Running .......");

        String title=homePage.getHomePageTitle();
        Assert.assertEquals(title,"Instagram");

    }
    @Test
    public void reelsTitleTest() throws InterruptedException {
        Thread.sleep(5000);
        String title=homePage.getReelsTittle();
        log.info(" reelsTitleTest Test Method Running .......");

        Assert.assertEquals(title,"Instagram");
    }
    @Test
    public void profileTitleTest() throws InterruptedException {
        Thread.sleep(5000);

        String title=homePage.getProfileTitle();
        Assert.assertEquals(title,"Instagram");
        log.info(" profileTitleTest Test Method Running .......");

    }
    @Test
    public void searchTitleTest() throws InterruptedException {
        Thread.sleep(5000);
        log.info(" searchTitleTest Test Method Running .......");

        String title=homePage.getSearchTitle();
        Assert.assertEquals(title,"Instagram");
    }

    @Test
    public void msgTitleTest() throws InterruptedException {
        Thread.sleep(5000);
        log.info(" msgTitleTest Test Method Running .......");

        String title=homePage.getMsgTitle();
        Assert.assertEquals(title,"Inbox • Chats");
    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }

}
