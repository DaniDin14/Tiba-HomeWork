package SanityTest;

import Utilities.commonOps;
import Utilities.listeners;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.class)
public class youtubeSearchAndFilter extends commonOps {
    @Test (description = "Search For A Song, Add Filters, Play It, Skip The Ad, Print The Channel And Artist Names.", priority = 1)
    @Description("Search For A Song, Add Filters, Play It, Skip The Ad, Print The Channel And Artist Names.")
    public void test01_Search() {
        webFlows.searchSong(getData("songQuery"), getData("songURL"), getData("artistName"));
    }
}