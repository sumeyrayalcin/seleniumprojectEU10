package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TT_Practice {

    WebDriver driver;

    //- Locate Wire Headphones
    //If you can find the locator you can share it with us.
@BeforeMethod
public void setupMethod() throws InterruptedException{
    //1. Open browser
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



}
    @Test
    public void flipCard() throws InterruptedException{
        //Go to https://www.flipkart.com/
        driver.get("https://www.flipkart.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement xButton = driver.findElement(By.xpath("//button[@class ='_2KpZ6l _2doB4z']"));
        xButton.click();



    }
}
