package pageObject;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class RegistrationPageBurger {
    private WebDriver driver;
    private static Faker faker = new Faker(new Locale("en"));

    private By register = By.className("Auth_link__1fOlj");

    private By name = By.xpath(".//form[@class='Auth_form__3qKeq mb-20']/fieldset[1]//input");
    private By email = By.xpath(".//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]//input");
    private By password = By.xpath(".//form[@class='Auth_form__3qKeq mb-20']/fieldset[3]//input");
    private By registration = By.xpath(".//form[@class='Auth_form__3qKeq mb-20']/button");

    private By successfully = By.className("Auth_login__3hAey");
    private By error = By.cssSelector(".input__error.text_type_main-default");

    public RegistrationPageBurger(WebDriver driver) {
        this.driver = driver;
    }

    public void sendInfoForSuccessfulRegistration() {
        driver.findElement(register).click();
        driver.findElement(name).sendKeys(faker.name().fullName());
        driver.findElement(email).sendKeys(faker.name().firstName() + "@mail.ru");
        driver.findElement(password).sendKeys(faker.numerify("#######"));
        driver.findElement(registration).click();
    }

    public String sendTextInfoSuccessfullyRegistration() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(successfully)).getText();
    }

    public void sendInfoForErrorRegistration() {
        driver.findElement(register).click();
        driver.findElement(name).sendKeys(faker.name().fullName());
        driver.findElement(email).sendKeys(faker.name().firstName() + "@mail.ru");
        driver.findElement(password).sendKeys(faker.numerify("#####"));
        driver.findElement(registration).click();
    }

    public String sendTextInfoErrorRegistration() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(error)).getText();
    }
}
