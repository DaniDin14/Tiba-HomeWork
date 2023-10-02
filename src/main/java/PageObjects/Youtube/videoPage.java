package PageObjects.Youtube;

import Utilities.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class videoPage extends base {
    @FindBy(how = How.CSS, using = "tp-yt-paper-button#expand")
    public WebElement btn_show_more;
    @FindBy(how = How.CSS, using = "ytd-text-inline-expander .ytd-video-description-music-section-renderer:nth-of-type(2) #info-row-header yt-formatted-string")
    public WebElement artist_name;
    @FindBy(how = How.ID, using = "dismiss-button")
    public WebElement btn_noThanks;
}
