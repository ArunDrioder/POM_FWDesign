package com.netbanking.testCases;

import com.netbanking.pageObjects.LoginPage;
import com.netbanking.utilities.ExcelDataReader;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTestClass extends BaseClass {
//    //--------------This is the test-cases for login using data from the config file----------//
//    @Test
//    public void login() throws IOException {
//        driver.manage().window().maximize();
//        driver.get(baseURL);
//
//        LoginPage lpage = new LoginPage(driver);
//        lpage.setTextUsername(username);
//        lpage.setTextPassword(password);
//        lpage.clickLoginBtn();
//
//        if (driver.getTitle().equals("Guru99 Bank Manager HomePages"))
//        {
//            Assert.assertTrue(true);
//        }
//        else
//        {
//            captureScreen(driver,"loginTest");
//            Assert.assertTrue(false);
//        }
//    }


    @Test
    void login() throws IOException, InterruptedException
    {
        ExcelDataReader dataReader = new ExcelDataReader("C:\\Backup\\Selenium - Workspace\\IdeaProjects\\POM_FWDesign\\src\\test\\java\\com\\netbanking\\testData\\excelData.xlsx");
        int rowCount = dataReader.getRowCount("Login");
        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
            LoginPage loginPage = new LoginPage(driver);
            driver.manage().window().maximize();
            driver.get(baseURL);

            driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

            String userName = dataReader.getCellData("Login", "username", rowNum);
            loginPage.setTextUsername(userName);

            System.out.println(userName);

            String userPassword = dataReader.getCellData("Login", "password", rowNum);
            loginPage.setTextPassword(userPassword);

            System.out.println(userPassword);

            loginPage.clickLoginBtn();

            Thread.sleep(3000);


            if (isAlertPresent() == true) {
                driver.switchTo().alert().accept();
                driver.switchTo().defaultContent();
                Assert.assertTrue(false);
            } else
                {
                Assert.assertTrue(true);
                loginPage.clickLogOutBtn();
                Thread.sleep(3000);
                driver.switchTo().alert().accept();
                driver.switchTo().defaultContent();
            }


            if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
                Assert.assertTrue(true);
            } else {
                captureScreen(driver, "LoginTest");

            }

        }
    }

    public boolean isAlertPresent ()
    {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }

    }
}

