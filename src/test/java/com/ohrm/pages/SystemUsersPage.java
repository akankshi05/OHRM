package com.ohrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SystemUsersPage {

    WebDriver xdriver;

    public SystemUsersPage(WebDriver ydriver){

        xdriver = ydriver;
        PageFactory.initElements(ydriver,this);
    }

    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement Administrator;

    @FindBy(xpath = "//a[@id='menu_admin_UserManagement']")
    WebElement UserManagement;

    @FindBy(xpath = "//a[@id='menu_admin_viewSystemUsers']")
    WebElement Users;

    @FindBy(id ="searchSystemUser_userName")
    WebElement UsernameSearchBox;

    @FindBy(tagName = "h1")
    WebElement Header;

    @FindBy(id ="btnAdd")
    WebElement AddButton;

    @FindBy(id ="searchBtn")
    WebElement SearchButton;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    WebElement AddedUsername;

    @FindBy(id = "btnDelete")
    WebElement Deletebutton;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    WebElement RowCheckbox;

    @FindBy(id ="dialogDeleteBtn")
    WebElement DeleteOK;

    @FindBy(id ="successBodyEdit")
    WebElement UserAddedSuccessMsg;

    @FindBy(id ="successBodyDelete")
    WebElement DeleteSuccessMsg;

    List<WebElement> userCount;




    public void clickUsers(){

        Actions ac = new Actions(xdriver);
        ac.moveToElement(Administrator).moveToElement(UserManagement).moveToElement(Users).click().build().perform();

    }

    public String HeaderText(){
        return Header.getText();
    }

    public void clickAdd(){
        AddButton.click();
    }

    public void searchUsername(String Uname){
        UsernameSearchBox.sendKeys(Uname);
    }

    public void clickSearch(){
        SearchButton.click();
    }

    public String UsernameAdded(){
        return AddedUsername.getText();
    }

    public List<WebElement> AddedUserDetails()
    {
        List<WebElement> addUserDetails= new ArrayList<WebElement>();

        for( int x=2 ; x<5 ;x++) {
                addUserDetails.add(xdriver.findElement(By.xpath("//tbody/tr[1]/td[" + x + "]")));
        }
        return addUserDetails;
    }

    public void clickDelete(){
        Deletebutton.click();
    }

    public void Rowcheckbox(){
        RowCheckbox.click();
    }

    public void DeleteOkClick(){
        DeleteOK.click();
    }

    public void DeleteSuccessMsgDisplay(){
        DeleteSuccessMsg.isDisplayed();
    }

    public String UserAddedSuccessMsg(){
        return UserAddedSuccessMsg.getText();
    }

    public int UsersCount(){
        userCount = xdriver.findElements(By.xpath("//tbody/tr"));
        return  userCount.size();
        }

        public List<WebElement> UsernameList(){
            userCount = xdriver.findElements(By.xpath("//tbody/tr"));
            List<WebElement> columns = xdriver.findElements(By.xpath("//tbody/tr[1]/td"));
            List<WebElement> usernames = new ArrayList<WebElement>();
            for(int x =1 ;x< userCount.size();x++){
                for(int y=2; y<columns.size();y++){
                    if(y == 2)
                      usernames.add(xdriver.findElement(By.xpath("//tbody/tr["+x+"]/td["+y+"]")));
                }

            }
            return usernames;
        }


}
