package testmaster.selenium.test;

import org.junit.jupiter.api.Test;
import testmaster.selenium.driver.Driver;
import testmaster.selenium.pages.*;

public class SpotifyTest extends Driver {

    GuestPage guestPage;
    HomePage homePage;
    LoginPage loginPage;
    PlaylistPage playlistPage;
    SearchPage searchPage;

    @Test
    public void testMethod(){

        init();
        guestPage.closeCookie(GuestPage.cookieCloser);
        guestPage.LoginClck();
        loginPage.isInLgnPage();
        loginPage.enterIdPass("eralp.sergin@testinium.com","eralp12345");
        homePage.isThereUserIDShow("eralpTestinium");
        playlistPage.playlistPageCntrl();
        playlistPage.createPlaylist();
        playlistPage.renamePlaylist("Spotify Listem");
        playlistPage.goToHomePage();
        homePage.listNameControl();
        homePage.goToSearchPage();
        searchPage.findSongs("Daft Punk");
        searchPage.addSongToList(SearchPage.songOptions);
        searchPage.addSongToList(SearchPage.songOptionsTwo);
        searchPage.addSongToList(SearchPage.songOptionsThree);
        searchPage.goToHomePage();
        homePage.goToPlaylistPage();
        playlistPage.isPlaylistHasThreeSongs();
        playlistPage.playSecondSong();
        /**Bazen tıkladığı halde şarkıyı çalmayabiliyor.Birkaç kez re-run test lazım.
         Re-run edildiğinde atık playlist kalacağı için son method Assertion hata vericektir.
         **/
        playlistPage.stopSecondSong();
        playlistPage.removeThirdSong(PlaylistPage.songOptionsThree);
        playlistPage.removePlaylist();
        playlistPage.removePlaylistControl();








    }




    public void init(){
        guestPage = new GuestPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        playlistPage = new PlaylistPage();
        searchPage = new SearchPage();

    }
}
