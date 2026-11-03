package io.github.sabo2560.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameScript {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/nested_frames");
            driver.switchTo().frame("frame-top");
            driver.switchTo().frame("frame-middle");
            System.out.println("Middle: " + driver.findElement(By.id("content")).getText());

            driver.switchTo().parentFrame();
            driver.switchTo().frame("frame-left");
            System.out.println("Left : " + driver.findElement(By.tagName("body")).getText());

            driver.switchTo().defaultContent();
            driver.switchTo().frame("frame-bottom");
            System.out.println("Bottom : " + driver.findElement(By.tagName("body")).getText());

            driver.switchTo().defaultContent();
            try{
                driver.findElement(By.id("content"));
                System.out.println("Unexpected: found content outside the frame");
            }catch (NoSuchElementException e){
                System.out.println("Not found outside the frame, as expected");
            }

        }finally {
            driver.quit();
        }
    }
}
