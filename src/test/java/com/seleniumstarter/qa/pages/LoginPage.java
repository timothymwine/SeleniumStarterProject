package com.seleniumstarter.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumstarter.qa.base.TestBase;

/**
 * @author Timothy Mwine
 * @date   12th August 2022
 */
public class LoginPage extends TestBase {

    // we will use page factory to locate the elements and store them in this OR

    //username input field
    @FindBy( xpath = "//input[@name='username']" )
    WebElement inputUserName;

    //password field
    @FindBy( xpath = "//input[@name='password']" )
    WebElement inputPassword;

    //submit/login button
    @FindBy( xpath = "//button[text()=' Login ']" )
    WebElement btnSubmit;

    //page title
    @FindBy( xpath = "//title[text()='OrangeHRM']" )
    WebElement title;

    //app logo
    @FindBy( xpath = "//div[@class='orangehrm-login-branding']" )
    WebElement orangeLogo;

    //initialising the login page objects
    public LoginPage() {

        PageFactory.initElements( driver, this );
    }


    // action to validate login page title
    public String validateLoginPageTitle() {

        return driver.getTitle();
    }


    //validating if the logo is present
    public boolean validateOrangeLogo() {

        return orangeLogo.isDisplayed();
    }


    //method to login user
    public ViewEmployeeListPage login( String usr, String pssd ) {

        inputUserName.sendKeys( usr );
        inputPassword.sendKeys( pssd );
        btnSubmit.click();
        return new ViewEmployeeListPage();
    }
}
