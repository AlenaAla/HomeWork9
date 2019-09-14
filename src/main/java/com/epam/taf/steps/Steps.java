package com.epam.taf.steps;

import com.epam.taf.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Steps {
    private WebDriver driver;

    public void loginCMS(String userName, String userPassword) {
        LoginPage page = new LoginPage(driver);
        page.openPage();
        page.login(userName, userPassword);
    }

    public boolean isUserLoggedIn(String fullName) {
        HomePage homePage = new HomePage(driver);
        String actualUserName = homePage.getLoggedInUserName();
        return actualUserName.equals(fullName);
    }

    /*public void initBrowser() {
        this.driver = new ChromeDriver();    }*/

    public void initBrowser() {

            this.driver = new ChromeDriver();


       /* try{
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }*/
    }

    public void closeBrowser() {
        this.driver.close();
    }



    public String createNewPerson(String newPersonLastName) {
        CreateNewPersonPage page = new CreateNewPersonPage(driver);
        page.openPage();
        page.createPerson(newPersonLastName);
        return newPersonLastName;
    }

    public boolean isPersonCreated(String personLastName) {
        ManagePersonPage managePersonPage = new ManagePersonPage(driver);
        String actualPersonLastName = managePersonPage.getPersonLastName();
        return actualPersonLastName.equals(personLastName);
    }


    public void saveNewPersonWithoutRequiredField() {
        CreateNewPersonPage page = new CreateNewPersonPage(driver);
        page.openPage();
        page.savePersonWithoutRequiredField();
    }

    public boolean isValidationMessageReturns(String validationMessage) {
        CreateNewPersonPage page = new CreateNewPersonPage(driver);
        String actualValidationMessage = page.getValidationMessage();
        return actualValidationMessage.equals(validationMessage);
    }

    public boolean isUserStayedOnCreateNewPersonURL(String createNewPersonURL) {
        CreateNewPersonPage page = new CreateNewPersonPage(driver);
        String actualPageURL = page.getCurrentURL();
        return actualPageURL.equals(createNewPersonURL);
    }

    public boolean isPageTitleNotChanged(String createPersonPageTitle) {
        CreateNewPersonPage page = new CreateNewPersonPage(driver);
        String actualPageTitle = page.getCurrentPageTitle();
        return actualPageTitle.equals(createPersonPageTitle);
    }

    public void navigateToEntityManagementViaTopMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.openEntityManagementViaTopMenu();
    }

    public void createNewUser(String newUserName, String newUserEmail) {
        CreateNewUserPage createNewUserPage = new CreateNewUserPage(driver);
        createNewUserPage.openPage();
        createNewUserPage.createUser(newUserName, newUserEmail);

    }

    public boolean verifyUserName(String randomName) {
        ManageUserPage manageUserPage = new ManageUserPage(driver);
        String actualUserName = manageUserPage.getUserName();
        return actualUserName.equals(randomName);
    }
}

    
    









