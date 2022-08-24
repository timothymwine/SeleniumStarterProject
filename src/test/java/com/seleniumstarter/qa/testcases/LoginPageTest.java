package com.seleniumstarter.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumstarter.qa.base.TestBase;
import com.seleniumstarter.qa.pages.LoginPage;
import com.seleniumstarter.qa.pages.ViewEmployeeListPage;

/**
 * @author Timothy Mwine
 * @date   12th August 2022
 */
public class LoginPageTest extends TestBase {

    private LoginPage loginPage;
    private ViewEmployeeListPage viewEmployeeListPage;

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
        Assert.assertTrue( orangelogo,
                "Logo test failed because logo is not displayed in the test" );
    }


    @Test( priority = 3 )
    public void loginTest() {

        String username = prop.getProperty( "username" );
        String password = prop.getProperty( "password" );
        viewEmployeeListPage = loginPage.login( username, password );
    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}