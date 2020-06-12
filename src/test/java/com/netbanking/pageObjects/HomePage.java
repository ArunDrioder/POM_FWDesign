package com.netbanking.pageObjects;

import com.netbanking.testCases.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    public static WebDriver driver;

    public HomePage(WebDriver webDriver)
    {
        driver = webDriver;
        PageFactory.initElements( driver,this);
    }

    @FindBy(linkText = "New Customer")
    WebElement newCustomerLink;

    @FindBy(linkText = "Log out")
    WebElement logOut;

    public void newCustomerLink()
    {
        newCustomerLink.click();
    }

    public void logOut()
    {
        logOut.click();
    }
}
