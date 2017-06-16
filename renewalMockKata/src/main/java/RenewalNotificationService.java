import java.time.LocalDate;
import java.util.List;

public class RenewalNotificationService {

  private SubscriberService subscriberService;
  private EmailService emailService;
  private LocalDate today;

  public RenewalNotificationService(SubscriberService subscriberService, EmailService emailService,
      LocalDate today) {
    this.subscriberService = subscriberService;
    this.emailService = emailService;
    this.today = today;
  }

  public void notifyAtRiskSubscribers() {
    LocalDate threeMonthsFromToday = today.plusMonths(3);

    List<String> subscribers = subscriberService.getSubscribersThatWillExpireBetweenNowAndDate(
        threeMonthsFromToday.getDayOfMonth(), 
        threeMonthsFromToday.getMonthValue(),
        threeMonthsFromToday.getYear());

    emailService.emailMessage(
        "Please renew your subscription to Ferret Fancy!",
        subscribers);
  }
}
