package Module2_Orders_Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VB {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create an instance of ChromeDriver with desired options
        ChromeOptions op = new ChromeOptions();
        op.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(op);

        // Launch the webpage
        driver.get("http://www.example.com");
        
        Thread.sleep(3000);
        
        // Execute VBScript using JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String vbsScript = "MsgBox \"Hello, World!\"";
        js.executeScript(vbsScript);

        //js.executeScript(vbsScript);
        
        Thread.sleep(3000);
        // Close the browser
        driver.quit();
    }
}
