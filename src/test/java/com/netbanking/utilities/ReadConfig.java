package com.netbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig
{
    Properties prop;

    public ReadConfig()
    {
        // TODO Auto-generated constructor stub
        File src = new File("C:\\Backup\\Selenium - Workspace\\IdeaProjects\\POM_FWDesign\\Configuration\\config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public String getAppURL()
    {
        String url = prop.getProperty("baseURL");
        return url;
    }

    public String getUsername()
    {
        String username = prop.getProperty("username");
        return username;
    }
    public String getPassword()
    {
        String password = prop.getProperty("password");
        return password;
    }

    public String getBrowser()
    {
        String browser  = prop.getProperty("browser");
        return browser;
    }

}
