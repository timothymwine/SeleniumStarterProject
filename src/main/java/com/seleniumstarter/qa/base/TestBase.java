package com.seleniumstarter.qa.base;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.seleniumstarter.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Timothy Mwine
 * @date   12th August 2022
 */
public class TestBase {

    public static Properties prop;
    public static WebDriver driver;

    static {
        try {
            prop = new Properties();
            InputStream inputStream = TestBase.class.getResourceAsStream( "config.properties" );
            prop.load( inputStream );
        }
        catch ( IOException e ) {

            throw new RuntimeException( "Error Reading properties", e );
        }
    }

    public TestBase() {

    }


    // method to initialize the browser
    public static void initialization() {

        String browserName = prop.getProperty( "browser" );

        switch ( browserName ) {

            case "chrome":

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "safari":

                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;

            case "edge":

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException( "Invalid browser name" );
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds( TestUtil.PAGE_LOAD_TIMEOUT ) );

        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( TestUtil.IMPLICIT_WAIT ) );
        driver.get( prop.getProperty( "url" ) );
    }
}
