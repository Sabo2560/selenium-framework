package io.github.sabo2560.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownScript {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try{

            driver.get("https://the-internet.herokuapp.com/dropdown");
            WebElement dropdownElement = driver.findElement(By.id("dropdown"));
            Select dropdown = new Select(dropdownElement);

            List<WebElement> dropdownOptions = dropdown.getOptions();
            for (WebElement option : dropdownOptions) {
                System.out.println(option.getText());
            }

            dropdown.selectByVisibleText("Option 1");
            System.out.println(dropdown.getFirstSelectedOption().getText());

            dropdown.selectByValue("2");
            System.out.println(dropdown.getFirstSelectedOption().getText());

            dropdown.selectByIndex(1);
            System.out.println(dropdown.getFirstSelectedOption().getText());

        }finally {
            driver.quit();
        }


    }
}
