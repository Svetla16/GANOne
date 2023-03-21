package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class SignUpPage {

    private WebDriver driver;

    private By firstNameField = By.id("forename");
    private By surnameField = By.xpath("//*[@id=\"signupForm\"]/fieldset[1]/input[2]");
    private By dropdown = By.id("title");
    private By joinRegistrationButton = By.id("form");


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage clickDropDownTitle() {
        driver.findElement(dropdown).click();
        return new SignUpPage(driver);
    }

    public void selectFromDropDown(String option) {
        findDropDownElement().selectByVisibleText(option);
    }


    private Select findDropDownElement() {
        return new Select(driver.findElement(dropdown));
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).clear();
        driver.findElement(surnameField).sendKeys(surname);
    }

    public RegistrationPage clickJoinRegistrationButton() {
        driver.findElement(joinRegistrationButton).click();
        return new RegistrationPage(driver);
    }


}

