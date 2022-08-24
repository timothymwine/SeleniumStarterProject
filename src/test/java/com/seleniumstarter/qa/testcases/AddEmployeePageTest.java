package com.seleniumstarter.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumstarter.qa.base.TestBase;
import com.seleniumstarter.qa.pages.AddEmployeePage;
import com.seleniumstarter.qa.pages.LoginPage;
import com.seleniumstarter.qa.pages.ViewEmployeeListPage;
import com.seleniumstarter.qa.util.TestUtil;

/**
 * @author Timothy Mwine
 *@date    16 August 2022
 */
public class AddEmployeePageTest extends TestBase {

    private LoginPage loginPage;
    private AddEmployeePage addEmployeePage;
    private ViewEmployeeListPage dashBoardPage;
    private ViewEmployeeListPage viewEmployeeListPage;
    private String sheetName = "sheet1";

    @BeforeMethod
    public void setUp() {

        initialization();
        loginPage = new LoginPage();

        dashBoardPage = loginPage.login( prop.getProperty( "username" ), prop.getProperty(
                "password" ) );
        //viewEmployeeListPage = dashBoardPage.clickOnLinkPim();
        addEmployeePage = new AddEmployeePage();
        addEmployeePage = viewEmployeeListPage.clickLinkAddEmployeeBtn();
    }


    @Test( priority = 1 )
    public void verifyAddEmployeePageUrlTest() {

        String url = addEmployeePage.validateAddEmployeePageURL();

        Assert.assertEquals( url,
                "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee",
                "Actual url doesn't match expected url" );
    }


    @DataProvider
    public Object[][] getEmployeeData() {

        Object data[][] = TestUtil.getTestData( sheetName );
        return data;
    }


    @Test( priority = 2, dataProvider = "getEmployeeData" )
    public void validatecreateEmployee( String firstName, String middleName, String lastName,
            String identityNumber ) {

        viewEmployeeListPage.clickLinkAddEmployeeBtn();
        addEmployeePage.createEmployee( firstName, middleName, lastName, identityNumber );
    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}