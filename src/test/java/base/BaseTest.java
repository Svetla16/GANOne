package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;


public class BaseTest {

    public WebDriver driver;
    protected HomePage homePage;


    @BeforeClass
    public void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().fullscreen();
        //this.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        this.driver.get("https://moneygaming.qa.gameaccount.com/");
        Assert.assertEquals(driver.getTitle(), "Play Online Casino Games Now | MoneyGaming.com", "Title not found.");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDownTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void tearDownClass() {
        //Clean any generated test data
    }


}




