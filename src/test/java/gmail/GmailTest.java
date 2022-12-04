package gmail;


import businessObjects.GmailBo;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.DateUtil.getSystemCurrentDate;

public class GmailTest extends BaseTest {
    private final String recipient = "okuchmuk@gmail.com";
    private final String subject = "Super test subject " + getSystemCurrentDate();
    private final String body = "Super text body";

    @Test
    public void isLetterSentTest() {
        GmailBo gmailBo = new GmailBo(driver);
        gmailBo
                .skipInitialPage()
                .sendLetter(recipient, subject, body)
                .openSentLetters();
        Assert.assertTrue(gmailBo.isLetterSent(subject));
    }
}
