package com.insta.listners;

import com.insta.qa.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class InstaListners extends TestBase implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: "+result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Success: "+result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failure: Screen Shot has been taken");
        TakesScreenshot ts=(TakesScreenshot)driver;
        File sfile=ts.getScreenshotAs(OutputType.FILE);

        File dfile=new File("C:\\Users\\DELL\\OneDrive\\Desktop\\ILisnersScreenShots\\"+ result.getMethod().getMethodName() + ".png");
        try {
            FileHandler.copy(sfile, dfile);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

System.out.println("Test Skipped: "+result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Started at Class Level: "+context.getCurrentXmlTest().getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Finished at Class Level: "+context.getCurrentXmlTest().getName());
    }



}
