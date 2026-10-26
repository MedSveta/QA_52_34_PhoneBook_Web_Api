package mobile;

import dto.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ContactsScreen;
import screens.RegistrationLoginScreen;
import screens.SplashScreen;

import static utils.PropertiesReader.getProperty;

public class AddNewContactTests extends TestBase {
    ContactsScreen contactsScreen;

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
    }

    @Test
    public void addNewContactPositiveTest(){

    }
}
