package com.mate1.business.model;

import com.mate1.queue.api.impl.QueueObserverImpl;
import com.mate1.integration.model.Event;

public class Consumer {

    private String sessionId;
    private QueueObserverImpl hyperQueueImpl;

    public Consumer(String sessionId, QueueObserverImpl hyperQueueImpl) {
        this.sessionId = sessionId;
        this.hyperQueueImpl = hyperQueueImpl;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public QueueObserverImpl getHyperQueueImpl() {
        return hyperQueueImpl;
    }

    public void setHyperQueueImpl(QueueObserverImpl hyperQueueImpl) {
        this.hyperQueueImpl = hyperQueueImpl;
    }

    public Event consumerQueuePop() {
        return hyperQueueImpl.pop();
    }

}
