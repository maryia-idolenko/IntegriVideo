package tests;

import org.testng.annotations.Test;

public class UpdateProfile extends BaseTest {

    @Test
    public void updateName() {
        chatPage.openPage();
        chatPage.clickSettings();
        chatPage.updateName();
        chatPage.clickSave();
    }

    @Test
    public void updateEmail() {
        chatPage.openPage();
        chatPage.clickSettings();
        chatPage.updateEmail();
        chatPage.clickSave();
    }

    @Test
    public void updatePhotoUrl() {
        chatPage.openPage();
        chatPage.clickSettings();
        chatPage.updatePhotoUrl();
        chatPage.clickSave();
    }

}