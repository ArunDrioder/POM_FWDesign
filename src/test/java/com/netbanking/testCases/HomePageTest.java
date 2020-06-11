package com.netbanking.testCases;

import com.netbanking.pageObjects.HomePage;
import com.netbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePageTest extends BaseClass
{
    @Test(priority = 1)
    public void login()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserID(userID);
        loginPage.setPassword(password);
        loginPage.clickLogin();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        if (isAlertPresent()==true)
        {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
        }
        else
        {
            Assert.assertTrue(true);
        }
    }

    @Test(priority = 2)
    public void homePageTest()
    {
        HomePage homePage = new HomePage(driver);
        homePage.newCustomerLink();
        driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
        driver.navigate().back();
        homePage.logOut();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.switchTo().alert().accept();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.switchTo().defaultContent();
    }


}
