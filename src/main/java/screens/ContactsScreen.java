package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ContactsScreen extends BaseScreen{
    public ContactsScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.sheygam.contactapp:id/emptyTxt")
    WebElement textNoContact;
    @AndroidFindBy(id = "com.sheygam.contactapp:id/add_contact_btn")
    WebElement btnAddContact;

    public boolean validateTextInTextNoContact(String text){
        return isTextInElementPresent(textNoContact, text);
    }

    public boolean isBtnAddContactPresent(){
        return btnAddContact.isDisplayed();
    }

    public void clickBtnAddContact(){
        clickWait(btnAddContact);
    }
}
