package testmaster.selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

public class SearchPage extends Methods {
    private static final Logger logger = LogManager.getLogger(SearchPage.class);

    public static final By searchBox = By.cssSelector("input[data-testid=\"search-input\"]");
    public static final By titleSongsButton = By.xpath("//span[@class=\"ChipInner-sc-1ly6j4j-0 dLSEQM\"][text()='Şarkılar']");
    public static final By songOptions = By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='4']//button[@aria-haspopup='menu']");
    public static final By songOptionsTwo = By.xpath("//div[@aria-rowindex='3']//div[@aria-colindex='4']//button[@aria-haspopup='menu']");
    public static final By songOptionsThree = By.xpath("//div[@aria-rowindex='4']//div[@aria-colindex='4']//button[@aria-haspopup='menu']");

    public static final By listNameCheck = By.xpath("//a[contains(@class,'standalone')]//span[text()='Spotify Listem']");
    public static final By hoverMenu = By.xpath("//div[@id='context-menu']");
    public static final By addToMyPlaylist = By.xpath("//span[text()='Çalma listesine ekle']");

    public static final By hoverToAddPlaylist = By.xpath("//button[@role='menuitem']//span[text()='Spotify Listem']");
    public static final By anasayfa = By.xpath("//span[text()='Ana sayfa']");

    public void findSongs(String singerName){
       Assertions.assertTrue( isElementVisible(searchBox,15),"Searchbox elementi gözükmüyor.");
        Assertions.assertTrue(isElementClickable(searchBox,15),"Searchbox elementine tıklanmıyor");
        clickElement(searchBox);
        logger.info("Searchboxa tıklandı.");
        sendKeys(searchBox,singerName);
        logger.info("Şarkıcı ismi girildi.");
        clickElement(titleSongsButton);
        logger.info("Şarkılar sütununa gidildi.");


    }
    public void addSongToList(By by){
        clickElement(by);
        logger.info("Şarkı seçeneklerine tıklandı.");
        hoverElement(hoverMenu);
        waitByMilliSeconds(500);
        hoverElement(addToMyPlaylist);
        waitByMilliSeconds(500);
        clickElement(hoverToAddPlaylist);
        waitByMilliSeconds(500);
        logger.info("Şarkı listenize eklendi");
    }
public void goToHomePage(){
        clickElement(anasayfa);
}



}
