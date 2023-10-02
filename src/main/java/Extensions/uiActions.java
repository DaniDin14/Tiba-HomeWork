package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
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
            uiActions.waitAndSendKeys(youtubeSearchPage.txt_searchRow, query);
            uiActions.waitAndClick(youtubeSearchPage.btn_search);
        } catch (Exception e) {
            logger.error("An error occurred while searching for the song: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void addFilters() {
        uiActions.waitAndClick(youtubeFilterPage.btn_filters);
        uiActions.waitAndClick(youtubeFilterPage.btn_video_filter);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='style-scope yt-chip-cloud-renderer']//iron-selector[@id='chips']")));
        uiActions.waitAndClick(youtubeFilterPage.btn_filters);
        WebElement videoFilterSelected = driver.findElement(By.xpath("//a[@aria-selected='true' and @href]"));
        boolean isVideoFilterSelected = videoFilterSelected.getAttribute("aria-selected").equals("true");
        Assert.assertTrue(isVideoFilterSelected, "The video filter is not selected");
        uiActions.waitAndClick(youtubeFilterPage.btn_view_count_filter);
    }

    @Step("Choose Video From List")
    public static void chooseVideoFromList(String songURL) {
        logger.debug("page source" + driver.getPageSource());
        List<WebElement> searchResults = youtubeSearchPage.list_searchResults;
        for (WebElement result : searchResults) {
            WebElement videoLink = result.findElement(By.tagName("a"));
            String videoURL = videoLink.getAttribute("href");

            if (videoURL.contains(songURL)) {
                WebElement channelNameElement = result.findElement(By.cssSelector("div#contents ytd-video-renderer div#channel-info ytd-channel-name a"));
                String channelName = channelNameElement.getText();
                logger.info("Channel Name: " + channelName);
                videoLink.click();
                break;
            }
        }
    }

    @Step("Click On Skip Ad")
    public static void skipAd() {
        try {
                WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(1));
                WebElement adTextElem = customWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ytp-ad-text ytp-ad-preview-text']")));
                if (adTextElem.isDisplayed()) {
                    if (adTextElem.getText().equals("Video will play\nafter ad") || adTextElem.getText().contains("Your video will\n" +
                        "begin in")) {
                        wait.until(ExpectedConditions.invisibilityOf(adTextElem));
                        logger.info("Waiting for ad to finish playing...");
                    }
                    else {
                        WebElement skipAdButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ytp-ad-text ytp-ad-skip-button-text']")));
                        wait.until(ExpectedConditions.elementToBeClickable(skipAdButton)).click();
                        logger.info("Skipped the ad");
                    }
                }
        } catch (TimeoutException e) {
                logger.info("No ad detected, continuing with video.");
            } catch (Exception e) {
                logger.info("An error occurred: " + e.getMessage());
            }
    }

    public static String getArtistName() {
        return uiActions.waitAndGetText(youtubeVideoPage.artist_name);
    }

    public static void closedYouTubeMusicPopup() {
        try {
            if (youtubeVideoPage.btn_noThanks.isDisplayed()) {
                uiActions.waitAndClick(youtubeVideoPage.btn_noThanks);
            }
        } catch (Exception e) {
            logger.info("YouTube Music popup did not appear");
            logger.debug("An error occurred: " + e.getMessage());
        }
    }
}
