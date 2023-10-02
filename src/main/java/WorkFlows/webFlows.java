package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.testng.Assert;

public class webFlows extends commonOps {
    @Step("Search For A Song, Add Filters, Play It, Skip The Ad, Print The Channel And Artist Name")
    public static void searchSong(String songQuery,String songURL, String artistName) {

        try {
            uiActions.searchForSong(songQuery);
            uiActions.addFilters();
            uiActions.chooseVideoFromList(songURL);
            uiActions.skipAd();
            uiActions.closedYouTubeMusicPopup();
            uiActions.waitAndClick(youtubeVideoPage.btn_show_more);
            Assert.assertEquals(uiActions.getArtistName(), artistName);
            logger.info("The Artist Name Is: " + uiActions.getArtistName());
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }
}