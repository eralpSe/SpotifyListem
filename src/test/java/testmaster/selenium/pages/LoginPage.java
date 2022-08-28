package testmaster.selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

public class LoginPage extends Methods {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    public static final By id = By.id("login-username");
    public static final By password = By.id("login-password");
    public static final By oturumAc = By.xpath("//p[text()='Oturum Aç']");

    public static final By loginSyfKntrl = By.xpath("//label[text()='E-posta adresi veya kullanıcı adı']");


    public void isInLgnPage(){
        findElementWait(loginSyfKntrl);
        Assertions.assertEquals("E-posta adresi veya kullanıcı adı",getText(loginSyfKntrl),"Login Sayfası açılmadı.");
        logger.info("E-posta yazısının görüldüğü doğrulandı.");
    }

    public void enterIdPass(String userId,String pass){
    clickElement(id);
    sendKeys(id,userId);
    clickElement(password);
    sendKeys(password,pass);
    logger.info("Id ve Şifre girildi");
    clickElement(oturumAc);
    logger.info("Oturum aç'a tıklandı.");


    }
}
