package sample;

import java.util.List;

public class SampleRenewalNotificationService {

    SampleSubscriberService subscriberService;
    private SampleEmailService emailService;

    public SampleRenewalNotificationService(SampleSubscriberService subscriberService, SampleEmailService emailService) {
        this.subscriberService = subscriberService;
        this.emailService = emailService;
    }

    public void notifyAtRiskSubscribers() {
        List<String> subscribersThatWillExpireBetweenNowAndDate =
                subscriberService.getSubscribersThatWillExpireBetweenNowAndDate(0, 0, 0);
        emailService.emailMessage("Please renew your subscription to Ferret Fancy!",
                subscribersThatWillExpireBetweenNowAndDate);
    }
}
