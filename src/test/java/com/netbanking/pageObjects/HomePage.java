package com.netbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;

    public HomePage(WebDriver webDriver)
    {
        driver = webDriver;
        PageFactory.initElements(webDriver,this);
    }


}
