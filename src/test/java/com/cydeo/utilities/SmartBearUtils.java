package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {
    public static void loginToSmartBear(WebDriver driver, String userName, String password){

        //3. Enter valid username
        WebElement inputUserName = driver.findElement(By.id("ctl00_MainContent_username"));
        inputUserName.sendKeys(userName);

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
        inputPassword.sendKeys(password);

        //5. Click to`LogIn`button
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();



    }
}
