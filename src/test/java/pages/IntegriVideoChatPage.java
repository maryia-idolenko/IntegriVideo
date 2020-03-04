package pages;

import org.openqa.selenium.*;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

public class IntegriVideoChatPage extends BasePage {
    private final static By CHAT_INPUT = By.cssSelector("textarea");
    private final static By BUTTON_SEND = By.cssSelector(".integri-chat-send-message");
    private final static By USER_NAME = By.name("userName");
    private final static By USER_EMAIL = By.name("userEmail");

    public IntegriVideoChatPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/demo/chat/new");
    }

    public void writeText(String text) {
        driver.findElement(CHAT_INPUT).sendKeys(text);
    }

    public void clickSend() {
        driver.findElement(BUTTON_SEND).click();
    }

    public void messageShouldExist(int messageIndex, String text) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = messages.get(messageIndex).getText().equals(text);
        assertTrue(isExist, "Message does not exist");
    }

    public void clickButtonInvite() {
        driver.findElement(By.id("invite-users-to-chat")).click();
    }

    public void getUrl() {
        String currentUrl = driver.getCurrentUrl();
        String getUrl = null;
        try {
            getUrl = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(currentUrl, getUrl, "Link incorrect");
    }

    public void clickButtonDragAndDrop() {
        driver.findElement(By.cssSelector(".integri-chat-manual-upload")).click();
    }

    public void fileUpload() {
        WebElement uploadElement = driver.findElement(By.cssSelector(".integri-file-upload-manual-init"));
        uploadElement.click();
        uploadElement.sendKeys(System.getProperty("user.dir") + "/src/main/resources/photo.jpg");
        driver.findElement(By.cssSelector(".integri-file-upload-start")).click();
    }

    public void clickEnter() {
        driver.findElement(CHAT_INPUT).sendKeys(Keys.ENTER);
    }

    public void linkShouldExist(int messageIndex, String text) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-chat-message-attachment-link"));
        boolean isExist = messages.get(messageIndex).getText().equals(text);
        assertTrue(isExist, "Link does not exist");
    }

    public void editMessage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector(".integri-chat-edit-message")).click();
    }

    public void editDeleteMessage() {
        driver.findElement(By.cssSelector("textarea")).clear();
    }

    public void errorMessage(int messageIndex, String text) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-notify-error"));
        boolean isExist = messages.get(messageIndex).getText().equals(messages);
        assertTrue(isExist, "Message cannot be empty!");
    }

    public void deleteMessage(int messageIndex, String text) {
        driver.findElement(By.cssSelector(".integri-chat-remove-message")).click();
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        assertEquals("Are you sure to delete message?", textOnAlert);
        driver.switchTo().alert().accept();
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = messages.get(messageIndex).getText().equals(messages);
        assertFalse(isExist, "removed...");
    }

    public void clickSettings() {
        driver.findElement(By.cssSelector(".integri-chat-settings")).click();
    }

    public void updateName() {
        WebElement element = driver.findElement(USER_NAME);
        element.clear();
        element.sendKeys("Name");
        String namefield = driver.findElement(USER_NAME).getAttribute("value");
        assertEquals(namefield, "Name", "Error");
    }

    public void clickSave() {
        driver.findElement(By.cssSelector(".integri-user-settings-save")).click();
    }

    public void updateEmail() {
        driver.findElement(USER_EMAIL).sendKeys("test@test.com");
        String emailfield = driver.findElement(USER_EMAIL).getAttribute("value");
        assertEquals(emailfield, "test@test.com", "Error");
    }

    public void updatePhotoUrl() {
        driver.findElement(By.name("userPic")).sendKeys("https://dev.integrivideo.com/demo/5e5fc5e84c1ed47bd9abd604");
    }
}