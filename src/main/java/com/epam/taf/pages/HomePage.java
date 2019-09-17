package com.epam.taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='header-username']")
    public WebElement fullUserNameLabel;

    //@FindBy(xpath = "//div[@class='menu-header-item ui-state-default']/a[contains(text(),'Administrative')]")
    @FindBy (xpath = "//a[@href='/ctrack/menu.do?menuHeaderID=4']")
    public  WebElement administrativeTopMenu;


    @FindBy (xpath = "//a[@href='/ctrack/admin/menuUserAdmin.jsp?action=readonly'][@onclick='menuHeaderClose();']")
    public WebElement userAdminMenuUnderTopMenu;//1-st option


    public HomePage() {
        super();
    }

    public String getLoggedInUserName() {
        return fullUserNameLabel.getText();
    }




    }



