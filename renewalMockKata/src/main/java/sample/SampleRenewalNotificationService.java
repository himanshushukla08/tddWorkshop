package sample;

import java.util.List;

public class SampleRenewalNotificationService {

    SampleSubscriberService subscriberService;
    private SampleEmailService emailService;
    private FutureDateProvider dateProvider;

    public SampleRenewalNotificationService(SampleSubscriberService subscriberService, SampleEmailService emailService,
                                            FutureDateProvider dateProvider) {
        this.subscriberService = subscriberService;
        this.emailService = emailService;
        this.dateProvider = dateProvider;
    }

    public void notifyAtRiskSubscribers() {
        List<String> subscribersThatWillExpireBetweenNowAndDate =
                subscriberService.getSubscribersThatWillExpireBetweenNowAndDate(dateProvider.getFutureDay(),
                        dateProvider.getFutureMonth(), dateProvider.getFutureYear());
        emailService.emailMessage("Please renew your subscription to Ferret Fancy!",
                subscribersThatWillExpireBetweenNowAndDate);
    }
}
