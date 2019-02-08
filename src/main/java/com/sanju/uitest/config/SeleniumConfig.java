package main.java.com.sanju.uitest.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SeleniumConfig {

    private WebDriver driver;

    public SeleniumConfig() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    static {
        String osName = System.getProperty("os.name");
        if(osName.toLowerCase().contains("win")) {
            System.setProperty("webdriver.gecko.driver", findFile("geckodriver.exe"));
        }else if (osName.toLowerCase().contains("mac")){
            System.setProperty("webdriver.gecko.driver", findFile("geckodriver.mac"));
        }
    }

    static private String findFile(String filename) {
        String paths[] = {"", "bin/", "target/classes"};
        for (String path : paths) {
            if (new File(path + filename).exists())
                return path + filename;
        }
        return "";
    }

    public void close() {
        driver.close();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
