package io.github.sabo2560.scripts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ScreenshotScript {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/");
            File sc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Path target = Path.of("screenshots", "home.png");
            Files.createDirectories(target.getParent());
            Files.copy(sc.toPath(), target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Saved : " + target.toAbsolutePath());

            driver.get("https://the-internet.herokuapp.com/login");
            WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
            File buttonShot = button.getScreenshotAs(OutputType.FILE);
            Path buttonTarget = Path.of("screenshots", "buttonLogin.png");
            Files.copy(buttonShot.toPath(), buttonTarget, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Saved : " + buttonTarget.toAbsolutePath());

        }finally {
            driver.quit();
        }
    }
}
