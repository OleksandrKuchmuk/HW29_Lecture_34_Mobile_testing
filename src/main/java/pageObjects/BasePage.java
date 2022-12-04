package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {
    private static Logger LOGGER = LogManager.getLogger(BasePage.class);
    protected AppiumDriver driver;

    public BasePage(AppiumDriver<?> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private void fluentWait(MobileElement element, long timeout) {
        Wait wait = new AppiumFluentWait(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(java.util.NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBePresent(WebElement element, String errorMessage, long timeoutInSeconds) {
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
//                .ignoring(TimeOutExeption)
                .withMessage(errorMessage);
    }

    public WebElement waitForElementToBeClicable(WebElement element, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (StaleElementReferenceException e) {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    public String waitForElementAndGetText(MobileElement element, String errorMessage, long timeoutInSeconds) {
        waitForElementToBePresent(element, errorMessage, timeoutInSeconds);
        return element.getText();
    }

    public WebElement waitForElementAndClick(MobileElement element, String errorMessage, long timeoutInSeconds) {
        try {
            fluentWait(element, timeoutInSeconds);
            element.click();
        } catch (NoSuchElementException e) {
            LOGGER.info(errorMessage);
        }
        return element;
    }

    public WebElement waitForElementAndSendKeys(MobileElement element, String value, String errorMessage, long timeoutInSeconds) {
        try {
            fluentWait(element, timeoutInSeconds);
        } catch (NoSuchElementException e) {
            LOGGER.info(errorMessage);
        }
        element.sendKeys(value);
        return element;
    }

}
