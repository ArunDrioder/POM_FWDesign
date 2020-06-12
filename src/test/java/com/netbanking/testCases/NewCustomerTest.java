package com.netbanking.testCases;

import com.netbanking.pageObjects.HomePage;
import com.netbanking.pageObjects.LoginPage;
import com.netbanking.pageObjects.NewCustomerPage;
import com.netbanking.utilities.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NewCustomerTest extends BaseClass
{
    @Test(priority = 1)
    public void loginToHome()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserID(userID);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);

        if (driver.getPageSource().contains("Guru99"))
        {
            HomePage homePage = new HomePage(driver);
            homePage.newCustomerLink();
        }
    }



   @Test(priority = 3, dataProvider = "CustomerData")
    public void addCustomer(String custName, String custDobDay,String custDobMonth,String custDobYear,String custAddress,String custCity, String custState, String custPin, String custMobile, String custEmail, String custPassword) throws InterruptedException {
        NewCustomerPage customerPage = new NewCustomerPage(driver);

        customerPage.backToNewCust();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Thread.sleep(2000);
        customerPage.setCustName(custName);
        Thread.sleep(2000);
        customerPage.setCustGender();
        Thread.sleep(2000);
        customerPage.setCustDOB(custDobDay,custDobMonth,custDobYear);
        Thread.sleep(2000);
        customerPage.setCustAddr(custAddress);
        Thread.sleep(2000);
        customerPage.setCustCity(custCity);
        Thread.sleep(2000);
        customerPage.setCustState(custState);
        Thread.sleep(2000);
        customerPage.setCustPin(custPin);
        Thread.sleep(2000);
        customerPage.setCustPhone(custMobile);
        Thread.sleep(2000);
        customerPage.setCustEmail(custEmail);
        Thread.sleep(2000);
        customerPage.setCustPasword(custPassword);
        Thread.sleep(2000);
        customerPage.custSubmitData();

        driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);

         if (isAlertPresent())
       {
           Thread.sleep(4000);
           String alertMessage = driver.switchTo().alert().getText();
           System.out.println(alertMessage);
           driver.switchTo().alert().accept();
           driver.switchTo().defaultContent();
           driver.quit();

       }
         else if (driver.getPageSource().contains("Customer Registered Successfully!!!"))
         {
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

            Thread.sleep(5000);
            customerPage.backToNewCust();
        }
    }

    @DataProvider(name = "CustomerData")
    Object[][] getData() throws IOException
    {
        String path = "C:\\Backup\\Selenium - Workspace\\IdeaProjects\\POM_FWDesign\\src\\test\\java\\com\\netbanking\\testData\\excelData.xlsx";
        int rowNum = XLUtils.getRowCount(path, "customerData");
        int col_count = XLUtils.getCellCount(path, "customerData", 1);
        String[][] customerData = new String[rowNum][col_count];

        for(int i=1 ; i<= rowNum; i++)
        {
            for(int j=0;j<col_count;j++)
            {
                customerData[i-1][j] = XLUtils.getCellData(path, "customerData", i, j);

            }
        }

        return customerData;
    }


}
