package tests;

import org.testng.annotations.Test;

public class SendMessages extends BaseTest {

    @Test
    public void sendMessage() {
        chatPage.openPage();
        chatPage.writeText("Text");
        chatPage.clickSend();
        chatPage.messageShouldExist(0, "Text");
    }

    @Test
    public void sendMessageByEnter() {
        chatPage.openPage();
        chatPage.writeText("Text");
        chatPage.clickEnter();
        chatPage.messageShouldExist(0, "Text");
    }

    @Test
    public void sendLink() {
        chatPage.openPage();
        chatPage.writeText("https://www.tut.by/");
        chatPage.clickEnter();
        chatPage.linkShouldExist(0, "undefined");
    }

    @Test
    public void sendHtmlCode() {
        chatPage.openPage();
        chatPage.writeText("<html><body><p>Text</p></body></html>");
        chatPage.clickSend();
        chatPage.messageShouldExist(0, "Text");
    }

    @Test
    public void editMessage() {
        chatPage.openPage();
        chatPage.writeText("Text");
        chatPage.clickSend();
        chatPage.editMessage();
        chatPage.writeText("Message");
        chatPage.clickEnter();
        chatPage.messageShouldExist(0, "Message Text");
    }

    @Test
    public void editMessageDelete() {
        chatPage.openPage();
        chatPage.writeText("Text");
        chatPage.clickSend();
        chatPage.editMessage();
        chatPage.editDeleteMessage();
        chatPage.clickEnter();
        chatPage.errorMessage(0, "Message cannot be empty!");
    }

    @Test
    public void deleteMessage() {
        chatPage.openPage();
        chatPage.writeText("Text");
        chatPage.clickSend();
        chatPage.deleteMessage(0, "removed...");
    }
}