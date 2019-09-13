package com.epam.taf.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class CreateNewPersonPage extends AbstractPage {
    private static final String URL = "http://appellatecmsmssql.demo.int.thomsonreuters.com/ctrack/actor/person.do?action=create";

    @FindBy(id = "lastNm")
    private WebElement personLastName;

    @FindBy(xpath = "//*[@value='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@class='ui-state-error error-widget']/ul/li/a")
    private WebElement validationMessage;

    public CreateNewPersonPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void savePersonWithoutRequiredField() {
        saveButton.click();
    }

    public void createPerson(String newPersonLastName) {
        personLastName.sendKeys(newPersonLastName);
        saveButton.click();
    }
    public String getValidationMessage() { return validationMessage.getText();
    }

    public String getCurrentURL() {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        String currentURL = js.executeScript("return document.URL;").toString();
        System.out.println("Current URL = " + currentURL );
        return currentURL;

    }

    public String getCurrentPageTitle() {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        String currentPageTitle = js.executeScript("return document.title;").toString();
        System.out.println("Current Page Title = " + currentPageTitle);
        return currentPageTitle;
    }
}
