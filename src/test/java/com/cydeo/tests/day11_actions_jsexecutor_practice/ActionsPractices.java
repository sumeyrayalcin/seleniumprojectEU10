package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test
    public void task_4_and_5_test(){
        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        Actions actions = new Actions(Driver.getDriver());


        //Locating cydeo link to be able to pass in the actions method
        //a[@href='https://cydeo.com/']
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));


        //4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(cydeoLink).perform();  //go to specific element and prefer this

        //5- Scroll back up to “Home” link using PageUP button
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform(); // yapabilirsin ama optional yukaridaki tavsiye edilir


        //Driver.getDriver().quit();  //copmlitly shut electrcty up
        Driver.closeDriver();
    }

    @Test
    public void test2(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        Driver.closeDriver();
    }

    @Test
    public void test3(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        Driver.closeDriver();
    }

    @Test
    public void test4(){
        Driver.getDriver().get("https://practice.cydeo.com/");
        Driver.closeDriver();
    }

    //
    //TC #5: Scroll practice 2
    //1- Continue from where the Task 4 is left in the same test.
    //2- Scroll back up to “Home” link using PageUP button
}
