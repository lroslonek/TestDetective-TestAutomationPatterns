package testdetective.storytelling.ugly;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class UglyStoryTelling {

    WebDriver driver = new FirefoxDriver();

    @Test
    public void facebookLoginFail() {
        driver.get("http://facebook.com");
        WebElement element1 = driver.findElement(By.id("email"));
        element1.sendKeys("user@email.com");
        WebElement element2 = driver.findElement(By.id("pass"));
        element2.sendKeys("WrongPassword");
        WebElement element3 = driver.findElement(By.id("loginbutton"));
        element3.click();
        assert (driver.getPageSource()
                .contains("The password you entered is incorrect"));
    }

}
