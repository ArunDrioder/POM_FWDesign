package com.netbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    WebDriver driver;

    public LoginPage(WebDriver webDriver)
    {
        driver = webDriver;
        PageFactory.initElements(webDriver,this);

    }
    @FindBy(name = "uid")
    WebElement textUsername;

    @FindBy(name = "password")
    WebElement textPassword;

    @FindBy(name = "btnLogin")
    WebElement btnLogin;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logoutBtn;

    public void setTextUsername(String username)
    {
        textUsername.sendKeys(username);
    }

    public void setTextPassword(String password)
    {
        textPassword.sendKeys(password);
    }

    public void clickLoginBtn()
    {
        btnLogin.click();
    }

    public void clickLogOutBtn()
    {
        logoutBtn.click();
    }



}
