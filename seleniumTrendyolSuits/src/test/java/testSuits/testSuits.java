package testSuits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.customerPage;

public class testSuits {
    public WebDriver driver;

public static String url= "https://www.trendyol.com/";
    public static String email = "rockringo01@hotmail.com";
    public static String password = "123456789a";

@BeforeMethod
public void beforeSuit() {
    this.driver = new ChromeDriver();
    this.driver.manage().window().maximize();

}
@Test
    public void tddTest() throws InterruptedException {
    customerPage customerPage = new customerPage(driver);
customerPage
        .openPage(url)
    .login("Female" , email,password)
        .search("samsung")
        .productPageRating()
        .productLike("2")
        .favouriteClick()
        ;
}
@Test
    public void ttdTest2() throws InterruptedException {

        customerPage customerPage = new customerPage(driver);
    customerPage
            .openPage(url)
            .login("Female" , email,password)
            .search("samsung")
            .productPageRating()
            .productLike2("10")
            .favouriteClick2("10")
    ;
}
@Test
    public void ttdTest3() throws InterruptedException {
    customerPage customerPage = new customerPage(driver);
    customerPage
            .openPage(url)
            .login("Female",email,password)
            .myAccountClick()
            .addAddressClick()
            .addAddressInfo("Tuna Kaan","Esenkurt","0507 636 84 88","Ev")
            ;


}
}
