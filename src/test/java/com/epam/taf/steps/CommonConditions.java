package com.epam.taf.steps;

import com.epam.taf.driver.DriverSingleton;
import com.epam.taf.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    protected Steps steps;


    @BeforeMethod(description = "init browser")//added within module9
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    //@AfterMethod (alwaysRun = true)
    public void stopBrowser(){
        steps.closeBrowser();}

}
