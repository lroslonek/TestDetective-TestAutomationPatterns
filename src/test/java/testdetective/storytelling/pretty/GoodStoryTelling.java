package testdetective.storytelling.pretty;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoodStoryTelling {

    WebDriver driver;
    UserInteractions user;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        user = new UserInteractions(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldNotLoginWithWrongPassword() {
        //Given
        user.opensFacebookLoginPage();
        //When
        user.sendsCredentials("user@email.com", "WrongPassword");
        user.submitsLogin();
        //Then
        assert (user.isLoginIncorrect());
    }

}
