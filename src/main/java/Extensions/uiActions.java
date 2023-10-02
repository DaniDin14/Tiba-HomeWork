package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;

public class uiActions extends commonOps {

    @Step("Click On Element")
    public static void waitAndClick(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Get Text From Element")
    public static String waitAndGetText(WebElement elem) {
        return elem.getText();
    }

    @Step("Send Text To Text-Field")
    public static void waitAndSendKeys(WebElement elem, String value) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }

    public static void searchForSong(String query) {
        try {
            uiActions.waitAndSendKeys(youtubeMainPage.txt_searchRow, query);
            uiActions.waitAndClick(youtubeMainPage.btn_search);
        } catch (Exception e) {
            logger.error("An error occurred while searching for the song: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void addFilters() {
        uiActions.waitAndClick(youtubeMainPage.btn_filters);
        uiActions.waitAndClick(youtubeMainPage.btn_video_filter);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='style-scope yt-chip-cloud-renderer']//iron-selector[@id='chips']")));
        uiActions.waitAndClick(youtubeMainPage.btn_filters);
        WebElement videoFilterSelected = driver.findElement(By.xpath("//a[@aria-selected='true' and @href]"));
        boolean isVideoFilterSelected = videoFilterSelected.getAttribute("aria-selected").equals("true");
        Assert.assertTrue(isVideoFilterSelected, "The video filter is not selected");
        uiActions.waitAndClick(youtubeMainPage.btn_view_count_filter);
    }

    @Step("Choose Video From List")
    public static void chooseVideoFromList(String songURL) {
        logger.debug("page source" + driver.getPageSource());
        List<WebElement> searchResults = youtubeMainPage.list_searchResults;
        for (WebElement result : searchResults) {
            WebElement videoLink = result.findElement(By.tagName("a"));
            String videoURL = videoLink.getAttribute("href");
            if (videoURL.contains(songURL)) {
                WebElement channelName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='channel-info']/ytd-channel-name[@id='channel-name']//yt-formatted-string[@id='text']")));
                logger.info(("The Channel Name Is: " + channelName.getText()));
                videoLink.click();
                break;
            }
        }
    }

    @Step("Click On Skip Ad")
    public static void skipAd() {
        WebElement skipAdButton;

        try {
            skipAdButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ytp-ad-text ytp-ad-skip-button-text']")));
            if (skipAdButton.isDisplayed()) {
                    skipAdButton.click();
                    logger.info("Skipped the ad");
            }
        } catch (TimeoutException e) {
            logger.info("No ad detected, continuing with video.");
        }
        catch (Exception e) {
            logger.info("An error occurred: " + e.getMessage());
        }
    }

    public static String getArtistName() {
        return uiActions.waitAndGetText(youtubeMainPage.artist_name);
    }

    public static void closedYouTubeMusicPopup() {
        try {
            if (youtubeMainPage.btn_noThanks.isDisplayed()) {
                uiActions.waitAndClick(youtubeMainPage.btn_noThanks);
            }
        } catch (Exception e) {
            logger.info("YouTube Music popup did not appear");
            logger.debug("An error occurred: " + e.getMessage());
        }
    }
}
