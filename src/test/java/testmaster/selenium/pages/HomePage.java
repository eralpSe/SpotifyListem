package testmaster.selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

public class HomePage extends Methods {
    private static final Logger logger = LogManager.getLogger(HomePage.class);
   public static final By userName = By.xpath("//span[@data-testid='user-widget-name']") ;
    public static final By listNameCheck = By.xpath("//a[contains(@class,'standalone')]//span[text()='Spotify Listem']");
    public static final By listNameLast = By.cssSelector(".AINMAUImkAYJd4ertQxy");
    public static final By searchButton = By.xpath("//a[@href='/search']");


    public void isThereUserIDShow(String username){
        Assertions.assertEquals(username,getText(userName),"Kullanıcı girişi yapılamadı");
        logger.info("Homepage yüklendi. Kullanıcı girişi  başarılı.");
    }

    public void listNameControl(){
        logger.info(getText(listNameCheck));
        Assertions.assertEquals("Spotify Listem", getText(listNameCheck), "Playlist ismi değiştirilemedi");
        logger.info( "Playlist ismi başarı bir şekilde değiştirildi");
    }
    public void goToSearchPage(){
        clickElement(searchButton);
        logger.info("Arama sekmesine tıklandı.");
    }
    public void goToPlaylistPage(){
        clickElement(listNameLast);
        logger.info("Playliste gidildi");
    }


}
