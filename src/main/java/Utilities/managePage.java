package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePage extends base {

    public static void init() {
        youtubeMainPage = PageFactory.initElements(driver, PageObjects.Youtube.mainPage.class);
    }
}