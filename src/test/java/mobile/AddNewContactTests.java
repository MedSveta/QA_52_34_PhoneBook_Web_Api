package mobile;

import dto.ContactDto;
import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AddContactScreen;
import screens.ContactsScreen;
import screens.RegistrationLoginScreen;
import screens.SplashScreen;
import utils.ContactFactory;
import utils.UserFactory;

import static utils.PropertiesReader.getProperty;


public class AddNewContactTests extends TestBase {
    ContactsScreen contactsScreen;
    AddContactScreen addContactScreen;
    ContactDto contact;

    @BeforeMethod
    public void goToRegistrationScreen() {
        new SplashScreen(driver).goToRegistrationScreen();
        RegistrationLoginScreen registrationLoginScreen =
                new RegistrationLoginScreen(driver);
        User user = User.builder()
                .username(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        registrationLoginScreen.typeFormLoginRegistration(user);
        registrationLoginScreen.clickBtnLogin();
        contactsScreen = new ContactsScreen(driver);
        contactsScreen.clickBtnAddContact();
        addContactScreen = new AddContactScreen(driver);
        //contact = positiveContact();
        contact = ContactFactory.positiveContact();

    }

    @Test
    public void addNewContactPositiveTest() {
        addContactScreen.typeAddNewContactForm(contact);
        addContactScreen.clickBtnCreate();
        Assert.assertTrue(contactsScreen
                .validateMessageContactWasAdded("Contact was added!"));
    }

}
