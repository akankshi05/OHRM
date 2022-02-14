package com.ohrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage {

    WebDriver xdriver;

    public AddUserPage(WebDriver ydriver){

        xdriver = ydriver;

        PageFactory.initElements(ydriver,this);
    }

    @FindBy(tagName = "h1")
    WebElement Header;

    @FindBy(id = "systemUser_employeeName_empName")
    WebElement EmployeeName;

    @FindBy(id ="systemUser_userName")
    WebElement Username;

    @FindBy(id = "systemUser_password")
    WebElement Password;

    @FindBy(id ="systemUser_confirmPassword")
    WebElement ConfirmPassword;

    @FindBy(id = "btnSave")
    WebElement SaveButton;

    public String AddUserHeader(){
       return Header.getText();
    }

    public void EmployeeName(String empname){
        EmployeeName.sendKeys(empname);
    }

    public void UserName(String Uname){
        Username.sendKeys(Uname);
    }

    public void Password(String pwd){
        Password.sendKeys(pwd);
    }

    public void ConfirmPassword(String CPwd){
        ConfirmPassword.sendKeys(CPwd);
    }

    public void clickSave(){
        SaveButton.click();
    }
}
