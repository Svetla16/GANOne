package signup;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class FirstTaskTest extends BaseTest {


    @Test
    public void testFirstTask() {

        //Open registration page and fill title, name and surname
        this.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        SignUpPage signUpPage = homePage.clickJoinButton();
        signUpPage.clickDropDownTitle();
        signUpPage.selectFromDropDown("Ms");
        signUpPage.setFirstName("Svetla");
        signUpPage.setSurname("Dimitrova");

        //Tick the checkbox for Terms and Conditions
        WebElement checkBox = driver.findElement(By.xpath("/html/body/div[2]/div[3]/form/fieldset[5]/input[3]"));
        if (!checkBox.isSelected())
            checkBox.click();
        Assert.assertTrue(checkBox.isSelected());

        //Submit the form by clicking the "JOIN NOW!" button
        RegistrationPage registrationPage = signUpPage.clickJoinRegistrationButton();

        //Validate message:"This field is required" under the date of birth box
        WebElement message = driver.findElement(By.xpath("/html/body/div[2]/div[3]/form/fieldset[1]/label[5]"));
        Assert.assertEquals(message.getText(), "This field is required", "Message not found.");


    }
}
