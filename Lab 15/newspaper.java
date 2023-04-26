import java.util.ArrayList;
import java.util.List;

public class NewspaperPublisherImpl implements NewspaperPublisher {

    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void registerSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unregisterSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String news) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }

    public void publish(String news) {
        System.out.println("Newspaper published: " + news);
        notifySubscribers(news);
    }

}

interface NewspaperPublisher {
    void registerSubscriber(Subscriber subscriber);
    void unregisterSubscriber(Subscriber subscriber);
    void notifySubscribers(String news);
}

interface Subscriber {
    void update(String news);
}

class SubscriberImpl implements Subscriber {

    private String name;

    public SubscriberImpl(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }

}

public class ObserverPatternExample {

    public static void main(String[] args) {

        NewspaperPublisherImpl publisher = new NewspaperPublisherImpl();

        Subscriber s1 = new SubscriberImpl("John");
        Subscriber s2 = new SubscriberImpl("Jane");
        Subscriber s3 = new SubscriberImpl("Bob");

        publisher.registerSubscriber(s1);
        publisher.registerSubscriber(s2);
        publisher.registerSubscriber(s3);

        publisher.publish("Breaking news: COVID-19 vaccine approved!");

        publisher.unregisterSubscriber(s2);

        publisher.publish("Sports: Local team wins championship!");

    }

}
