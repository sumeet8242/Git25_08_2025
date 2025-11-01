package framework;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
public class SeleniumUtils {

    private WebDriver driver;

    public void quitDriver(){
        driver.quit();
    }
    public String getUrl(String url){
        Optional.ofNullable(url).orElseThrow(()-> new GenericExceptions("Give correct title"));

        if(!url.startsWith("http")) {
            throw new GenericExceptions("Start url with http");
        }
        driver.get(url);
        driver.manage().window().maximize();
        return driver.getWindowHandle();
    }

    public String urlOpenInANewTab(String url){

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
        return driver.getWindowHandle();
    }

    public String urlOpenInANewWindow(String url){

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(url);
        driver.manage().window().maximize();
        return driver.getWindowHandle();
    }

    public SeleniumUtils switchToNewWindow(){
    Set<String> windowHandles=driver.getWindowHandles();

    for(String windowHandle : windowHandles ){
        driver.switchTo().window(windowHandle);
    }
    return this;
    }

    public SeleniumUtils switchToThisWindow(String title){

        Set<String> windowHandles=driver.getWindowHandles();
        for(String windowHandle : windowHandles ){
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().contains(title)){
                break;
            }
        }
        return this;
    }



}
