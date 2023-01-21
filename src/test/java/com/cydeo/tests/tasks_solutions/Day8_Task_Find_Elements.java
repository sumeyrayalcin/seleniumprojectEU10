package com.cydeo.tests.tasks_solutions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Day8_Task_Find_Elements {
    @Test
    public void FindElements(){

        //TC #1: Checking the number of links on the page
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        //3. Count the number of the links on the page and verify
        //Expected: 332

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.openxcell.com");
        List<WebElement> list = driver.findElements(By.tagName("a"));

        System.out.println("number of the links " + list.size());


        System.out.println("----------------------------------------------------");
        //
        //TC #2: Printing out the texts of the links on the page
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        //3. Print out all of the texts of the links on the page
        //

        int count = 0;
        for (WebElement each: list) {

            if (!(each.getText().isEmpty())) {

                System.out.println("all of the texts of the links = " + each.getText());

                //TC #3: Counting the number of links that does not have text
                //1. Open Chrome browser
                //2. Go to https://www.openxcell.com
                //3. Count the number of links that does not have text and verify
                //Expected: 109
                count++;
                // System.out.println("each.getAttribute(\"href\") = " + each.getAttribute("href"));
            }
        }

        System.out.println("count = " + count);





        //
        //NOTE: EXPECTED NUMBER OF LINKS FOR THIS PRACTICE MAY BE DIFFERENT
        //FROM COMPUTER TO COMPUTER, OR FOR DIFFERENT OS (MAC-WINDOWS). SO
        //IF YOU ARE GETTING A DIFFERENT NUMBER, JUST USE THAT NUMBER FOR
        //VERIFICATION.



    }
}
