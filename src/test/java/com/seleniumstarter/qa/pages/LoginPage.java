package com.seleniumstarter.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumstarter.qa.base.TestBase;

public class LoginPage extends TestBase {

    // we will use page factory to locate the elements and store them in this OR
    
    //username input field
    @FindBy(xpath="//input[contains(@id,'txtUsername')]")
    WebElement inputUserName;
    
    //password field
    @FindBy(xpath="//input[contains(@id,'txtPassword')]")
    WebElement inputPassword;
    
    //submit/login button
    @FindBy(xpath="//input[contains(@id,'btnLogin')]")
    WebElement btnSubmit;
    
    //page title
    @FindBy(xpath="//title[text()='OrangeHRM']")
    WebElement title;
    
    //app logo
    @FindBy(xpath="//img[contains(@src,'logo.png')]")
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
    public DashBoardPage login(String usr, String pssd) {

        inputUserName.sendKeys( usr );
        inputPassword.sendKeys( pssd );
        btnSubmit.click();
        return new DashBoardPage();
    }
}
