package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {


    private WebDriver driver;

    private By joinButton = By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/a[2]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage clickJoinButton() {
        driver.findElement(joinButton).click();
        return new SignUpPage(driver);
    }
}

