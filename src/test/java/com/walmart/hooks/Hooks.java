package com.walmart.hooks;

import com.walmart.sites.WalmartSite;
import com.walmart.utils.Properties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public WebDriver driver;
    public WalmartSite walmartSite;

    public WebDriver getDriver()
    {
        return driver;
    }

    public WalmartSite getWalmartSite()
    {
        return walmartSite;
    }

    @Before
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Properties.MID_WAIT, TimeUnit.SECONDS);
        walmartSite = new WalmartSite(driver);
        driver.manage().window().maximize();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}