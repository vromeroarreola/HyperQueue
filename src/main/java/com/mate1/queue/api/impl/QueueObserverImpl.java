package com.mate1.queue.api.impl;

import com.mate1.queue.api.QueueObserver;
import com.mate1.integration.model.Event;
import org.springframework.stereotype.Service;

@Service
public class QueueObserverImpl extends QueueImpl implements QueueObserver {

    @Override
    public Event updatePopAction() {
        return this.pop();
    }

    @Override
    public boolean updatePushAction(Event event) {
        return push(event);
    }

}
