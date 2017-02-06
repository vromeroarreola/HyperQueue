package com.mate1.queue.api;

import com.mate1.integration.model.Event;

public interface QueueObserver {

    Event updatePopAction();

    boolean updatePushAction(Event event);

}
