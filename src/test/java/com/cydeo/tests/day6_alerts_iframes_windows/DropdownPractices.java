package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {
    public  WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown

       driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");


    }
    @Test
            public void dropdown_Task5() throws InterruptedException {


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

        //3. Select “December 1st, 1924” and verify it is selected.

        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));


        //Select year using  : visible text
        //Select month using   : value attribute
        //Select day using : index number

        yearDropdown.selectByVisibleText("1924");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);

        String expectedYear = "1924";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();


        Assert.assertTrue(actualYear.equals(expectedYear));
        Assert.assertEquals(expectedMonth,actualMonth);
        Assert.assertEquals(expectedDay,actualDay);

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
}
