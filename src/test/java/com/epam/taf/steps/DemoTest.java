package com.epam.taf.steps;

import com.epam.taf.model.User;
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
        User testUser = UserForLoginCreator.withCredentialsFromProperty();
        Steps.loginCMS(testUser);
        Assert.assertTrue(steps.isUserLoggedIn(FULL_NAME));
    }


    @Test
    public void userCanReachToEntityManagementViaTopMenu(){
        User testUser = UserForLoginCreator.withCredentialsFromProperty();
        steps.loginCMS(testUser);
        steps.navigateToEntityManagementViaTopMenu();
    }

    @Test
    public void userCanBeCreated(){
        User testUser = UserForLoginCreator.withCredentialsFromProperty();
        steps.loginCMS(testUser);
        String randomName = StringUtils.generateRandomString();
        steps.createNewUser(randomName, newUserEmail);
        Assert.assertTrue(steps.verifyUserName(randomName));

       /* @Test
        public void userCanBeCreated(){
            User testUser = UserForLoginCreator.withCredentialsFromProperty();
            steps.loginCMS(testUser);
            String randomName = StringUtils.generateRandomString();
            steps.createNewUser(randomName, newUserEmail);
            Assert.assertTrue(steps.verifyUserName(randomName));//previous version*/
    }


}
