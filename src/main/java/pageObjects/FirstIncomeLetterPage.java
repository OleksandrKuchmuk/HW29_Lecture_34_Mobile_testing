package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class FirstIncomeLetterPage extends BasePage {

    @AndroidFindBy(id = "subject_and_folder_view")
    private MobileElement subjectOfIncomeLetter;

    @AndroidFindBy(id = "delete")
    private MobileElement deleteBTN;

    @AndroidFindBy(id = "description_text")
    private MobileElement alertMessage;

    public FirstIncomeLetterPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public FirstIncomeLetterPage clickOnDeleteButton() {
        waitForElementAndClick(deleteBTN, "can`t find 'deleteBTN'", 5);
        return this;
    }

    public String subjectOfIncomeLetter() {
        return subjectOfIncomeLetter.getText();
    }

    public boolean isSubjectOfIncomeLetterContainTestSubject(String testSubject) {
        return subjectOfIncomeLetter().contains(testSubject);
    }

    public void deleteIncomeLetterIfSubjectContainsText(String testSubject) {
        if (isSubjectOfIncomeLetterContainTestSubject(testSubject)) {
            deleteBTN.click();
        }
    }

    public String getTextFromAlertMessage() {
        return waitForElementAndGetText(alertMessage, "cant find alert message", 5);
    }
}
