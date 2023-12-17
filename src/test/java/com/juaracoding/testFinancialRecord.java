package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class testFinancialRecord {


    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Redmi Note 10 Pro");
        dc.setCapability("udid", "192.168.100.41:42305");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset", "false");
        dc.setCapability("autoGrantPermissions", "true");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']")).click();
    }

    @Test
    public void addRecord(){
        MobileElement addBtn = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/fabMenu"));
        addBtn.click();
        MobileElement tanggalPopup = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/tvDate"));
        tanggalPopup.click();
        MobileElement tanggal = (MobileElement) driver.findElement(By.xpath("//android.view.View[@content-desc='17 Desember 2023']"));
        tanggal.click();
        MobileElement okBtn = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
        okBtn.click();
        MobileElement kategoriSelect = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/tvName"));
        kategoriSelect.click();
        List<MobileElement> kategori = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.ListView/android.widget.LinearLayout"));
        kategori.get(2).click();


    }

    @Test(enabled = false)
    public void finish(){
        driver.quit();
    }
}
