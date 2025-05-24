package com.testing;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Test Case 1: Simple Alert
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
        String result1 = driver.findElement(By.id("result")).getText();
        if (result1.equals("You successfully clicked an alert")) {
            System.out.println("Log: Simple alert accepted and verified.");
        }

        // Test Case 2: Confirmation Alert
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.dismiss();
        String result2 = driver.findElement(By.id("result")).getText();
        if (result2.equals("You clicked: Cancel")) {
            System.out.println("Log: Confirmation alert dismissed and verified.");
        }

        // Test Case 3: Prompt Alert
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("AutomationTest");
        promptAlert.accept();
        String result3 = driver.findElement(By.id("result")).getText();
        if (result3.equals("You entered: AutomationTest")) {
            System.out.println("Log: Prompt alert input submitted and verified.");
        }

        //driver.quit();
    }
}
