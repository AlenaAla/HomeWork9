package com.epam.taf.pages;

import com.epam.taf.model.UserForLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
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
        logger.info("Login page opened");;
    }

    public void login(UserForLogin userForLogin) {
        loginField.sendKeys(userForLogin.getUsername());
        passwordField.sendKeys(userForLogin.getPassword());
        loginButton.click();
        logger.info("Login is performing");
    }
}
