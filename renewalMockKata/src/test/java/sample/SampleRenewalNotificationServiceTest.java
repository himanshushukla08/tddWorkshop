package sample;

import org.junit.Test;
import sample.spy.EmailServiceSpy;
import sample.stub.SubscriberServiceStub;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SampleRenewalNotificationServiceTest {

    @Test
    public void notifyingAtRiskSubscribersShouldSendEmails() {
        EmailServiceSpy emailServiceSpy = new EmailServiceSpy();
        List<String> expectedSubscribers = new ArrayList<String>();
        SampleSubscriberService subscriberService = new SubscriberServiceStub(expectedSubscribers);

        SampleRenewalNotificationService renewalNotificationService =
                new SampleRenewalNotificationService(subscriberService, emailServiceSpy);

        renewalNotificationService.notifyAtRiskSubscribers();

        assertEquals("Please renew your subscription to Ferret Fancy!", emailServiceSpy.getMessage());
        assertEquals(expectedSubscribers, emailServiceSpy.getEmails());
    }
}
