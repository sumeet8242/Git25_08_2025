package framework;

import org.openqa.selenium.WebDriver;

interface createDriver{

    WebDriver createNewDriver();
    WebDriver createNewDriver(boolean closeBrowserAutomatically);
}
public enum BrowserTypes {

    CHROME,
    EDGE,
    FIREFOX;

    public WebDriver createNewDriver(){
        return BrowserUtils.getDriver(this);
    }

    public WebDriver createNewDriver(boolean closeBrowserAutomatically){
        return BrowserUtils.getDriver(this,closeBrowserAutomatically);
    }

}


