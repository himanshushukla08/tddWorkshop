import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RenewalNotificationServiceTest {

  public class MockEmailService implements EmailService {

    private String lastMessage;
    private List<String> lastEmails;

    @Override
    public void emailMessage(String message, List<String> emails) {
      this.lastMessage = message;
      this.lastEmails = emails;

    }

    public String getLastMessageSent() {
      return this.lastMessage;
    }

    public List<String> getLastEmailAddresses() {
      return this.lastEmails;
    }

  }

  public class MockSubscriberService implements SubscriberService {

    public List<String> subscribers = new ArrayList<>();
    public int day;
    public int month;
    public int year;

    @Override
    public List<String> getSubscribersThatWillExpireBetweenNowAndDate(int day, int month, int year) {
      this.day = day;
      this.month = month;
      this.year = year;
      return this.subscribers ;
    }

  }

  @Test
  public void notifyingAtRiskSubscribersShouldSendEmails() {
    // Arrange
    MockEmailService emailService = new MockEmailService();
    MockSubscriberService subscriberService = new MockSubscriberService();
    subscriberService.subscribers.add("mrcoolguy@example.com");
    
    RenewalNotificationService renewalNotificationService =
        new RenewalNotificationService(subscriberService, emailService, LocalDate.now());

    // Act
    renewalNotificationService.notifyAtRiskSubscribers();

    // Assert
    assertEquals("Please renew your subscription to Ferret Fancy!", emailService.getLastMessageSent());
    assertEquals(Arrays.asList("mrcoolguy@example.com"), emailService.getLastEmailAddresses());
  }

  @Test
  public void shouldGetListOfEmailsFromTheSubscriberService() {
    // Arrange
    MockEmailService emailService = new MockEmailService();
    MockSubscriberService subscriberService = new MockSubscriberService();
    subscriberService.subscribers.add("mrcoolguy@example.com");
    subscriberService.subscribers.add("ferretFan121@hotmail.co.org.uk.io");

    RenewalNotificationService renewalNotificationService =
        new RenewalNotificationService(subscriberService, emailService, LocalDate.now());

    // Act
    renewalNotificationService.notifyAtRiskSubscribers();

    // Assert
    assertEquals("Please renew your subscription to Ferret Fancy!", emailService.getLastMessageSent());
    assertEquals(Arrays.asList("mrcoolguy@example.com", "ferretFan121@hotmail.co.org.uk.io"),
        emailService.getLastEmailAddresses());
  }
  
  @Test
  public void shouldQueryTheSubscriberServiceWithADateThatIsThreeMonthsAway_Example1() {
    LocalDate today = LocalDate.of(1776, 4, 4);
    
    // Arrange
    MockEmailService emailService = new MockEmailService();
    MockSubscriberService subscriberService = new MockSubscriberService();

    RenewalNotificationService renewalNotificationService =
        new RenewalNotificationService(subscriberService, emailService, today);

    // Act
    renewalNotificationService.notifyAtRiskSubscribers();

    // Assert
    assertEquals(4, subscriberService.day);
    assertEquals(7, subscriberService.month);
    assertEquals(1776, subscriberService.year);
  }
  
  @Test
  public void shouldQueryTheSubscriberServiceWithADateThatIsThreeMonthsAway_Example2() {
    // Arrange
    MockEmailService emailService = new MockEmailService();
    MockSubscriberService subscriberService = new MockSubscriberService();
    LocalDate today = LocalDate.of(1955, 8, 5);

    RenewalNotificationService renewalNotificationService =
        new RenewalNotificationService(subscriberService, emailService, today);

    // Act
    renewalNotificationService.notifyAtRiskSubscribers();

    // Assert
    assertEquals(5, subscriberService.day);
    assertEquals(11, subscriberService.month);
    assertEquals(1955, subscriberService.year);
  }
  
  
}
