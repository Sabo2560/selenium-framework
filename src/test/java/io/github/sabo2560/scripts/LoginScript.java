package io.github.sabo2560.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginScript {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            driver.get("https://the-internet.herokuapp.com/login");
            WebElement username = driver.findElement(By.id("username"));
            username.clear();
            username.sendKeys("tomsmith");

            WebElement pswd =  driver.findElement(By.id("password"));
            pswd.clear();
            pswd.sendKeys("SuperSecretPassword!");

            String type = driver.findElement(By.id("password")).getDomAttribute("type");
            System.out.println("Password field type: " + type);

            driver.findElement(By.cssSelector("button[type='submit']")).click();
            String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash"))).getText();
            System.out.println("message is: " + msg);

            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println("Links: " + links.size());
            for (WebElement link : links) {
                System.out.println(link.getText());
            }

            driver.get("https://the-internet.herokuapp.com/login");
            WebElement username2 = driver.findElement(By.id("username"));
            username2.clear();
            username2.sendKeys("tomsmith");

            driver.findElement(By.id("password")).sendKeys("NotSuperSecret!");
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            String errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash"))).getText();
            System.out.println("message is :" + errorMsg);

        }catch (NoSuchElementException e){
            throw new NoSuchElementException(e.getMessage());
        }
        finally {
            driver.quit();
        }

    }
}
