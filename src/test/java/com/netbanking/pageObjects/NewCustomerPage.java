package com.netbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage
{
    public static WebDriver driver;

    public NewCustomerPage(WebDriver webDriver)
    {
        driver = webDriver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "name")
    WebElement custName;

    @FindBy(name = "rad1")
    WebElement custGender;

    @FindBy(name = "dob")
    WebElement custDOB;

    @FindBy(name = "addr")
    WebElement custAddr;

    @FindBy(name = "city")
    WebElement custCity;

    @FindBy(name = "state")
    WebElement custState;

    @FindBy(name = "pinno")
    WebElement custPin;

    @FindBy(name = "telephoneno")
    WebElement custPhone;

    @FindBy (name = "emailid")
    WebElement custEmail;

    @FindBy (name = "password")
    WebElement custPasword;

    @FindBy(name = "sub")
    WebElement custSubmit;

    @FindBy(linkText = "New Customer")
    WebElement backToNewCust;

    @FindBy(linkText = "Log out")
    WebElement logout;

    public void setCustName(String name)
    {
        custName.sendKeys(name);
    }

    public void setCustGender()
    {
        custGender.click();
    }

    public void setCustDOB(String dobDay,String dobMonth,String dobYear)
    {
        custDOB.sendKeys(dobDay);
        custDOB.sendKeys(dobMonth);
        custDOB.sendKeys(dobYear);
    }

    public void setCustAddr(String address)
    {
        custAddr.sendKeys(address);
    }

    public void setCustCity(String city)
    {
        custCity.sendKeys(city);
    }

    public void setCustState(String state)
    {
        custState.sendKeys(state);
    }

    public void setCustPin(String pin)
    {
        custPin.sendKeys(pin);
    }

    public void setCustPhone(String phone)
    {
        custPhone.sendKeys(phone);
    }

    public void setCustEmail(String email)
    {
        custEmail.sendKeys(email);
    }

    public void setCustPasword(String password)
    {
        custPasword.sendKeys(password);
    }

    public void custSubmitData()
    {
        custSubmit.click();
    }

    public void backToNewCust()
    {
        backToNewCust.click();
    }

    public void clickLogout()
    {
        logout.click();
    }




}
