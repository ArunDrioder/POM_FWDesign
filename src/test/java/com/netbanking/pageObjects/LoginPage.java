package com.netbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver webDriver)
    {
        driver = webDriver;
        PageFactory.initElements(webDriver, this);
        // TODO Auto-generated constructor stub
    }

    @FindBy(name = "uid")
    public WebElement userIDElement;

    @FindBy(name = "password")
    public WebElement passwordElement;

    @FindBy(name = "btnLogin")
    public WebElement loginBtnElement;

    @FindBy(linkText = "Log out")
    public WebElement logOut;




    public void setUserID(String userID)
    {
        userIDElement.sendKeys(userID);
    }

    public void setPassword(String password)
    {
        passwordElement.sendKeys(password);
    }

    public void clickLogin()
    {
        loginBtnElement.click();
    }

    public void clickLogOut()
    {
        logOut.click();
    }





}