package Utilities;

import PageObjects.Youtube.filterPage;
import PageObjects.Youtube.searchPage;
import PageObjects.Youtube.videoPage;
import org.openqa.selenium.support.PageFactory;

public class managePage extends base {

    public static void init() {
        youtubeSearchPage = PageFactory.initElements(driver, searchPage.class);
        youtubeFilterPage = PageFactory.initElements(driver, filterPage.class);
        youtubeVideoPage = PageFactory.initElements(driver, videoPage.class);
    }
}