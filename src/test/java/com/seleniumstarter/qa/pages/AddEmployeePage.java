package com.seleniumstarter.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumstarter.qa.base.TestBase;

/**
 * @author Timothy Mwine
 * @date   16 august 2022
 */
public class AddEmployeePage extends TestBase {

    @FindBy( xpath = "//input[@id='firstName']" )
    WebElement inputFirstName;

    @FindBy( xpath = "//input[@id='middleName']" )
    WebElement inputMiddleName;

    @FindBy( xpath = "//input[@id='lastName']" )
    WebElement inputLastName;

    @FindBy( xpath = "//input[@id='employeeId']" )
    WebElement inputEmployeeId;

    @FindBy( xpath = "//input[@id='photofile']" )
    WebElement inputPhotograph;

    @FindBy( xpath = "//input[@id='btnSave']" )
    WebElement inputSaveBtn;

    public AddEmployeePage() {

        PageFactory.initElements( driver, this );
    }


    public String validateAddEmployeePageURL() {

        return driver.getCurrentUrl();
    }


    public ViewMyDetailsPage createEmployee( String fname, String mname, String lname, String id ) {

        inputFirstName.sendKeys( fname );
        inputMiddleName.sendKeys( mname );
        inputLastName.sendKeys( lname );
        inputEmployeeId.sendKeys( id );
        inputSaveBtn.click();
        return new ViewMyDetailsPage();
    }
}
