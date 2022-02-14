package com.ohrm.stepdefinition;

import com.ohrm.pages.AddUserPage;
import com.ohrm.pages.SystemUsersPage;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UsersSD extends BaseClass {

    String employeeName;

    //Scenario1
    @When("clicked on User by navigating to Admin-UserManagement-Users")
    public void clicked_on_user_by_navigating_to_admin_user_management_users() {

        Logger logger = Logger.getLogger("OrangeHRM");
        PropertyConfigurator.configure("src/log4j.properties");

        setChromeDriver();
        login();
        SystemUsers = new SystemUsersPage(driver);
        SystemUsers.clickUsers();
        logger.info("Clicked on Users");

    }

    @Then("System users screen should Open")
    public void system_users_screen_should_open() {
        Assert.assertEquals("System Users",SystemUsers.HeaderText());

    }

    @When("clicked on Add")
    public void clicked_on_add() {
        SystemUsers.clickAdd();
        logger.info("Clicked on Add User");

    }
    @Then("Add User screen should Open")
    public void add_user_screen_should_open() {
        AddUser = new AddUserPage(driver);
       Assert.assertEquals("Add User",AddUser.AddUserHeader());
       logger.info("Add User page opened successfully");

    }

      String NewlyAddedUserName;
    @When("user enters User Role, {string}, Username ,Status ,{string},{string}")
    public void userEntersUserRoleUsernameStatus(String empname, String pwd, String Cpwd) {
        employeeName = empname;
        AddUser.clickSave();
        AddUser.EmployeeName(empname);
        AddUser.UserName(RandomUsername);
        NewlyAddedUserName = RandomUsername;
        AddUser.Password(pwd);
        AddUser.ConfirmPassword(Cpwd);

    }
    @When("clicks on Save")
    public void clicks_on_save() throws InterruptedException {
        Thread.sleep(3000);
        AddUser.clickSave();
        logger.info("Successfully clicked on Save");
        Thread.sleep(2000);


    }
    @Then("user should be successfully added")
    public void user_should_be_successfully_added() throws InterruptedException {

        SystemUsers.searchUsername(RandomUsername);
        SystemUsers.clickSearch();


        Assert.assertEquals(RandomUsername,SystemUsers.UsernameAdded());
        logger.info("User" + RandomUsername + "is added successfully");




    }

    @And("Added user should have the same username and Employee Name")
    public void addedUserShouldHaveTheSameUsernameAndEmployeeName() throws InterruptedException {


        List<WebElement> valuesFromTable = SystemUsers.AddedUserDetails();
        System.out.println("The values in list returned are:");
        for(WebElement x:valuesFromTable){
            System.out.println(x.getText());
        }

        Assert.assertEquals(NewlyAddedUserName,valuesFromTable.get(0).getText());
        logger.info("The Username is matching..");
        Assert.assertEquals(employeeName,valuesFromTable.get(2).getText());
        logger.info("The EmployeeName is matching..");


        Thread.sleep(1000);
        CloseBrowser();
    }

    //Scenario2
    @Then("print no. of users and all the usernames  on the screen")
    public void printNoOfUsersAndAllTheUsernamesOnTheScreen() {
        System.out.println(SystemUsers.UsersCount());
        System.out.println("The list of usernames is below:");
         for (WebElement x:SystemUsers.UsernameList()){
             System.out.println(x.getText());
         }


    }

    //Scenario3
    @Then("count the total no. of users")
    public void countTheTotalNoOfUsers() {

    }

    @And("total count of users should increase by {int}")
    public void totalCountOfUsersShouldIncreaseBy(int arg0) {

    }


    //Scenario4
    @When("user selects first row by checking the checkbox")
    public void userSelectsFirstRowByCheckingTheCheckbox()  {

        SystemUsers.Rowcheckbox();
    }

    @And("clicks on Delete")
    public void clicksOnDelete() {

        SystemUsers.clickDelete();
        SystemUsers.DeleteOkClick();
    }

    @Then("row should be successfully deleted")
    public void rowShouldBeSuccessfullyDeleted() {
        SystemUsers.DeleteSuccessMsgDisplay();
        logger.info("User is deleted successfully");
        CloseBrowser();

    }



}
