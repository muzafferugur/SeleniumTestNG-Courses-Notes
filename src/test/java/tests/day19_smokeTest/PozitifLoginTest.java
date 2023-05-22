package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {

    BrcPage brcPage = new BrcPage();

    /*
    1.https://www.bluerentalcars.com/ adresine git
    2.Login butonuna bas
    3.user email : customer@bluerentalcars.com
        password : 12345
        login butonuna tıklayın
       değerleri girildiğinde sayfaya başarılı bir şekilde giriş yap
     */
    @Test
    public void positiveLoginTest() {

        Driver.getDriver().get(ConfigReader.getProperties("brcUrl"));

        brcPage.ilkLoginButonu.click();

        brcPage.emailTextBox.sendKeys(ConfigReader.getProperties("brcValidEmail"));

        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperties("brcValidPassword"));

        brcPage.ikinciLoginButonu.click();

        String actualUsername=brcPage.kullaniciProfilIsmi.getText();
        String expectedUsername=ConfigReader.getProperties("brcValidUsername");
        Assert.assertEquals(actualUsername, expectedUsername);

        Driver.closeDriver();

    }
}
