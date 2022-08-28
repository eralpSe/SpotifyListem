package testmaster.selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import testmaster.selenium.methods.Methods;

public class PlaylistPage extends Methods {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public static final By titleList = By.xpath("//button[@data-testid='create-playlist-button']");
    public static final By myPlaylistName = By.xpath("//h1[@dir='auto' or text()='1. Çalma Listem']");
    public static final By newPlaylist = By.cssSelector("button[data-testid=\"create-playlist-button\"]");
    public static final By editPlaylistNameDetails = By.cssSelector("input[data-testid=\"playlist-edit-details-name-input\"]");
    public static final By description = By.cssSelector("textarea[data-testid=\"playlist-edit-details-description-input\"]");
    public static final By saveButton = By.cssSelector("button[data-testid=\"playlist-edit-details-save-button\"]");
    public static final By anasayfa = By.xpath("//span[text()='Ana sayfa']");
    public static final By songCountControl = By.xpath("//span[@class='Type__TypeElement-goli3j-0 cPwEdQ RANLXG3qKB61Bh33I0r2']");
    public static final By playbackPosition = By.xpath("//div[@data-testid=\"playback-position\"]");
    public static final By playAndPauseButton=By.xpath("//button[@aria-label='Çal'][@data-testid='control-button-playpause']");
    public static final By playAndPauseButtonTwo=By.xpath("//div[@data-testid=\"action-bar-row\"]//button[@data-testid=\"play-button\"]");

    public static final By secondSongHoverArea = By.xpath("//div[@aria-rowcount=\"4\"]//div[@aria-rowindex=\"3\"]");
    public static final By secondSongPlayButton= By.xpath("//div[@aria-rowindex=\"3\"]//div[@class='VpYFchIiPg3tPhBGyynT']//button[contains(@aria-label,'parçasını çal')]");
    public static final By hoverMenu = By.xpath("//div[@id='context-menu']");
    public static final By hoverDeleteSong = By.xpath("//span[text()='Bu çalma listesinden kaldır']");

    public static final By songOptionsThree = By.xpath("//div[@aria-rowindex='4']//div[@aria-colindex=\"5\"]//button[@aria-haspopup=\"menu\"]");
    public static final By deleteListOption= By.xpath("//div[@id=\"context-menu\"]//span[text()='Sil']");
    public static final By deleteButton= By.xpath("//button[@aria-label=\"Spotify Listem silinsin mi?\"]");

    public static final By deletePopUp = By.xpath("//*[contains(text(),'Kitaplığından')]");
    public static final By removePlaylistControlText = By.xpath("//h1[text()='İlk çalma listeni oluştur']");
    public static final By listOptions = By.xpath("//button[@aria-label=\"Spotify Listem için diğer seçenekler\"]");
    public void playlistPageCntrl(){
        Assertions.assertEquals("Çalma Listesi Oluştur",getText(titleList),"Çalma listesi yazısı görülmedi.");
    }
    public void createPlaylist(){
        clickElement(newPlaylist);
        logger.info("Yeni çalma listesi oluşturuldu.");
    }
    public void renamePlaylist(String playlistName) {

        Assertions.assertTrue(isElementClickable(myPlaylistName, 15), "Playlist ismine tıklanamıyor.");
        clickElement(myPlaylistName);
        logger.info("Playlist ismine tıklandı.");
        Assertions.assertTrue(isElementClickable(editPlaylistNameDetails, 15), "Edit Playliste tıklanamıyor.");
        clickElement(editPlaylistNameDetails);
        clear(editPlaylistNameDetails);
        sendKeys(editPlaylistNameDetails, playlistName);
        clickElement(description);
        sendKeys(description, "By Testinium");
        clickElement(saveButton);
    }
    public void goToHomePage(){
        clickElement(anasayfa);
    }
    public void isPlaylistHasThreeSongs(){
       Assertions.assertTrue(getText(songCountControl).contains("şarkı"),"Liste 3 şarkıdan oluşmuyor.");
        logger.info("Çalma listesinin 3 şarkı olduğu doğrulandı.");
    }
    public void playSecondSong(){
        hoverElement(secondSongHoverArea);
        hoverElement(secondSongPlayButton);
        waitByMilliSeconds(500);
        clickElement(secondSongPlayButton);


    }
    public void stopSecondSong(){

        waitBySeconds(13);
        String timelapse = getText(playbackPosition);
        logger.info(getText(playbackPosition));
            if(timelapse.contains("0:1")){

                hoverElement(playAndPauseButtonTwo);
                clickElement(playAndPauseButtonTwo);
            }

    }
    public void removeThirdSong(By by){
        clickElement(by);
        waitByMilliSeconds(500);
        hoverElement(hoverMenu);
        waitByMilliSeconds(500);
        hoverElement(hoverDeleteSong);
        waitByMilliSeconds(500);
        clickElement(hoverDeleteSong);
        logger.info("Üçücü şarkı silindi");
    }

    public void removePlaylist(){
        clickElement(listOptions);
        hoverElement(hoverMenu);
        waitByMilliSeconds(500);
        hoverElement(deleteListOption);
        waitByMilliSeconds(500);
        clickElement(deleteListOption);
        waitByMilliSeconds(250);
        clickElement(deleteButton);
        Assertions.assertTrue(getText(deletePopUp).contains("Kitaplığından"),"Playlist Silinemedi.");
        logger.info("Playlist silindi.");

    }
    public void removePlaylistControl(){
        Assertions.assertTrue(getText(removePlaylistControlText).contains("İlk çalma listeni oluştur"),"Mevcutta playlist var gözüküyor");
        logger.info("Herhangibir playlist kalmadığı doğrulandı.");

    }



}
