package io.github.sabo2560.scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AlertScript {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
            System.out.println("Result: " + driver.findElement(By.id("result")).getText());

            driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
            alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.dismiss();
            System.out.println("Result: " + driver.findElement(By.id("result")).getText());

            driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
            alert = driver.switchTo().alert();
            alert.sendKeys("Sabo");
            System.out.println("Alert text: " + alert.getText());
            alert.accept();

            System.out.println("Result: " + driver.findElement(By.id("result")).getText());

        } finally {
            driver.quit();
        }
    }
}
