package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {
    protected AppiumDriver driver;

    public BasePage (AppiumDriver<?> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private void fluentWait(MobileElement element, long timeout){
        Wait wait = new AppiumFluentWait(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(java.util.NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBePresent(WebElement element, String errorMessage, long timeoutInSeconds){
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
//                .ignoring(TimeOutExeption)
                .withMessage(errorMessage);
    }


}
