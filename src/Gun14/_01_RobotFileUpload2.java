package Gun13;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _05_RobotFileUpload2 extends BaseDriver {
    @Test
    public void Test(){
        driver.get("https://demo.guru99.com/test/upload/");

        WebElement input= driver.findElement(By.id("uploadfile_0"));
        input.sendKeys("C:\\Users\\TechnoStudy\\IdeaProjects\\SDET4\\src\\Gun13\\ornek.txt");

        MyFunc.bekle(2);
        WebElement submit= driver.findElement(By.id("submitbutton"));
        submit.click();


        WebElement upload=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("res")));

        Assert.assertTrue(upload.getText().contains("has been successfully uploaded."));

        driverBekleKapat();




    }

}
