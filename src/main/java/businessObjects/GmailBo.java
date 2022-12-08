package businessObjects;

import io.appium.java_client.android.AndroidDriver;
import pageObjects.*;

public class GmailBo {
    private final InitialPage initialPage;
    private final ComposePage composePage;
    private final IncomeLettersPage incomeLettersPage;
    private final FirstIncomeLetterPage firstIncomeLetterPage;
    private final SentLettersPage sentLettersPage;

    public GmailBo(AndroidDriver driver) {
        initialPage = new InitialPage(driver);
        composePage = new ComposePage(driver);
        incomeLettersPage = new IncomeLettersPage(driver);
        firstIncomeLetterPage = new FirstIncomeLetterPage(driver);
        sentLettersPage = new SentLettersPage(driver);
    }

    public GmailBo skipInitialPage() {
        initialPage
                .clickGotItBTN()
                .clickTakeMeToGmailBTN();
        return this;
    }

    public GmailBo sendLetter(String recipient, String subject, String body) {
        incomeLettersPage
                .closeAlertWindow()
                .clickComposeBTN();
        composePage
                .typeRecipient(recipient)
                .chooseFirstRecipientFromProposed()
                .typeSubject(subject)
                .typeLetter(body)
                .clickSend();
        return this;
    }

    public GmailBo openSentLetters() {
        incomeLettersPage
                .clickNavigationDrawerBTN()
                .clickSentBTN();
        return this;
    }

    public boolean isLetterSent(String subject) {
        return sentLettersPage.isSentLetterDisplayed(subject);
    }

    public GmailBo deleteFirstSendLetterIfSubjectContainsText(String subject) {
        incomeLettersPage
                .closeAlertWindow()
                .clickOnFirstIncomeLetter();
        firstIncomeLetterPage.deleteIncomeLetterIfSubjectContainsText(subject);
        return this;
    }

    public boolean isMessageAboutDeleting(String expectedMessage) {
        return firstIncomeLetterPage.getTextFromAlertMessage().equals(expectedMessage);
    }
}
