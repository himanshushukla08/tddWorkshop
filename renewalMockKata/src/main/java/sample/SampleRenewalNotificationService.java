package sample;

public class SampleRenewalNotificationService {

    SampleSubscriberService myThing;
    private SampleEmailService emailService;

    public SampleRenewalNotificationService(SampleSubscriberService subscriberService, SampleEmailService emailService) {
        myThing = subscriberService;
        this.emailService = emailService;
    }

    public void notifyAtRiskSubscribers() {
        emailService.emailMessage("Please renew your subscription to Ferret Fancy!", null);
    }
}
