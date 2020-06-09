package com.netbanking.testCases;

import com.netbanking.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    static ReadConfig readConfig = new ReadConfig();
    public static String baseURL = readConfig.getAppURL();
    public static String userID = readConfig.getUsername();
    public static String password = readConfig.getPassword();
    public static String browser = readConfig.getBrowser();
    public static WebDriver driver;


    @BeforeClass
    public void setUp()
    {
        if (browser.equals("chrome"))
        {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            driver = new ChromeDriver();
        }

        else if (browser.equals("firefox"))
        {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get(baseURL);

    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    public void captureScreen(WebDriver driver,String tname) throws IOException
    {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("C:/Backup/Selenium - Workspace/eclipse-workspace/NetBanking_Automation/Screenshots/" +tname +".png");
        FileUtils.copyFile(source, targetFile);
        System.out.println("Screenshot Taken");

    }

    public boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;

        }
        catch (NoAlertPresentException e)
        {
            return false;
        }
    }


}
