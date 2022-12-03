package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InitialPage extends BasePage{

    public InitialPage(AndroidDriver driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "welcome_tour_got_it")
    private WebElement gotItBTN;

    @FindBy(id = "action_done")
    private WebElement takeMeToGmailBTN;

    public InitialPage clickGotItBTN(){
        gotItBTN.click();
        return this;
    }

    public InitialPage clickTakeMeToGmailBTN(){
        takeMeToGmailBTN.click();
        return this;
    }
}
