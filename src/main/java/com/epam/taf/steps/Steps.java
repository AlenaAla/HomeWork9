package com.epam.taf.steps;

import com.epam.taf.driver.DriverSingleton;
import com.epam.taf.model.User;
import com.epam.taf.pages.CreateNewUserPage;
import com.epam.taf.pages.HomePage;
import com.epam.taf.pages.LoginPage;
import com.epam.taf.pages.ManageUserPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class Steps {

    private static final Logger logger = LogManager.getRootLogger();


    public static void loginCMS(User defaultUser) {
        LoginPage page = new LoginPage();
        page.openPage();
        page.loginField.sendKeys(defaultUser.getUsername());
        page.passwordField.sendKeys(defaultUser.getPassword());
        page.loginButton.click();
        logger.info("Login is performing");
     }

    public static boolean isUserLoggedIn(String fullName) {
        HomePage homePage = new HomePage();
        String actualUserName = homePage.getLoggedInUserName();
        return actualUserName.equals(fullName);
    }


    public static void navigateToEntityManagementViaTopMenu() {
        HomePage homePage = new HomePage();
        new Actions(DriverSingleton.getDriver()).moveToElement(homePage.administrativeTopMenu).perform();
        homePage.waitForElementVisible1(homePage.userAdminMenuUnderTopMenu);
        homePage.userAdminMenuUnderTopMenu.click();
        logger.info("User Admin menu is clicked");
    }

    public static void createNewUser(User randomUser) {
        CreateNewUserPage createNewUserPage = new CreateNewUserPage();
        createNewUserPage.openPage();
        logger.info("Opening Create New App User page");
        new Actions(DriverSingleton.getDriver()).sendKeys(createNewUserPage.password, randomUser.getPassword() ).sendKeys(createNewUserPage.firstName, randomUser.getFirstName()).sendKeys(createNewUserPage.lastName, randomUser.getLastName()).build().perform();
        logger.info("Filling in Password, Fisrt Name, Last Name fields");
        new Select(createNewUserPage.loginPageDropdown).selectByVisibleText("Main Case Search");
        logger.info("Selecting value for  Login dropdown");
        List<WebElement> courtsOptions = new Select(createNewUserPage.courts).getOptions();

        ArrayList<String> expectedOptions = new ArrayList<String>();
        expectedOptions.add("Court of Appeals");
        expectedOptions.add("Supreme Court");
        Actions actions = new Actions(DriverSingleton.getDriver());

        for (int i = 0; i < courtsOptions.size(); i++)
        {
            WebElement optionElement = courtsOptions.get(i);
            String actualOption = optionElement.getText();
            if(expectedOptions.contains(actualOption))
            {
                actions.keyDown(Keys.CONTROL).click(optionElement).keyUp(Keys.CONTROL);
            }
        }

        actions.build().perform();
        logger.info("Selecting both options from Courts dropdown");

        createNewUserPage.username.sendKeys(randomUser.getUsername());
        logger.info("Filling in UserName fields");
        createNewUserPage.email.sendKeys(randomUser.getUsername()+ "@thomsonreuters.com");
        logger.info("Filling in email fields");
        createNewUserPage.saveUserButton.click();
        logger.info("clicking Save button");



    }

    public static boolean verifyUserName(String randomUserName) {
        ManageUserPage manageUserPage = new ManageUserPage();

        String actualUserName = manageUserPage.getUserName();
        System.out.println(actualUserName);
        logger.info("Getting actual UserName");
        return actualUserName.equals(randomUserName);

    }


}

    
    









