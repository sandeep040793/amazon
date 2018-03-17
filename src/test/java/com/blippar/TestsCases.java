package com.blippar;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class TestsCases {

    @Test
    public void testForFailedLogin() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/apple/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://web.blippar.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        WebElement loginButton = driver.findElement(By.cssSelector("a[href = 'https://hub.blippar.com']"));
        loginButton.click();

        ArrayList<String> list = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(list.get(1));

        Thread.sleep(2*1000);
        WebElement userId = driver.findElement(By.cssSelector("input[name='email']"));
        userId.sendKeys("sandeep.ahuj@blippar.com");

        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys("Sandeep1993");

        WebElement submitButton = driver.findElement(By.cssSelector("button[data-test-id='accounts_login']"));
        submitButton.click();

        Thread.sleep(2*1000);

        String url = driver.getCurrentUrl();

        Assert.assertTrue(url.contains("accounts.blippar.com"));

        driver.quit();
    }

    @Test
    public void testForSuccessLogin() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/apple/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://web.blippar.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        WebElement loginButton = driver.findElement(By.cssSelector("a[href = 'https://hub.blippar.com']"));
        loginButton.click();

        ArrayList<String> list = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(list.get(1));

        Thread.sleep(2*1000);
        WebElement userId = driver.findElement(By.cssSelector("input[name='email']"));
        userId.sendKeys("sandeep.ahuja@blippar.com");

        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys("Sandeep1993");

        WebElement submitButton = driver.findElement(By.cssSelector("button[data-test-id='accounts_login']"));
        submitButton.click();

        Thread.sleep(2*1000);

        String url = driver.getCurrentUrl();

        Assert.assertTrue(url.contains("hub.blippar.com"));

        driver.quit();
    }

}
