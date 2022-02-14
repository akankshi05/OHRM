package com.ohrm.stepdefinition;

import com.ohrm.pages.DashboardPage;
import com.ohrm.pages.LoginPage;
import io.cucumber.java.en.*;
import org.apache.log4j.*;
import org.junit.Assert;

public class LoginSD extends BaseClass{

    @Given("User logs into the OrangeHRM application")
    public void userLogsIntoTheOrangeHRMApplication() {

        logger = Logger.getLogger("OrangeHRM");
        PropertyConfigurator.configure("src/log4j.properties");

        //setChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        // Thread.sleep(2000);

        login = new LoginPage(driver);
        login.setUsername(username);
        logger.info("Entered Username");

        login.setPassword(password);
        logger.info("Entered Password");

        login.clickLogin();
        logger.info("Clicked Login Button");


        dash = new DashboardPage(driver);
        Assert.assertEquals("Dashboard",dash.getHeaderValue());
        logger.info("User Logged in successfully");
    }
}
