package com.ohrm.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver xdriver;

    public LoginPage(WebDriver ydriver){
        xdriver=ydriver;

        PageFactory.initElements(ydriver,this);
    }

    @FindBy(id = "txtUsername")
    WebElement Username;

    @FindBy(id = "txtPassword")
    WebElement Password;

    @FindBy(id = "btnLogin")
    WebElement LoginButton;


    public void setUsername(String uname){
        Username.sendKeys(uname);
    }

    public void setPassword(String pwd){
        Password.sendKeys(pwd);
    }

    public void clickLogin(){
        LoginButton.click();
    }
}
