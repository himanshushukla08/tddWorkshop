package sample.spy;

import sample.SampleSubscriberService;

import java.util.List;

public class SubscriberServiceSpy implements SampleSubscriberService {

    private List<String> stubSubscribers;
    private int day;
    private int month;
    private int year;

    public SubscriberServiceSpy(List<String> stubSubscribers) {

        this.stubSubscribers = stubSubscribers;
    }

    @Override
    public List<String> getSubscribersThatWillExpireBetweenNowAndDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

        return stubSubscribers;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
