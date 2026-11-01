package io.github.sabo2560.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationScript {
    static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/");
            System.out.println("Title: " + driver.getTitle());
            System.out.println("URL: " + driver.getCurrentUrl());
            driver.navigate().to("https://the-internet.herokuapp.com/login");
            System.out.println("Title: " + driver.getTitle());
            System.out.println("URL: " + driver.getCurrentUrl());

            driver.navigate().back();
            System.out.println("Title: " + driver.getTitle());
            System.out.println("URL: " + driver.getCurrentUrl());

            driver.navigate().forward();
            System.out.println("Title: " + driver.getTitle());
            System.out.println("URL: " + driver.getCurrentUrl());

            driver.navigate().refresh();

        } finally {
            driver.quit();
        }
    }
}
