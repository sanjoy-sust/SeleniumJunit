package main.java.com.sanju.uitest.pages;

import main.java.com.sanju.uitest.config.SeleniumConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElement {

    private SeleniumConfig config;
    @FindBy(id = "email")
    private WebElement username;
    @FindBy(id = "pass")
    private WebElement password;


    public LoginPageElement(SeleniumConfig config) {
        this.config = config;
        PageFactory.initElements(this.config.getDriver(), this);
    }

    public WebElement getUsername() {
        return username;
    }

    public void setUsername(WebElement username) {
        this.username = username;
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }
}
