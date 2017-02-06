package com.mate1.broker.api;

import com.mate1.queue.api.impl.SubjectQueueImpl;
import com.mate1.integration.model.Event;

import java.util.List;

public interface BrokerService {

    String openSession(String topic);

    boolean openSession(String topic, String sessionId);

    Event pop(String sessionId);

    boolean push(String topic, Event event);

    List<SubjectQueueImpl> getListTopics();

}
