package com.cydeo.tests.tasks_solutions;

import com.cydeo.utilities.SmartBearUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day8_Task1SmartBear {
    // #1: Smartbear software link verification

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void smartBearLinkVerification() {

        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
      driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    //3. Enter username: “Tester”
    //4. Enter password: “test”
    //5. Click to Login button
        SmartBearUtils.loginToSmartBear(driver,"Tester","test");

    //6. Print out count of all the links on landing page
        //(Locate all the links in the page.)
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));


    //7. Print out each link text on this page
        for (WebElement each : allLinks) {
            System.out.println("Text of each link: "+each.getText());

        }
    }

    @Test
    public void SmartbearOrderPlacing() throws InterruptedException{
        //TC#2: Smartbear software order placing
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click on Login button
        SmartBearUtils.loginToSmartBear(driver,"Tester","test");


        //6. Click on Order
        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();


        //7. Select familyAlbum from product, set quantity to 2
        WebElement familyAlbum = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']/option[2]"));
        familyAlbum.click();

        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("2");


        //8. Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        Faker faker = new Faker();
        WebElement inputName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        inputName.sendKeys(faker.name().fullName());

        WebElement inputStreet = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        inputStreet.sendKeys(faker.address().streetName());

        WebElement inputCity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        inputCity.sendKeys(faker.address().city());

        WebElement inputState = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        inputState.sendKeys(faker.address().state());

        WebElement inputZipcode= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        inputZipcode.sendKeys(faker.address().zipCode());



        //10. Click on “visa” radio button
        //11. Generate card number using JavaFaker
        //12. Click on “Process”
        //13. Verify success message “New order has been successfully added.”

    }
}
    //Mini-Task: CREATE A CLASS à SmartBearUtils
    //• Create a method called loginToSmartBear
    //• This method simply logs in to SmartBear when you call it.
    //• Accepts WebDriver type as parameter
    //


