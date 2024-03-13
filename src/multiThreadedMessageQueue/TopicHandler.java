package multiThreadedMessageQueue;

import multiThreadedMessageQueue.model.Topic;
import multiThreadedMessageQueue.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

// TopicHandler - everything around topic is handled/managed by it
// One topic (a particular topic) is handled by TopicHandler
public class TopicHandler {
    private final Topic topic; // topic which is handled by this handler
    private final Map<String, SubscriberWorker> subscriberWorkers; // there can be multiple subscriber workers/consumer_threads with different ids for same topic

    public TopicHandler(final Topic topic) {
        this.topic = topic;
        this.subscriberWorkers = new HashMap<>();
    }

    public void publish() {

    }

    public void startSubscriberWorker(final TopicSubscriber topicSubscriber) { // 1:n mapping between topic and topicSubscriber, 1:1 bw topicSubscriber and ISubscriber
        // worker needs to be aware of offset at time of start, across workers offset will remain same
        // atomic handles increment of offset/index in messages
        final String subscriberId = topicSubscriber.getSubscriber().getId();
        if(!subscriberWorkers.containsKey(subscriberId)) {
            // if earlier subscriber worker id is not found for topic
            final SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
        }
    }
}
