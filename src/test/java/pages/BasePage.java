package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;




public class BasePage {

    protected static WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
   
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void goToLinkText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    private WebElement find(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public void clickElement(String locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    element.click();
    }

    public void submitElement(String locator) {
        find(locator).submit();
    }

    public void write(String locator, String textToWrite) {
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void getScreenshoot(String locator, String nameOfFile) {
        try {
            File file = find(locator).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(nameOfFile+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select (find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public String textFromElement(String locator) {
        return find(locator).getText();
    }

    public List<WebElement> bringMeAllElements(String locator) {
        return driver.findElements(By.className(locator));
    }

    public void selectNthElement(String locator, int index) {
        List<WebElement> results = driver.findElements(By.xpath(locator));
        results.get(index).click();
    }
    
    
}
