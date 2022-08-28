package testmaster.selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

public class GuestPage extends Methods {


   private static final Logger logger = LogManager.getLogger(GuestPage.class);
   public static final By oturumAc = By.xpath("//span[text()='Oturum aç']");
   public static final By kaydol = By.xpath("//button[text()='Kaydol']");
   public static final By cookieCloser = By.xpath("//button[@class=\"onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon\"]");

   public void closeCookie(By by){
      clickElement(by);
      logger.info("cookie kapatıldı.");
   }
   public void LoginClck(){
      clickElement(oturumAc);
      logger.info("OturumAç butonuna tıklandı.");
   }


}
