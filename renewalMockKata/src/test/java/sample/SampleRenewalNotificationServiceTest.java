package sample;

import org.junit.Test;
import sample.spy.EmailServiceSpy;

import static org.junit.Assert.assertEquals;

public class SampleRenewalNotificationServiceTest {

    @Test
    public void notifyingAtRiskSubscribersShouldSendEmails() {
        EmailServiceSpy emailServiceSpy = new EmailServiceSpy();
        SampleRenewalNotificationService renewalNotificationService =
                new SampleRenewalNotificationService(new SampleRealSubscriberService(), emailServiceSpy);

        renewalNotificationService.notifyAtRiskSubscribers();

        assertEquals("Please renew your subscription to Ferret Fancy!", emailServiceSpy.getMessage());
    }
}
