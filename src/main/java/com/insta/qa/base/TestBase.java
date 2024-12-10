package com.insta.qa.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.insta.qa.util.TestUtil.IMPLICIT_WAIT;
import static com.insta.qa.util.TestUtil.PAGE_LOAD_TIMEOUT;


public class TestBase {

   public static WebDriver driver;
    public  static Properties prop;
    public static Logger log = Logger.getLogger(TestBase.class);


    public TestBase() {
        try {

            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\DELL\\IdeaProjects\\POM_Automation\\src\\main\\java\\com\\insta\\qa\\config\\Config.Properties");
            prop.load(ip);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialization()  {
        driver = new ChromeDriver();
        try{
            Thread.sleep(3000);

        }catch (InterruptedException e){}
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        log.info("Brower Name : "+prop.getProperty("Browser"));
    }


}
