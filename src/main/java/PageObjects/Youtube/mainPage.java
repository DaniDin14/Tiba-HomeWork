package PageObjects.Youtube;

import Utilities.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class mainPage extends base {
    @FindBy(how = How.CSS, using = "input#search")
    public WebElement txt_searchRow;
    @FindBy(how = How.ID, using = "search-icon-legacy")
    public WebElement btn_search;
    @FindBy(how = How.ID, using = "filter-button")
    public WebElement btn_filters;
    @FindBy(how = How.XPATH, using = "//div[@title='Search for Video']")
    public WebElement btn_video_filter;
    @FindBy(how = How.CSS, using = "tp-yt-paper-button#expand")
    public WebElement btn_show_more;
    @FindBy(how = How.CSS, using = "ytd-text-inline-expander .ytd-video-description-music-section-renderer:nth-of-type(2) #info-row-header yt-formatted-string")
    public WebElement artist_name;
    @FindBy(how = How.XPATH, using = "//div[@title='Sort by view count']")
    public WebElement btn_view_count_filter;

    @FindBy(how = How.CSS, using = "div#contents ytd-video-renderer")
    public List<WebElement> list_searchResults;

    @FindBy(how = How.ID, using = "dismiss-button")
    public WebElement btn_noThanks;
}