package com.mate1.queue.api;

import com.mate1.integration.model.Event;

public interface SubjectQueue {

    void attach(QueueObserver queueObserver);

    void notifyAllObserversPush(Event event);

}
