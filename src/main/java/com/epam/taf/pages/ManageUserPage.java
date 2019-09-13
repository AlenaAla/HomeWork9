package com.epam.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageUserPage extends AbstractPage{

    @FindBy(xpath = "")
    private WebElement userNameLabel;

    public ManageUserPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return userNameLabel.getText();
    }
}
