package com.seleniumstarter.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumstarter.qa.base.TestBase;
import com.seleniumstarter.qa.pages.DashBoardPage;
import com.seleniumstarter.qa.pages.LoginPage;
import com.seleniumstarter.qa.pages.ViewSystemUserPage;

/**
 * @author Timothy Mwine
 * @date   12th August 2022
 */
public class DashBoardPageTest extends TestBase {

    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;
    private ViewSystemUserPage viewSystemUserPage;

    public DashBoardPageTest() {

        super();
    }


    @BeforeMethod
    public void setUp() {

        initialization();
        loginPage = new LoginPage();
        dashBoardPage = loginPage.login( prop.getProperty( "username" ), prop.getProperty(
                "password" ) );

    }


    @Test( priority = 1 )
    public void validatePageTitleTest() {

        String dashBoardPageTitle = dashBoardPage.validateLoginPageTitle();
        Assert.assertEquals( dashBoardPageTitle, "OrangeHRM" );
    }


    @Test( priority = 2 )
    public void dashBoardUrlTest() {

        String url = dashBoardPage.validateDashboardURL();

        Assert.assertEquals( url, "https://opensource-demo.orangehrmlive.com/index.php/dashboard",
                "Actual url doesn't match expected url" );
    }


    @Test( priority = 3 )
    public void verifyWelcomeUserNameTest() {

        viewSystemUserPage = dashBoardPage.clickOnLinkViewAdmin();
    }


    @Test( priority = 4 )
    public void dashBoardLogOutTest() {

        dashBoardPage.clickOnLinkWelcomeLabel();
        loginPage = dashBoardPage.clickOnLinkLogOut();
    }


    @Test( priority = 5 )
    public void isWelcomeLabelPresent() {

        Assert.assertTrue( dashBoardPage.verifyWelcomeLabel() );
    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
