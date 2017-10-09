package sample;

import java.util.List;

public interface SampleSubscriberService {

    public List<String> getSubscribersThatWillExpireBetweenNowAndDate(int day, int month, int year);

}
