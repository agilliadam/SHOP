package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    private Driver(){}

    public static synchronized WebDriver getDriver(){

        if(drivers.get() == null){

            String browserType = System.getProperty("browser");

            if(browserType == null){
                browserType = ConfigReader.getProperty("browser");
            }

            switch (browserType){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    drivers.set(new ChromeDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    drivers.set( new EdgeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    drivers.set(new SafariDriver());
                    break;
                case "chromeHeadless":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(true);
                    WebDriverManager.chromedriver().setup();
                    drivers.set(new ChromeDriver(chromeOptions));
                    break;
                case "firefoxHeadless":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setHeadless(true);
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver(firefoxOptions));
                    break;
                case "edgeHeadless":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("headless");
                    edgeOptions.addArguments("disable-gpu");
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver(edgeOptions));
                    break;
                default:
                    System.out.println("Invalid driver");
                    break;

            }


        }

        return drivers.get();


    }


    public static synchronized void quitDriver(){
        if(drivers.get() != null){
            drivers.get().quit();
            drivers.remove();

        }
    }



}
