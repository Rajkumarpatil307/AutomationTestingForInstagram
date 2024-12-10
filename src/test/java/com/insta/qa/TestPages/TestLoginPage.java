package com.insta.qa.TestPages;

import com.insta.listners.InstaListners;
import com.insta.qa.ExtentReporter.ExtentReporterNG;
import com.insta.qa.base.TestBase;
import com.insta.qa.pageLayers.LoginPage;
import com.insta.qa.pageLayers.SignUpPage;
import com.insta.qa.util.TestUtil;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


//@Listeners(ExtentReporterNG.class)
public class TestLoginPage extends TestBase {
    String SheetName="Sheet2";
    LoginPage loginPage;
    SignUpPage signUp;

public TestLoginPage() {
    super();
}
    @BeforeMethod
    public void setup() {
          initialization();
         loginPage = new LoginPage();
         signUp = new SignUpPage();

    }
    @Test
    @Severity(SeverityLevel.MINOR)
    @Description(" Login Page validate")
    @Feature("Login Page : 1")
    @Story("Login Page")
    public void testLogin() throws InterruptedException {
    log.info(" UserLogin Test Method Running .......");
        loginPage.login(prop.getProperty("userName"), prop.getProperty("passWord"));

    }
   @Test
   @Severity(SeverityLevel.MINOR)
   @Description(" Login Page Title validate")
   @Feature("Login Page : 2")
   @Story("Login Page Title")
   public void testGetPageTitle() {
        String tittle=loginPage.validateLoginPageTittle();
        Assert.assertEquals(tittle, "Instagram");
       log.info(" UserLogin Test Method Running .......");

   }
  @Test
  @Severity(SeverityLevel.MINOR)
  @Description(" Forgot Page validate")
  @Feature("Forgot  Page : 3")
  @Story("Forgot  Page")
  public void TestForgotPassword() throws InterruptedException {
    loginPage.forgotPassword();
      log.info(" TestForgotPassword Test Method Running .......");


  }
    @DataProvider
    public Object[][] getLoginTestData(){
        Object data[][] = TestUtil.getTestData(SheetName);
        return data;
    }
    @Test(dataProvider = "getLoginTestData",priority =4 )
    @Severity(SeverityLevel.MINOR)
    @Description("Multiple user Login Page validate")
    @Feature(" Multiple Login Page : 5")
    @Story("Login Page")
    public void multipleUserLoginTest(String emailId,String password) throws InterruptedException {
    log.info(" multipleUserLogin Test Method Running .......");
        loginPage.multipleUserLogin(emailId, password);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test(dataProvider = "getLoginTestData",priority =4 )
    @Severity(SeverityLevel.MINOR)
    @Description(" SignUp Page validate")
    @Feature("SignUp Page : 1")
    @Story("SignUp Page")
    public void multipleUserSignUPTest(String emailId,String password,String fullName,String userName) throws InterruptedException {
        log.info(" getLoginTestData Test Method Running .......");

        signUp.multiPerson(emailId,password,fullName,userName);
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }
}
