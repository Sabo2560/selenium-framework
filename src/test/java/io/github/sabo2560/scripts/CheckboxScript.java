package io.github.sabo2560.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckboxScript {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/checkboxes");
            List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkboxes input"));

            for (WebElement checkbox : checkboxes) {
                System.out.println("Before: " + checkbox.isSelected());
            }

            for (WebElement checkbox : checkboxes) {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
                System.out.println("After: " + checkbox.isSelected());
            }

            System.out.println("Displayed: " + checkboxes.getFirst().isDisplayed());
            System.out.println("Enabled: " + checkboxes.getFirst().isEnabled());

        }finally {
            driver.quit();
        }
    }
}
