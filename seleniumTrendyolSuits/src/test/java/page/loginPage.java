//login sayfasının bilgileri burada tutulur
package page;
import page.pageBase;
import org.openqa.selenium.By;

public class loginPage {
public static By grsBtn = By.cssSelector("[class='link account-user']");
public static By email = By.id("login-email");
public static By password = By.id("login-password-input");
public static By loginBtn = By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']");


}
