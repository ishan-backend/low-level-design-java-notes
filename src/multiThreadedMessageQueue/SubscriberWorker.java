package multiThreadedMessageQueue;

import multiThreadedMessageQueue.model.Message;
import multiThreadedMessageQueue.model.Topic;
import multiThreadedMessageQueue.model.TopicSubscriber;

public class SubscriberWorker implements Runnable{ // SubscriberWorker will be used to create threads
    private final Topic topic; // topic reference since it holds list of messages
    private final TopicSubscriber topicSubscriber; // topicSubscriber reference since it holds offset from which this SubscriberWorker is supposed to be started

    public SubscriberWorker(final Topic topic, final TopicSubscriber topicSubscriber) { // todo: add @NonNull
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @Override
    public void run() {
        synchronized (topicSubscriber) { // at one time only one thread can take up object of topicSubscriber
            int currOffset = topicSubscriber.getOffset().get();
            while(currOffset >= topic.getMessages().size()) {
                try {
                    topicSubscriber.wait(); // The thread releases ownership of this monitor and waits until another thread notifies threads waiting on this object's monitor to wake up either through a call to the notify method or the notifyAll method.
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            Message currOffsetMessage = topic.getMessages().get(currOffset); // get message on currOffset
            try {
                topicSubscriber.getSubscriber().consume(currOffsetMessage);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
