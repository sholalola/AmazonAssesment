package steps;

import base.AmazonBase;
import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.HomePage;

import java.time.Duration;

public class CommonSteps extends AmazonBase {

    static HomePage homePage = new HomePage();

    public static String getLaptopPrice() {
        return homePage.laptopPrice.getText();
    }

    @Given("user is on the homepage")
    public void openWebPage() {

        driver.get("https://www.amazon.co.uk/");
       waitForElementToBeClickable(homePage.declineCookie);
       homePage.declineCookie.click();

    }

    public static String getMonitorPrice(){
       return homePage.monitorPrice.getText();
    }

    public static void waitForElementToBeClickable(WebElement element) {
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofMillis(30000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void scrollDownToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
