package mobile;

import org.testng.annotations.Test;
import screens.RegistrationLoginScreen;
import screens.SplashScreen;

public class RegistrationTests extends TestBase{

    @Test
    public void registrationPositiveTest(){
        new SplashScreen(driver).goToRegistrationScreen();
        RegistrationLoginScreen registrationLoginScreen =
                new RegistrationLoginScreen(driver);
    }
}
