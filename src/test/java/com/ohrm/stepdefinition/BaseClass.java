package com.ohrm.stepdefinition;
import com.ohrm.Utilities.ReadConfig;
import com.ohrm.pages.AddUserPage;
import com.ohrm.pages.DashboardPage;
import com.ohrm.pages.LoginPage;
import com.ohrm.pages.SystemUsersPage;
import org.apache.log4j.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class BaseClass {

    ReadConfig rc = new ReadConfig();
    public String url = rc.getUrl();
    public String username = rc.getUserName();
    public String password = rc.getPassword();

    WebDriver driver;
    Logger logger;
    LoginPage login;
    DashboardPage dash;
    SystemUsersPage SystemUsers;
    AddUserPage AddUser;

    String RandomUsername = "Test" + new Random().nextInt(1000);

    public void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver","src/Drivers/chromedriver.exe");
         driver = new ChromeDriver();
    }

    public void login(){

        logger = Logger.getLogger("OrangeHRM");
        PropertyConfigurator.configure("src/log4j.properties");

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

    public void CloseBrowser(){
        driver.quit();
    }


}
