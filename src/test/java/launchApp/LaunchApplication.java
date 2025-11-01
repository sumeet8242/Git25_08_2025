package launchApp;

import framework.BrowserTypes;
import framework.BrowserUtils;
import framework.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchApplication {
@BeforeMethod
public void killBrowser(){
    BrowserUtils.killRunningBrowser("chrome");
}
    @Test(description = "Launching the application")
    public void launchApp(){
       WebDriver driver= BrowserTypes.CHROME.createNewDriver();
        SeleniumUtils utils = new SeleniumUtils(driver);
       utils.getUrl("https://www.amazon.in/");
       utils.urlOpenInANewTab("https://www.goibibo.com/");
        utils.urlOpenInANewWindow("https://www.flipkart.com/");
        utils.switchToThisWindow("Goibibo");

    }
}
