package com.cydeo.tests.tasks_solutions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day8_Task_Gas_Mileage {

    @Test
    public void GasMileageCalculatorTest(){
//1. Add a new class GasMileageCalculatorTest
//2. Go to https://www.calculator.net
        Driver.getDriver().get("https://www.calculator.net");
//3. Search for “gas mileage” using search box

        WebElement searchGasMileage = Driver.getDriver().findElement(By.xpath("//input[@id='calcSearchTerm']"));
        searchGasMileage.sendKeys("gas mileage");
        BrowserUtils.sleep(2);



//4. Click on the “Gas Mileage Calculator” link
        WebElement clickGasMileageCalculator =Driver.getDriver().findElement(By.xpath("//tbody//a[.='Gas Mileage Calculator']"));
        clickGasMileageCalculator.click();

        //5. On Next page verify:
//a. Title equals: “Gas Mileage Calculator”
//b. “Gas Mileage Calculator” label is displayed

        String expectedTitle = "Gas Mileage Calculator";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

//6. Locate, clear and type “7925” into “Current odometer” field
        WebElement odometerButton = Driver.getDriver().findElement(By.xpath("//input[@id='mucodreading']"));
        odometerButton.clear();
        odometerButton.sendKeys("7925");


//7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement PreviousodometerButton = Driver.getDriver().findElement(By.xpath("//input[@id='mupodreading']"));
        PreviousodometerButton.clear();
        PreviousodometerButton.sendKeys("7550");

//8. Locate, clear and type “16” into “Gas added” field
        WebElement GasAddedButton = Driver.getDriver().findElement(By.xpath("//input[@id='mugasputin']"));
        GasAddedButton.clear();
        GasAddedButton.sendKeys("16");

//9. Locate, clear and type “3.55” into “Gas price” field
        WebElement GaspriceButton = Driver.getDriver().findElement(By.xpath("//input[@id='mugasprice']"));
        GaspriceButton.clear();
        GaspriceButton.sendKeys("3.55");

//10. Click on Calculate button
        WebElement CalculateButton = Driver.getDriver().findElement(By.xpath("(//input[@value='Calculate'])[2]"));
        CalculateButton.click();


//11. Verify mpg value is as expected:
//Expected value: “23.44 mpg”

        String expectedValue =Driver.getDriver().findElement(By.xpath("//b[.='23.44 km/L  or 4.27  L/100 km ']")).getText();
        Assert.assertTrue(expectedValue.contains("23.44"));



    }
}
//Task #: Gas Mileage Calculator Automation Test

//1. Add a new class GasMileageCalculatorTest
//2. Go to https://www.calculator.net
//3. Search for “gas mileage” using search box
//4. Click on the “Gas Mileage Calculator” link

//5. On Next page verify:
//a. Title equals: “Gas Mileage Calculator”
//b. “Gas Mileage Calculator” label is displayed

//6. Locate, clear and type “7925” into “Current odometer” field
//7. Locate, clear and type “7550” into “Previous odometer” field
//8. Locate, clear and type “16” into “Gas added” field
//9. Locate, clear and type “3.55” into “Gas price” field
//10. Click on Calculate button
//11. Verify mpg value is as expected:
//Expected value: “23.44 mpg”
