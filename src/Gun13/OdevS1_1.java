package Gun13;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class aa extends BaseDriver {
    @Test
    public void Test1() {

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        WebElement number1Field = driver.findElement(By.id("number1Field"));
        WebElement number2Field = driver.findElement(By.id("number2Field"));
        WebElement selectOperation = driver.findElement(By.id("selectOperationDropdown"));
        Select selectMenu = new Select(selectOperation);
        WebElement button = driver.findElement(By.id("calculateButton"));
        WebElement answer = driver.findElement(By.xpath("//label[text()='Answer']"));
        WebElement answerBox = driver.findElement(By.id("numberAnswerField"));
        WebElement clear = driver.findElement(By.id("clearButton"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", number1Field);

        for (int i = 0; i < 5; i++) {
            int result = 0;
            String strResult;
            int number1 = (int) ((Math.random() * 100) + 1);
            int number2 = (int) ((Math.random() * 100) + 1);
            String num1 = Integer.toString(number1);
            String num2 = Integer.toString(number2);

            number1Field.sendKeys(num1);
            number2Field.sendKeys(num2);
            String value = Integer.toString(i);
            selectMenu.selectByValue(value);
            button.click();

            switch (i) {
                case 0:
                    result = (number1 + number2);
                    strResult = Integer.toString(result);
                    wait.until(ExpectedConditions.visibilityOf(answer));
                    MyFunc.bekle(2);
                    Assert.assertTrue(answer.isDisplayed());
                    Assert.assertEquals(answerBox.getAttribute("value"), strResult);
                    System.out.println("answerBox = " + answerBox.getAttribute("value"));

                    break;
                case 1:
                    result = (number1 - number2);
                    strResult = Integer.toString(result);
                    wait.until(ExpectedConditions.visibilityOf(answer));
                    Assert.assertEquals(answerBox.getAttribute("value"), strResult);
                    MyFunc.bekle(2);
                    Assert.assertTrue(answer.isDisplayed());
                    System.out.println("answerBox = " + answerBox.getAttribute("value"));

                    break;
                case 2:
                    result = (number1 * number2);
                    wait.until(ExpectedConditions.visibilityOf(answer));
                    MyFunc.bekle(2);
                    strResult = Integer.toString(result);
                    Assert.assertTrue(answer.isDisplayed());
                    Assert.assertEquals(answerBox.getAttribute("value"), strResult);
                    System.out.println("answerBox = " + answerBox.getAttribute("value"));

                    break;
                case 3:
                    result = (number1 / number2);
                    wait.until(ExpectedConditions.visibilityOf(answer));
                    MyFunc.bekle(2);
                    strResult = Integer.toString(result);
                    Assert.assertTrue(answer.isDisplayed());
                    System.out.println("answerBox = " + answerBox.getAttribute("value"));

                    break;
                case 4:
                    strResult = num1 + num2;
                    wait.until(ExpectedConditions.visibilityOf(answer));
                    MyFunc.bekle(2);
                    Assert.assertTrue(answer.isDisplayed());
                    Assert.assertEquals(answerBox.getAttribute("value"), strResult);
                    System.out.println("answerBox = " + answerBox.getAttribute("value"));

                    break;

            }
            MyFunc.bekle(2);
            clear.click();
            number1Field.clear();
            number2Field.clear();

        }
        driverBekleKapat();


    }

}

