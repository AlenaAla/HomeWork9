package com.epam.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ManagePersonPage extends AbstractPage {

    @FindBy(xpath = "//table[@class='FormTable']//td[contains(text(), 'Last Name')]/../td[2]")
    private WebElement personLastNameLabel;


    public ManagePersonPage(WebDriver driver) {
        super(driver);
    }


    public String getPersonLastName() {
        return personLastNameLabel.getText();
    }

}
