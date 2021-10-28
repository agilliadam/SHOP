package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

public abstract class TestBase {


    protected WebDriver driver;


    protected static ExtentReports report;
    protected static ExtentSparkReporter htmlReporter;
    protected static ExtentTest logger;



    @BeforeSuite
    public void setupSuite(){
        report = new ExtentReports();

        String path =  System.getProperty("user.dir") + "/test-output/extentReports/index.html";
        htmlReporter = new ExtentSparkReporter(path);
        report.attachReporter(htmlReporter);


    }

    @BeforeMethod

    public void setup(Method method){

        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        logger = report.createTest(method.getName());
    }


    @AfterMethod
    public void teardown(ITestResult testResult){


        if(testResult.getStatus() == ITestResult.SUCCESS){
            logger.pass("Test passed: " + testResult.getName());
        }else if(testResult.getStatus() == ITestResult.SKIP){
            logger.skip("Test skipped: " + testResult.getName());
        }else if(testResult.getStatus() == ITestResult.FAILURE){
            logger.fail("Test Failed: "  + testResult.getName());
            logger.fail(testResult.getThrowable());
            logger.addScreenCaptureFromPath(SeleniumUtils.getScreenshot("failed"));
        }


        Driver.quitDriver();


    }


    @AfterSuite
    public void tearDown(){
          report.flush();
    }

}
