package main.java.com.sanju.uitest.models;

import main.java.com.sanju.uitest.config.SeleniumConfig;
import org.openqa.selenium.support.PageFactory;

public class LoginModel {
    private SeleniumConfig config;

    public LoginModel(SeleniumConfig config) {
        this.config = config;
        PageFactory.initElements(config.getDriver(), LoginModel.class);
    }

    public void navigateTo() {
        config.navigateTo("https://www.facebook.com/");
    }
}
