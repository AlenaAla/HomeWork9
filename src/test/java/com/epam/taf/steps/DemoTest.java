package com.epam.taf.steps;

import com.epam.taf.model.UserForLogin;
import com.epam.taf.service.UserForLoginCreator;
import com.epam.taf.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.*;



public class DemoTest extends CommonConditions{

    private static final String FULL_NAME = "Clerk Court";
    private static final String PERSON_LAST_NAME = "Alena";
    public static final String VALIDATION_MESSAGE = "Last Name is required.";
    public static final String CREATE_PERSON_PAGE_TITLE = "Create New Person";
    public static final String CREATE_NEW_PERSON_URL = "http://appellatecmsmssql.demo.int.thomsonreuters.com/ctrack/actor/person.do";
    private String newUserEmail = "lena@mail.ru";


    @Test
    public void userCanLogin() {
        UserForLogin testUser = UserForLoginCreator.withCredentialsFromProperty();
        steps.loginCMS(testUser);
        Assert.assertTrue(steps.isUserLoggedIn(FULL_NAME));
    }

   /* @Test
    public void createNewPersonValidation(){
        UserForLogin testUser = UserForLoginCreator.withCredentialsFromProperty();
        steps.loginCMS(testUser);
        steps.saveNewPersonWithoutRequiredField();
        Assert.assertTrue(steps.isValidationMessageReturns(VALIDATION_MESSAGE));
        Assert.assertTrue(steps.isUserStayedOnCreateNewPersonURL(CREATE_NEW_PERSON_URL), "...");
        Assert.assertTrue(steps.isPageTitleNotChanged(CREATE_PERSON_PAGE_TITLE));
    }

    @Test
    public void userCanCreateNewPerson() {
        UserForLogin testUser = UserForLoginCreator.withCredentialsFromProperty();
        steps.loginCMS(testUser);
        String personName = steps.createNewPerson("Alena");
        Assert.assertTrue(steps.isPersonCreated(PERSON_LAST_NAME));
    }*/

    @Test
    public void userCanReachToEntityManagementViaTopMenu(){
        UserForLogin testUser = UserForLoginCreator.withCredentialsFromProperty();
        steps.loginCMS(testUser);
        steps.navigateToEntityManagementViaTopMenu();
    }

    @Test
    public void userCanBeCreated(){
        UserForLogin testUser = UserForLoginCreator.withCredentialsFromProperty();
        steps.loginCMS(testUser);
        String randomName = StringUtils.generateRandomName();
        steps.createNewUser(randomName, newUserEmail);
        Assert.assertTrue(steps.verifyUserName(randomName));

       /* @Test
        public void userCanBeCreated(){
            UserForLogin testUser = UserForLoginCreator.withCredentialsFromProperty();
            steps.loginCMS(testUser);
            String randomName = StringUtils.generateRandomName();
            steps.createNewUser(randomName, newUserEmail);
            Assert.assertTrue(steps.verifyUserName(randomName));//previous version*/
    }

     /*@AfterMethod(description = "close browser")
     public void tearDown() {
         steps.closeBrowser();
     }*/

}
