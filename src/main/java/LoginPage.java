package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(id = "email")
    private WebElement loginame;

    @FindBy(id = "pass")
    private WebElement passwdInput;

    @FindBy(css = "label#loginbutton.uiButton.uiButtonConfirm")
    private WebElement loginButton;

    @FindBy(css ="div._mp3._mp3._38vo")
    private WebElement goToHomePage;

    @FindBy(name = "xhpc_message_text")
    private WebElement typingText;

    @FindBy(css = "div._2dck._4-u3._4-u8   button._1mf7._4jy0._4jy3._4jy1._51sy.selected._42ft")
    private WebElement postButton;

    @FindBy(css = "div._1mwp.navigationFocus._395._1mwq._4c_p._5bu_._34nd._21mu._5yk1")
    public WebElement postText;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String name, String passwd, String postmessage) throws InterruptedException {
        loginame.sendKeys(name);
        passwdInput.sendKeys(passwd);
        loginButton.click();
        goToHomePage.click();
        typingText.sendKeys(postmessage);
        postButton.click();
    }
}