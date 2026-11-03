package io.github.sabo2560.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowScript {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/windows");
            String original = driver.getWindowHandle();
            System.out.println(driver.findElement(By.tagName("h3")).getText());

            driver.findElement(By.linkText("Click Here")).click();
            System.out.println(driver.getWindowHandles().size());

            for(String handle : driver.getWindowHandles()){
                if (!handle.equals(original)) {
                    driver.switchTo().window(handle);
                    System.out.println("New Window : " + driver.findElement(By.tagName("h3")).getText());
                    driver.close();
                    driver.switchTo().window(original);
                }
            }

            System.out.println(driver.findElement(By.tagName("h3")).getText());
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://the-internet.herokuapp.com/windows");
            System.out.println(driver.getCurrentUrl());
            driver.close();
            driver.switchTo().window(original);

        }finally {
            driver.quit();
        }
    }
}
