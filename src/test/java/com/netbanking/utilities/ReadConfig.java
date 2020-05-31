package com.netbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig
{
    Properties pro;

    public ReadConfig()
    {
        File src = new File("C:\\Backup\\Selenium - Workspace\\IdeaProjects\\POM_FWDesign\\Configuration\\config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public String getAppURL()
    {
        String url = pro.getProperty("baseURL");
        return url;
    }

    public String getUsername()
    {
        String username = pro.getProperty("username");
        return username;
    }
    public String getPassword()
    {
        String password = pro.getProperty("password");
        return password;
    }

}
