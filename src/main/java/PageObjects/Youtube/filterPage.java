package PageObjects.Youtube;

import Utilities.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class filterPage extends base {
    @FindBy(how = How.ID, using = "filter-button")
    public WebElement btn_filters;
    @FindBy(how = How.XPATH, using = "//div[@title='Search for Video']")
    public WebElement btn_video_filter;
    @FindBy(how = How.XPATH, using = "//div[@title='Sort by view count']")
    public WebElement btn_view_count_filter;
}
