package reviewssitefullstack;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class SubscriberRepository {

	protected Map<Long,Subscriber> subscribers = new HashMap<Long,Subscriber>();
	
	public void addSubscriber(Subscriber subscribe) {
		subscribers.put(subscribe.getSubscriberId(), subscribe);
	}
	
}
