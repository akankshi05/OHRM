package com.ohrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver xdriver;

    public DashboardPage(WebDriver ydriver){

        xdriver = ydriver;
        PageFactory.initElements(ydriver,this);
    }

    @FindBy(tagName = "h1")
    WebElement Header;

    public String getHeaderValue(){
        return Header.getText();
    }
}
