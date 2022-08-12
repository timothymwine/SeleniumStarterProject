package com.seleniumstarter.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumstarter.qa.base.TestBase;

public class DashBoardPage extends TestBase {
    
    @FindBy(xpath = "//a[@id='menu_dashboard_index']")
     WebElement linkDashBoard;
    
    @FindBy(xpath = "//a[@id='welcome']")
    WebElement linkWelcomeLabel;
    
    @FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
    WebElement linkViewAdmin;
    
    @FindBy(xpath = "//a[@id='aboutDisplayLink']")
    WebElement linkAbout;
    
    @FindBy(xpath = "//a[text()='Support']")
    WebElement linkSupport;
    
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement linkLogout;
    
    @FindBy(xpath = "//span[text()='Assign Leave']//parent::a")
    WebElement linkAssignLeave;
    
    //initialising the dashboard page objects
    public DashBoardPage() {
    
        PageFactory.initElements( driver, this );
    }
    
    public String validateLoginPageTitle() {

        return driver.getTitle();
    }
    
    public String validateDashboardURL() {
    
        return driver.getCurrentUrl();
    }
    
    public DashBoardPage clickOnLinkDashBoard() {
    
        linkDashBoard.click();
        return new DashBoardPage();
    }
    
    public ViewSystemUserPage clickOnLinkViewAdmin() {
        
        linkViewAdmin.click();
        return new ViewSystemUserPage();
    }
    
    public boolean verifyWelcomeLabel() {
    
        return linkWelcomeLabel.isDisplayed();
    }
    
    public void clickOnLinkWelcomeLabel() {
    
        linkWelcomeLabel.click();
    }
    
    public LoginPage clickOnLinkLogOut() {
    
        linkLogout.click();
        return new LoginPage();
    }
    
    public SupportPage clickOnLinkSupport() {
    
        linkSupport.click();
        return new SupportPage();
    }
    
    public AssignLeavePage clickOnLinkAssignLeave() {
        linkAssignLeave.click();
        return new AssignLeavePage();
    }
}
