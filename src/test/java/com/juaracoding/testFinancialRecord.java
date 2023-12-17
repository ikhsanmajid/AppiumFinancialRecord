package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
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
        dc.setCapability("udid", "192.168.100.41:40645");
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

    @Test(priority = 2)
    public void addRecordPengeluaran(){
        MobileElement addBtn = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/fabMenu"));
        addBtn.click();
        MobileElement tanggalPopup = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/tvDate"));
        tanggalPopup.click();
        MobileElement tanggal = (MobileElement) driver.findElement(By.xpath("//android.view.View[@content-desc='17 Desember 2023']"));
        tanggal.click();
        MobileElement okBtn = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
        okBtn.click();
        MobileElement jumlah = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/etAmount"));
        jumlah.sendKeys("400000");
        MobileElement notes = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/etNote"));
        notes.sendKeys("Makan-makan");
        MobileElement saveBtn = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/btSave"));
        saveBtn.click();
        MobileElement pengeluaranRecords = (MobileElement) driver.findElement(By.xpath("//android.widget.ExpandableListView[@resource-id='com.chad.financialrecord:id/elTransaction']/android.widget.RelativeLayout"));
        String tanggalRecord = pengeluaranRecords.findElement(By.id("com.chad.financialrecord:id/tvDateOne")).getAttribute("text");
        System.out.println(tanggalRecord);
        List<MobileElement> listRecords = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.ExpandableListView[@resource-id='com.chad.financialrecord:id/elTransaction']/android.widget.LinearLayout"));
        String namaExpenseRecord = listRecords.get(0).findElement(By.id("com.chad.financialrecord:id/tvName")).getAttribute("text");
        System.out.println(namaExpenseRecord);
        String amountExpenseRecord = listRecords.get(0).findElement(By.id("com.chad.financialrecord:id/tvAmount")).getAttribute("text");
        System.out.println(amountExpenseRecord);
        Assert.assertEquals(tanggalRecord, "17");
        Assert.assertEquals(namaExpenseRecord, "Makanan");
        Assert.assertEquals(amountExpenseRecord, "400.000");
    }

    @Test(priority = 1)
    public void addRecordPemasukan(){
        MobileElement addBtn = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/fabMenu"));
        addBtn.click();
        MobileElement pemasukanBtn = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/btnIncome"));
        pemasukanBtn.click();
        MobileElement tanggalPopup = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/tvDate"));
        tanggalPopup.click();
        MobileElement tanggal = (MobileElement) driver.findElement(By.xpath("//android.view.View[@content-desc='01 Desember 2023']"));
        tanggal.click();
        MobileElement okBtn = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
        okBtn.click();
        MobileElement jumlah = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/etAmount"));
        jumlah.sendKeys("2000000");
        MobileElement notes = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/etNote"));
        notes.sendKeys("Gaji November");
        MobileElement saveBtn = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/btSave"));
        saveBtn.click();
        MobileElement pemasukanRecords = (MobileElement) driver.findElement(By.xpath("//android.widget.ExpandableListView[@resource-id='com.chad.financialrecord:id/elTransaction']/android.widget.RelativeLayout"));
        String tanggalRecord = pemasukanRecords.findElement(By.id("com.chad.financialrecord:id/tvDateOne")).getAttribute("text");
        System.out.println(tanggalRecord);
        List<MobileElement> listRecords = (List<MobileElement>) driver.findElements(By.xpath("//android.widget.ExpandableListView[@resource-id='com.chad.financialrecord:id/elTransaction']/android.widget.LinearLayout"));
        String namaIncomeRecord = listRecords.get(0).findElement(By.id("com.chad.financialrecord:id/tvName")).getAttribute("text");
        System.out.println(namaIncomeRecord);
        String amountIncomeRecord = listRecords.get(0).findElement(By.id("com.chad.financialrecord:id/tvAmount")).getAttribute("text");
        System.out.println(amountIncomeRecord);
        Assert.assertEquals(tanggalRecord, "01");
        Assert.assertEquals(namaIncomeRecord, "Gaji");
        Assert.assertEquals(amountIncomeRecord, "2.000.000");
    }

    @Test(enabled = false)
    public void finish(){
        driver.quit();
    }
}
