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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    static ReadConfig readConfig = new ReadConfig();
    public static String baseURL = readConfig.getAppURL();
    public static String username = readConfig.getUsername();
    public static String password = readConfig.getPassword();
    public static WebDriver driver;


    @Parameters("browser")
    @BeforeClass
    public void setup(String browser)
    {
        if (browser.equals("chrome")) {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("C:\\Backup\\Selenium - Workspace\\IdeaProjects\\POM_FWDesign\\Screenshots" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }


}
