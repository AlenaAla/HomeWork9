package com.epam.taf.service;

import com.epam.taf.model.UserForLogin;

public class UserForLoginCreator {


    public static final String USER_NAME = "testdata.user.name";
    public static final String USER_PASSWORD = "testdata.user.password";

    public static UserForLogin withCredentialsFromProperty(){
        return new UserForLogin(TestDataReader.getTestData(USER_NAME),
                TestDataReader.getTestData(USER_PASSWORD));
    }

}