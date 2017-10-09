package sample.stub;

import sample.SampleSubscriberService;

import java.util.List;

public class SubscriberServiceStub implements SampleSubscriberService {

    private List<String> stubSubscribers;

    public SubscriberServiceStub(List<String> stubSubscribers) {

        this.stubSubscribers = stubSubscribers;
    }

    @Override
    public List<String> getSubscribersThatWillExpireBetweenNowAndDate(int day, int month, int year) {
        return stubSubscribers;
    }
}
