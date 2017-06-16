import static org.junit.Assert.assertEquals;

import org.junit.Test;

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

  @Test
  public void notifyingAtRiskSubscribersShouldSendEmails() {
    // Arrange
    MockEmailService emailService = new MockEmailService();
    RenewalNotificationService renewalNotificationService =
        new RenewalNotificationService(new RealSubscriberService(), emailService);

    // Act
    renewalNotificationService.notifyAtRiskSubscribers();
    
    // Assert
    assertEquals("Please renew your subscription to Ferret Fancy!", emailService.getLastMessageSent());
    assertEquals(Arrays.asList("mrcoolguy@example.com"), emailService.getLastEmailAddresses());
  }
}
