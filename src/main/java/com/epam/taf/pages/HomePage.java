package com.epam.taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='header-username']")
    private WebElement fullUserNameLabel;

    //@FindBy(xpath = "//div[@class='menu-header-item ui-state-default']/a[contains(text(),'Administrative')]")
    @FindBy (xpath = "//a[@href='/ctrack/menu.do?menuHeaderID=4']")
    private WebElement administrativeTopMenu;


    @FindBy (xpath = "//a[@href='/ctrack/admin/menuUserAdmin.jsp?action=readonly'][@onclick='menuHeaderClose();']")
    private WebElement userAdminMenuUnderTopMenu;//1-st option


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUserName() {
        return fullUserNameLabel.getText();
    }

    public void openEntityManagementViaTopMenu() {


        new Actions(driver).moveToElement(administrativeTopMenu).perform();
        waitForElementVisible1(userAdminMenuUnderTopMenu);

        userAdminMenuUnderTopMenu.click();


          }


    }



