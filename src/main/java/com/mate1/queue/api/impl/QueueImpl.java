package com.mate1.queue.api.impl;

import com.mate1.queue.api.Queue;
import com.mate1.queue.model.Node;
import com.mate1.integration.model.Event;

public class QueueImpl implements Queue {

    private Node<Event> firstNode;
    private Node<Event> lastNode;

    private int eventsInQueue;

    @Override
    public Event pop() {

        Event event = this.firstNode.getData();
        this.firstNode = this.firstNode.getNextNode();

        if( this.firstNode == null )
            this.lastNode = null;

        this.eventsInQueue--;

        return event;
    }

    @Override
    public boolean push(Event event) {

        boolean status = false;

        Node<Event> lastNode = this.lastNode;
        this.lastNode = new Node<>(event);
        this.lastNode.setNextNode(null);

        if( this.firstNode == null )
            this.firstNode = this.lastNode;
        else
            lastNode.setNextNode(this.lastNode);

        this.eventsInQueue++;
        status = true;

        return status;
    }

}
