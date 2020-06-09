package com.netbanking.testCases;

import com.netbanking.pageObjects.LoginPage;
import com.netbanking.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseClass
{
    @Test(dataProvider = "LoginData")
    public void excelLogin(String userID, String passworD)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserID(userID);
        loginPage.setPassword(passworD);
        loginPage.clickLogin();


        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        if (isAlertPresent()==true)
        {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
        }

        else
        {
            Assert.assertTrue(true);
            loginPage.clickLogOutBtn();

            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            driver.switchTo().alert().accept();

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.switchTo().defaultContent();

        }

    }

    @DataProvider(name = "LoginData")
    Object[][] getData() throws IOException
    {
       String path = "C:\\Backup\\Selenium - Workspace\\IdeaProjects\\POM_FWDesign\\src\\test\\java\\com\\netbanking\\testData\\excelData.xlsx";
        int rowNum = XLUtils.getRowCount(path, "Login");
        int col_count = XLUtils.getCellCount(path, "Login", 1);
        String[][] loginData = new String[rowNum][col_count];

        for(int i=1 ; i<= rowNum; i++)
        {
            for(int j=0;j<col_count;j++)
            {
                loginData[i-1][j] = XLUtils.getCellData(path, "Login", i, j);

            }
        }

        return loginData;
    }





}
