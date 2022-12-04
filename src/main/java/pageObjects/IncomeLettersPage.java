package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class IncomeLettersPage extends BasePage{

    @AndroidFindBy(id="next_button")
    private MobileElement okBTNInAlertWindow;

    @AndroidFindBy(id="compose_button")
    private MobileElement composeBTN;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Висунути панель навігації\"]")
    private MobileElement navigationDrawerBTN;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout//android.widget.TextView[@text='Надіслані']")
    private MobileElement sentBTN;

    public IncomeLettersPage(AndroidDriver driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public IncomeLettersPage closeAlertWindow(){

        waitForElementAndClick(okBTNInAlertWindow, "can`t find 'cokBTNInAlertWindow'", 5);
        return this;
    }

    public IncomeLettersPage clickComposeBTN(){

        waitForElementAndClick(composeBTN, "can`t find 'composeBTN'", 5);
        return this;
    }

    public IncomeLettersPage clickNavigationDrawerBTN(){
        waitForElementAndClick(navigationDrawerBTN, "can`t find 'navigationDrawerBTN'", 5);
        return this;
    }

    public IncomeLettersPage clickSentBTN(){
        waitForElementAndClick(sentBTN,"can`t find 'sentBTN'",5);
        return this;
    }
}
