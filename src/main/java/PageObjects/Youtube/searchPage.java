package PageObjects.Youtube;

import Utilities.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class searchPage extends base {
    @FindBy(how = How.CSS, using = "input#search")
    public WebElement txt_searchRow;
    @FindBy(how = How.ID, using = "search-icon-legacy")
    public WebElement btn_search;
    @FindBy(how = How.CSS, using = "div#contents ytd-video-renderer")
    public List<WebElement> list_searchResults;
}