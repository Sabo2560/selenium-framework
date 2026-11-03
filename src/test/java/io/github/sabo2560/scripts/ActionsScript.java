package io.github.sabo2560.scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScript {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

        try {
            driver.get("https://the-internet.herokuapp.com/hovers");
            WebElement figure = driver.findElement(By.cssSelector(".figure"));
            WebElement caption =  figure.findElement(By.cssSelector((".figcaption h5")));
            System.out.println("Caption visible before hover: " + caption.isDisplayed());
            actions.moveToElement(figure).perform();
            System.out.println("Caption visible after hover: " + caption.isDisplayed());
            System.out.println("Caption text: " + caption.getText());

            driver.get("https://the-internet.herokuapp.com/context_menu");
            WebElement box = driver.findElement(By.id("hot-spot"));
            actions.contextClick(box).perform();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();

            driver.get("https://the-internet.herokuapp.com/drag_and_drop");
            WebElement boxA = driver.findElement(By.id("column-a"));
            WebElement boxB = driver.findElement(By.id("column-b"));
            System.out.println("Before: " + driver.findElement(By.cssSelector("#column-a header")).getText());
            System.out.println("Before: " + driver.findElement(By.cssSelector("#column-b header")).getText());

            actions.dragAndDrop(boxA, boxB).perform();
            System.out.println("After: " + driver.findElement(By.cssSelector("#column-a header")).getText());
            System.out.println("After: " + driver.findElement(By.cssSelector("#column-b header")).getText());

        } finally {
            driver.quit();
        }
    }
}
