package com.insta.qa.TestPages;

import com.insta.listners.InstaListners;
import com.insta.qa.ExtentReporter.ExtentReporterNG;
import com.insta.qa.base.TestBase;
import com.insta.qa.pageLayers.HomePage;
import com.insta.qa.pageLayers.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.insta.qa.base.TestBase.*;

//@Listeners(ExtentReporterNG.class)
public class TestSignUp extends TestBase {
    SignUpPage signUpPage;
    HomePage homePage;

    public TestSignUp(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        signUpPage = new SignUpPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = signUpPage.validateSignUpPageTitle();
        Assert.assertEquals(title, "Instagram");
        log.info(" testsendMessage Test Method Running .......");

    }

    @Test(priority = 2)
    public void instaLogoImageTest(){
        boolean flag = signUpPage.validateCRMImage();
        Assert.assertTrue(flag);
        log.info(" instaLogoImageTest Test Method Running .......");

    }


    @Test(priority = 3)
    public void loginTest() throws InterruptedException {
        log.info(" loginTest Test Method Running .......");

        homePage= signUpPage.signUp(prop.getProperty("email"),prop.getProperty("passWord"), prop.getProperty("FullName"),prop.getProperty("userName"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
}

}
