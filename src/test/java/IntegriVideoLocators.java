import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IntegriVideoLocators {

    @Test
    public void IntegriVideoLocators() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://dev.integrivideo.com/demo/5e5bddd57523434d87e479b3");
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        browser.findElement(By.className("integri-chat-input"));
        browser.findElement(By.className("integri-chat-send-message"));
        browser.findElement(By.className("integri-chat-start-video"));
        browser.findElement(By.className("integri-chat-settings"));
        browser.findElement(By.className("integri-chat-manual-upload"));
        browser.findElement(By.className("integri-chat-message-container"));
        browser.findElement(By.className("integri-chat-message-date"));
        browser.quit();
    }
}