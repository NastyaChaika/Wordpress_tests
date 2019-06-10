package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Elements of the Login page
    By txtLogin = By.id("user_login");
    By txtPassword = By.id("user_pass");
    By chkbxRememberMe = By.id("rememberme");
    By btnLogin = By.id("wp-submit");

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    // Login to Wordpress website with clicking "Remember me" checkbox
    public LoginPage loginWithRemember(String login, String password) {
        inputText(txtLogin, login);
        inputText(txtPassword, password);
        click(chkbxRememberMe);
        click(btnLogin);
        return this;
    }

    // Login to Wordpress website without clicking "Remember me" checkbox
    public LoginPage loginWithoutRemember(String login, String password) {
        inputText(txtLogin, login);
        inputText(txtPassword, password);
        click(btnLogin);
        return this;
    }
}