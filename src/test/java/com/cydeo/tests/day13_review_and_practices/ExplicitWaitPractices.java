package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.*;
import com.cydeo.utilities.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.concurrent.*;

public class ExplicitWaitPractices {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod(){

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();

    }

    /*
    TC #2: Explicit wait practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Remove” button
4- Wait until “loading bar disappears”
5- Verify:
a. Checkbox is not displayed
b. “It’s gone!” message is displayed.

NOTE: FOLLOW POM
     */
    @Test
    public void remove_button_test(){
        //3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();

        //4- Wait until “loading bar disappears”
//        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed

        try {
            //assertFalse method will pass the test if the boolean value returned is: false
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            Assert.assertTrue(!dynamicControlsPage.checkbox.isDisplayed());
            Assert.assertFalse(dynamicControlsPage.checkbox.isDisplayed());
        }catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's gone!"));
    }

    /*
    //TC #3: Explicit wait practice
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/dynamic_controls
//3- Click to “Enable” button
//4- Wait until “loading bar disappears”
//5- Verify:
//a. Input box is enabled.
//b. “It’s enabled!” message is displayed.
//
//NOTE: FOLLOW POM
     */
    @Test
    public void enable_button_test(){
        //3- Click to “Enable” button

        //System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
        //        + dynamicControlsPage.inputBox.isEnabled());

        dynamicControlsPage.enableButton.click();

        System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
                + dynamicControlsPage.inputBox.isEnabled());

        //4- Wait until “loading bar disappears”
        //Calling our ExplicitWait utility method to wait loadingBar to disappear
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
                + dynamicControlsPage.inputBox.isEnabled());

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled());

        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());

        //Check the String value is matching as expected: “It’s enabled!”
        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's enabled!"));

    }

}


