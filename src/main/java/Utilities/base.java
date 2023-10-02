package Utilities;

import PageObjects.Youtube.filterPage;
import PageObjects.Youtube.searchPage;
import PageObjects.Youtube.videoPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Logger logger;
    public static searchPage youtubeSearchPage;
    public static filterPage youtubeFilterPage;
    public static videoPage youtubeVideoPage;

}