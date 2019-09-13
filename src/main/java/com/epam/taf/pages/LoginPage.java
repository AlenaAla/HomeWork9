package com.epam.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    private static final String URL = "http://appellatecmsmssql.demo.int.thomsonreuters.com";

    @FindBy(name = "userName")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "submit")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void login(String userName, String userPassword) {
        loginField.sendKeys(userName);
        passwordField.sendKeys(userPassword);
        loginButton.click();
    }
}
