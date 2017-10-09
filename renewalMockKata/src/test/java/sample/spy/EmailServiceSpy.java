package sample.spy;

import sample.SampleEmailService;

import java.util.List;

public class EmailServiceSpy implements SampleEmailService {

    private String message;
    private List<String> emails;

    @Override
    public void emailMessage(String message, List<String> emails) {
        this.message = message;
        this.emails = emails;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getEmails() {
        return emails;
    }
}
