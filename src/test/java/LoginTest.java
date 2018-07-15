package test.java;

import java.util.concurrent.TimeUnit;
import main.java.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private String baseUrl;
//    Before starting the test, enter the correct values for your email and password!!.
    private static final String name = "Enter You Email";
    private static final String passwd = "Enter Your Pass";
    private static final String postmessage = "Hello World!";
//
    @BeforeClass
    public void setUp() throws Exception {
//    Before starting the test, copy chromedriver from http://www.seleniumhq.org/download/ and enter correct PATH.!!
        System.setProperty("webdriver.chrome.driver", "D:\\downloads\\avtotests\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.facebook.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() throws Exception {

        driver.get(baseUrl);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(name, passwd, postmessage);
        Assert.assertEquals(postmessage, loginPage.postText.getText());
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}