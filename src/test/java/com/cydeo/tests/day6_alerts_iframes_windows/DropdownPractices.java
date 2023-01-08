package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {
    @Test
            public void dropdown_Task5() throws InterruptedException {

        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

        //we located the dropdown and it is ready to use
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
       // Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");


        //4. Select Virginia
       // Thread.sleep(1000);
        stateDropdown.selectByValue("VA");


        //5. Select California
       // Thread.sleep(1000);
        stateDropdown.selectByIndex(5);


        //6. Verify final selected option is California.
        //Use all Select options. (visible text, value, index)
        String expectedOptionText = "California";
        String actualOptionTex = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedOptionText,actualOptionTex);


    }
    @Test
    public void dropdown_task6(){
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        //3. Select “December 1st, 1923” and verify it is selected.
        //Select year using  : visible text
        //Select month using   : value attribute
        //Select day using : index number



    }
}
