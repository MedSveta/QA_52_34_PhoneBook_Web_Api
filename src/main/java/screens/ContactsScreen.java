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
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Contact was added!']")
    WebElement messageContactWasAdded;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Contact was updated!']")
    WebElement messageContactWasUpdated;

    public boolean validateTextInTextNoContact(String text){
        return isTextInElementPresent(textNoContact, text);
    }

    public boolean isBtnAddContactPresent(){
        return btnAddContact.isDisplayed();
    }

    public void clickBtnAddContact(){
        clickWait(btnAddContact);
    }

    public boolean validateMessageContactWasAdded(String text){
        return isTextInElementPresent(messageContactWasAdded, text);
    }
    public boolean validateMessageContactWasUpdate(String text){
        return isTextInElementPresent(messageContactWasUpdated, text);
    }

    public void goToUpdateScreen(){
        swipe(width/10*9, height/6,
                width/10, height/6);
    }
}
