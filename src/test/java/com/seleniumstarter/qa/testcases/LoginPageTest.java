package com.seleniumstarter.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumstarter.qa.base.TestBase;
import com.seleniumstarter.qa.pages.DashBoardPage;
import com.seleniumstarter.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;

    public LoginPageTest() {

        super();
    }


    @BeforeMethod
    public void setUp() {

        initialization();
        loginPage = new LoginPage();
    }


    @Test( priority = 1 )
    public void validatePageTitleTest() {

        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals( title, "OrangeHRM" );
    }


    @Test( priority = 2 )
    public void orangeLogoTest() {

        boolean orangelogo = loginPage.validateOrangeLogo();
        Assert.assertTrue( orangelogo );
    }


    @Test( priority = 3 )
    public void loginTest() {

        String username = prop.getProperty( "username" );
        String password = prop.getProperty( "password" );
        dashBoardPage = loginPage.login( username, password );
    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
