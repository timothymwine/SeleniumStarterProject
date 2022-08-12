package com.seleniumstarter.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.seleniumstarter.qa.base.TestBase;

/**
 * @author Timothy Mwine
 * @date   12th August 2022
 */
public class AssignLeavePage extends TestBase {

    Select select;

    @FindBy( xpath = "//input[@id='assignleave_txtEmployee_empName']" )
    WebElement inputEmployeeName;

    @FindBy( id = "assignleave_txtLeaveType" )
    WebElement selectLeaveType;

    @FindBy( id = "assignleave_txtFromDate" )
    WebElement inputFromDate;

    @FindBy( id = "assignleave_txtToDate" )
    WebElement inputToDate;

    @FindBy( id = "assignleave_txtComment" )
    WebElement textAreaComment;

    @FindBy( id = "assignleave_partialDays" )
    WebElement selectPartialDays;

    @FindBy( id = "assignBtn" )
    WebElement inputAssignButton;

    @FindBy( xpath = "//input[@id='confirmOkButton']" )
    WebElement inputConfirmLeaveAssignOk;

    public AssignLeavePage() {

        PageFactory.initElements( driver, this );
    }


    public void clickAndInputEmployeeName( String empName ) {

        inputEmployeeName.sendKeys( empName );
    }


    public void clickOnSelectLeaveType( String leaveType, String fromDate, String toDate,
            String partialDays ) {

        select = new Select( selectLeaveType );
        select.selectByVisibleText( leaveType );
        inputFromDate.sendKeys( fromDate );
        inputToDate.sendKeys( toDate );
        select = new Select( selectPartialDays );
        select.selectByVisibleText( partialDays );
    }
}
