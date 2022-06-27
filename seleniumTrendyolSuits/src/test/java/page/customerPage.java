//kullanıcının yaptığı işlemler burada tutulur
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static java.lang.Thread.sleep;

public class customerPage extends pageBase {

    public static By search = By.cssSelector("[class='search-box']");
    public static By control = By.cssSelector("[class='component-item']");
    public static By searchIcon = By.cssSelector("[class='search-icon']");
    public static By valueSuggested = By.cssSelector("[value='PRICE_BY_DESC']");
    public static By productListLike = By.cssSelector("[class='fvrt-btn']");
    public static By myFavourite = By.cssSelector("[class='account-nav-item account-favorites']");
    public static By dissLike = By.cssSelector("[class='ufvrt-btn-wrppr']");
    public static By myAccount = By.cssSelector("[class='account-nav-item user-login-container']");
    public static By myAddress = By.cssSelector("[class='i-location-pin']");
    public static By addAddress= By.cssSelector("[class='addresses-page-header-add-address']");
    public static By lblText = By.cssSelector("[class='ty-bg-beige ty-input ty-textbox ty-bordered ty-input-medium']");
    public static By comboBox = By.xpath("//div[@name='cityId']");
    public static By selectCity = By.xpath("//div[@class='ty-select-option']");
    public static By comboDistrict = By.xpath("//div[@name='districtId']");
    public static By selectDistrict = By.xpath("//div[@class='ty-select-option']");
    public static By comboNeighbor=By.xpath("//div[@name='neighborhoodId']");
    public static By selectNeighbor = By.xpath("//div[@class='ty-select-option']");
    public static By addressLine = By.xpath("//textarea[@name='addressLine']");
    public static By addLine = By.xpath("//span[@class='ty-text ty-color-dark-gray ty-font-sm']");
    public static By addressButton = By.xpath("//button[@class='ty-font-w-semi-bold ty-button ty-bordered" +
            " ty-transition ty-input-medium ty-primary']");





    public WebDriverWait wait; //bir elementi görene kadar bekle

    public customerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,20);
    }

    public customerPage openPage(String value) {
        driver.get(value);
        return this;

    }

    public customerPage login(String value , String value2 , String value3) throws InterruptedException {
        click(By.cssSelector("[alt='"+ value +"']"));
        click(loginPage.grsBtn);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.email));
        sendKey(loginPage.email,value2);
        sendKey(loginPage.password,value3);
        sleep(2000);
        click(loginPage.loginBtn);
        return this;
    }
    public customerPage search(String value) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(control));

        sendKey(search,value);
        sleep(3000);
        click(searchIcon);

        return this;

    }

    public customerPage productPageRating () {

        click(valueSuggested);


        return this;
    }

    public customerPage productLike(String value) throws InterruptedException {
        selectProduct(value,productListLike);
        return this;
    }

    public customerPage productLike2(String value) throws InterruptedException {
        selectProductTest2(value,productListLike);
        return this;
    }

    public customerPage favouriteClick() {
        click(myFavourite);

        wait.until(ExpectedConditions.elementToBeClickable(dissLike));
        click(dissLike);
        return this;
    }
    public customerPage favouriteClick2(String value) throws InterruptedException {
        click(myFavourite);

        wait.until(ExpectedConditions.elementToBeClickable(dissLike));
        selectProductTest2(value,dissLike);
        return this;

    }
    public customerPage myAccountClick() throws InterruptedException {
         sleep(2000);
        click(myAccount);
        return this;
    }
    public customerPage addAddressClick() throws InterruptedException {

        click(myAddress);
        sleep(2000);
        click(addAddress);
        return this;
    }

    public customerPage addAddressInfo(String value ,String value2,String value3,String value4) throws InterruptedException {
      addAddress(lblText,value,value2,value4);
      addNumber(lblText,value3);
      click(comboBox);
      selectBoxRandom(selectCity);
      sleep(2000);
      click(comboDistrict);
      selectBoxRandom(selectDistrict);
      sleep(2000);
      click(comboNeighbor);
      selectBoxRandom(selectNeighbor);
      addressLineFnc(addressLine,addLine);
      click(addressButton);
        return this;
    }
}
