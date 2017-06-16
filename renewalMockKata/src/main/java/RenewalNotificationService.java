import java.util.Arrays;

public class RenewalNotificationService {

  private SubscriberService subscriberService;
  private EmailService emailService;

  public RenewalNotificationService(SubscriberService subscriberService, EmailService emailService) {
    this.subscriberService = subscriberService;
    this.emailService = emailService;
  }

  public void notifyAtRiskSubscribers() {
    emailService.emailMessage(
        "Please renew your subscription to Ferret Fancy!",
        Arrays.asList("mrcoolguy@example.com"));
  }
}
