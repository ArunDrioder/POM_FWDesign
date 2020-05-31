package com.netbanking.testCases;

import com.netbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestClass extends BaseClass
{
    @Test
    public void login() throws IOException {

        driver.manage().window().maximize();
        driver.get(baseURL);

        LoginPage lpage = new LoginPage(driver);
        lpage.setTextUsername(username);
        lpage.setTextPassword(password);
        lpage.clickLoginBtn();

        if (driver.getTitle().equals("Guru99 Bank Manager HomePages"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
        }





    }

}
