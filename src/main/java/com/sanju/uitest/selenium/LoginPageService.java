package main.java.com.sanju.uitest.selenium;

import main.java.com.sanju.uitest.config.SeleniumConfig;
import main.java.com.sanju.uitest.pages.LoginPageElement;
import main.java.com.sanju.uitest.util.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageService {

    private SeleniumConfig config;

    public LoginPageService() {
        config = new SeleniumConfig();
        config.getDriver().get(TestConstants.BASE_URL);
    }

    public void closeWindow() {
        this.config.getDriver().close();
    }

    public void wrongPasswordLogin(String username, String password) {
        failLogin(username, password);
    }

    public void successUserLogin(String username, String password) {
        successLogin(username, password);
    }

    private void failLogin(String username, String password) {
        loginClick(username, password);
        WebDriverWait wait = new WebDriverWait(this.config.getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div[3]/div/div/div")));
    }

    private void successLogin(String username, String password) {
        loginClick(username, password);
        WebDriverWait wait = new WebDriverWait(this.config.getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div/a")));
    }

    private void loginClick(String username, String password) {
        LoginPageElement loginPage = new LoginPageElement(config);
        WebElement webElementUserName = loginPage.getUsername();
        WebElement webElementPassword = loginPage.getPassword();
        WebElement loginButton = this.config.getDriver().findElement(By.id("loginbutton"));
        webElementUserName.sendKeys(username);
        webElementPassword.sendKeys(password);
        loginButton.click();
    }


    public String getSuccessButtonText() {
        WebElement webElement = this.config.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div/a"));
        return webElement.getText();
    }

    public String getFailureMessage() {
        WebElement element = this.config.getDriver().findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div/div/div"));
        return element.getText();
    }
}
