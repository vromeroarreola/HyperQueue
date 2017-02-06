package com.mate1.queue.api.impl;

import com.mate1.queue.api.QueueObserver;
import com.mate1.queue.api.SubjectQueue;
import com.mate1.integration.model.Event;

import java.util.LinkedList;
import java.util.List;

public class SubjectQueueImpl extends QueueImpl implements SubjectQueue {

    private List<QueueObserver> observers = new LinkedList<QueueObserver>();

    public void attach(QueueObserver queueObserver){
        observers.add(queueObserver);
    }

    public void notifyAllObserversPush(Event event) {

        this.push(event);

        for (QueueObserver queueObserver : observers) {
            queueObserver.updatePushAction(event);
        }
    }

}
