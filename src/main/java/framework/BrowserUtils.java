package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@UtilityClass //All the methods inside the class remains static in nature
public class BrowserUtils {

    @SneakyThrows
    public void killRunningBrowser(String killBrowser){
        switch(killBrowser){
            case "chrome" -> Runtime.getRuntime().exec("TASKKILL -f -im chromedriver.exe /T");
            case "edge" -> Runtime.getRuntime().exec("TASKKILL -f -im edgedriver.exe /T");
            case "firefox" -> Runtime.getRuntime().exec("TASKKILL -f -im firefoxdriver.exe /T");
        };
    }
    WebDriver getDriver(BrowserTypes browser){

      return  switch(browser){

          case CHROME-> new ChromeDriver();
          case EDGE -> new EdgeDriver();
          case FIREFOX -> new FirefoxDriver();
          default -> throw new GenericExceptions("Provide valid browser");
      };
    }
WebDriver getDriver(BrowserTypes browser, boolean closeAutomatically){

        return switch(browser){

            case CHROME -> {
                if(closeAutomatically){
                    yield WebDriverManager.chromedriver().create();
                }
                else{
                    yield new ChromeDriver();
                }
            }

            case EDGE -> {
                if(closeAutomatically){
                    yield WebDriverManager.edgedriver().create();
                }
                else{
                    yield new EdgeDriver();
                }
            }

            case FIREFOX -> {
                if(closeAutomatically){
                    yield WebDriverManager.firefoxdriver().create();
                }
                else{
                    yield new FirefoxDriver();
                }
            }
        };
}

}
