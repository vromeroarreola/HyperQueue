package com.mate1.queue.api;

import com.mate1.integration.model.Event;

public interface Queue {

    Event pop();

    boolean push(Event event);

}
