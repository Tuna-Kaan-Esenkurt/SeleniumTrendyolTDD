//global kodlar bu sayfada tutulur
package page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testSuits.testSuits;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

public class pageBase extends testSuits {
    protected WebDriver webDriver;
    public int randomCounter=0;
    public int sayi = 0;


    public pageBase click(By click) {
        driver.findElement(click).click();
        return this;
    }
    public WebDriver getWebDriver() {
        return webDriver;
    }
    public void clickJS(WebElement element) throws InterruptedException {

        JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
        executor.executeScript("arguments[0].click();", element);
    }



    public pageBase sendKey(By send, String value) {
        driver.findElement(send).sendKeys(value);
        return this;

    }

    public pageBase logInfo(String value) {
        System.out.println(value);
        return this;
    }

    public pageBase selectProduct (String value , By value2) throws InterruptedException {

        sleep(3000);

        List<WebElement> elementList=driver.findElements(value2);
        int sayac = Integer.parseInt(value);
                for (int i=0; i<elementList.size(); i++) {
                    logInfoInt(i);
                    if (sayac == i) {
                        logInfoInt(sayac);
                        elementList.get(sayac).click();
                        break;
                    }
                }
        return this;
    }

    public pageBase selectProductTest2 (String value , By value2) throws InterruptedException {
        sleep(3000);

        List<WebElement> elementList=driver.findElements(value2);
        int sayac = Integer.parseInt(value);
        for (int i=0; i<sayac; i++) {

            elementList.get(i).click();
        }
        return this;
    }

    public pageBase addAddress (By value , String name, String surname,String location) {
    List<WebElement> elementList=driver.findElements(value);

    elementList.get(0).sendKeys(name);
    elementList.get(1).sendKeys(surname);
    elementList.get(3).sendKeys(location);

        return this;
    }
    public pageBase addNumber (By value , String number) {
        List<WebElement> elementList=driver.findElements(value);

        elementList.get(2).sendKeys(number);
        return this;
    }

    public pageBase selectBoxRandom (By value) throws InterruptedException {

        List<WebElement> elementList = driver.findElements(value);

        if (randomCounter == 0) {
            int randomSayi = ThreadLocalRandom.current().nextInt(3, 5);
            logInfoInt(randomSayi);
            elementList.get(randomSayi).click();
            randomCounter++;



        } else if (randomCounter == 1) {
            int randomSayi = ThreadLocalRandom.current().nextInt(82, 86);
            logInfoInt(randomSayi);
            elementList.get(randomSayi).click();
            sayi = elementList.size();
            logInfoInt(sayi);
            randomCounter++;

        } else if (randomCounter == 2) {
            int randomSayi = ThreadLocalRandom.current().nextInt(sayi, sayi+4);
            logInfoInt(randomSayi);
            elementList.get(randomSayi).click();
            randomCounter++;
            logInfoInt(randomCounter);

        }
        return this;
    }
     public pageBase addressLineFnc (By value,By value2) {
         List<WebElement> elementList=driver.findElements(value2);
         String address= elementList.get(0).getText()+" ";
         address+= elementList.get(1).getText()+" ";
         address+= elementList.get(2).getText();
         sendKey(value,address);

         return this;
     }

    public pageBase logInfoInt (Integer value) {
        System.out.println(value);

        return this;
    }

    public pageBase logInfoStr (Integer value) {
        System.out.println(value);

        return this;
    }
}

