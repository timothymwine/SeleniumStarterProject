package com.seleniumstarter.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.seleniumstarter.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    public static Properties prop;
    public static WebDriver driver;
    
    // This is a constructor to input properties from the config file
    public TestBase() {
        
        prop = new Properties();
        FileInputStream ip;
        
        try {
            
            ip = new FileInputStream( System.getProperty("user.dir")
                    +"/src/main/resources/com/seleniumstarter/qa/config/config.properties");
            
            prop.load(ip);
            
        }
        catch ( IOException e ) {
            
            throw new RuntimeException( "Error Reading properties", e );
        }
    }


    // method to initialize the browser
    public static void initialization() {

        String browserName = prop.getProperty( "browser" );
       
        if ( browserName.equalsIgnoreCase( "chrome" ) ) {
           
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if ( browserName.equalsIgnoreCase( "firefox" ) ) {
           
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if ( browserName.equalsIgnoreCase( "safari" ) ) {
           
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        else if ( browserName.equalsIgnoreCase( "edge" ) ) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else {
            throw new RuntimeException( "Invalid browser name" );
        }
       
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(
                TestUtil.PAGE_LOAD_TIMEOUT ) );

        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( TestUtil.IMPLICIT_WAIT ) );
        driver.get( prop.getProperty( "url" ) );
    }
}
