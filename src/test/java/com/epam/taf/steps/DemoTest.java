package com.epam.taf.steps;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.*;

public class DemoTest {
    private static final String USER_NAME = "clerk1";
    private static final String USER_PASSWORD = "Thomson!0";
    private static final String FULL_NAME = "Clerk Court";
    private static final String PERSON_LAST_NAME = "Alena";
    public static final String VALIDATION_MESSAGE = "Last Name is required.";
    public static final String CREATE_PERSON_PAGE_TITLE = "Create New Person";
    public static final String CREATE_NEW_PERSON_URL = "http://appellatecmsmssql.demo.int.thomsonreuters.com/ctrack/actor/person.do";

    private Steps steps;


private String generateRandomName()
{
    return RandomStringUtils.random(5);
}

    @BeforeMethod(description = "init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void userCanLogin() {

        steps.loginCMS(USER_NAME, USER_PASSWORD);
        Assert.assertTrue(steps.isUserLoggedIn(FULL_NAME));
    }

    @Test
    public void userCanCreateNewPerson() {
        steps.loginCMS(USER_NAME, USER_PASSWORD);
        String personName = steps.createNewPerson("Alena");
        Assert.assertTrue(steps.isPersonCreated(PERSON_LAST_NAME));
    }

    @Test
    public void createNewPersonValidation(){
        steps.loginCMS(USER_NAME, USER_PASSWORD);
        steps.saveNewPersonWithoutRequiredField();
        //steps.isUserStayedOnCreatePersonPage();
        Assert.assertTrue(steps.isValidationMessageReturns(VALIDATION_MESSAGE));
        Assert.assertTrue(steps.isUserStayedOnCreateNewPersonURL(CREATE_NEW_PERSON_URL), "...");
        Assert.assertTrue(steps.isPageTitleNotChanged(CREATE_PERSON_PAGE_TITLE));
    }

    @Test
    public void userCanReachToEntityManagementViaTopMenu(){
        steps.loginCMS(USER_NAME,USER_PASSWORD);
        steps.navigateToEntityManagementViaTopMenu();
    }

    @Test
    public void userCanBeCreated(){
        steps.loginCMS(USER_NAME, USER_PASSWORD);
        String randomName = generateRandomName();
        steps.createNewUser(randomName);
        steps.verifyUserName(randomName);
    }

     /*@AfterMethod(description = "close browser")
     public void tearDown() {
         steps.closeBrowser();
     }*/

}
