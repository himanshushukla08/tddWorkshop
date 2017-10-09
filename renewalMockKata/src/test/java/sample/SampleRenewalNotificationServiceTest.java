package sample;

import org.junit.Test;
import sample.spy.EmailServiceSpy;
import sample.spy.SubscriberServiceSpy;
import sample.stub.FutureDateProviderStub;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SampleRenewalNotificationServiceTest {

    @Test
    public void notifyingAtRiskSubscribersShouldSendEmails() {
        EmailServiceSpy emailServiceSpy = new EmailServiceSpy();
        List<String> expectedSubscribers = new ArrayList<String>();
        SubscriberServiceSpy subscriberService = new SubscriberServiceSpy(expectedSubscribers);
        FutureDateProviderStub futureDateProvider = new FutureDateProviderStub(1, 2, 3);

        SampleRenewalNotificationService renewalNotificationService =
                new SampleRenewalNotificationService(subscriberService, emailServiceSpy, futureDateProvider);

        renewalNotificationService.notifyAtRiskSubscribers();

        assertEquals("Please renew your subscription to Ferret Fancy!", emailServiceSpy.getMessage());
        assertEquals(expectedSubscribers, emailServiceSpy.getEmails());
        assertEquals(1, subscriberService.getMonth());
        assertEquals(2, subscriberService.getDay());
        assertEquals(3, subscriberService.getYear());
    }
}
