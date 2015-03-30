package testdetective.storytelling.pretty;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserInteractions {

    private static By emailBoxSelector = By.id("email");
    private static By passwordBoxSelector = By.id("pass");
    private static By submitBtnSelector = By.id("loginbutton");

    WebDriver driver;

    public UserInteractions(WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void opensFacebookLoginPage() {
        driver.get("http://facebook.com");
    }

    public void sendsCredentials(String email, String password) {
        WebElement emailBox = driver.findElement(emailBoxSelector);
        emailBox.sendKeys(email);
        WebElement passwordBox = driver.findElement(passwordBoxSelector);
        passwordBox.sendKeys(password);
    }

    public void submitsLogin() {
        WebElement submitBtn = driver.findElement(submitBtnSelector);
        submitBtn.click();
    }

    public boolean isLoginIncorrect () {
        return driver.getPageSource()
                .contains("The password you entered is incorrect");
    }
}
