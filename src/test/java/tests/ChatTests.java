package tests;

import org.testng.annotations.Test;

public class ChatTests extends BaseTest {

    @Test
    public void buttonInvite() {
        chatPage.openPage();
        chatPage.clickButtonInvite();
        chatPage.getUrl();
    }

    @Test
    public void filesToUpload() {
        chatPage.openPage();
        chatPage.clickButtonDragAndDrop();
        chatPage.fileUpload();
    }
}