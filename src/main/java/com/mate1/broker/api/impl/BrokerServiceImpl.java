package com.mate1.broker.api.impl;

import com.mate1.broker.api.BrokerService;
import com.mate1.queue.api.impl.QueueObserverImpl;
import com.mate1.queue.api.impl.SubjectQueueImpl;
import com.mate1.business.model.Consumer;
import com.mate1.integration.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BrokerServiceImpl implements BrokerService {

    private HashMap<String, Set<String>> topicSessionIdMap;
    private HashMap<String, Consumer> sessionIdConsumerMap;
    private HashMap<String, SubjectQueueImpl> topicSubjectQueue;

    private long consumerSessionId = 0;

    @Autowired
    private QueueObserverImpl hQueue;

    public BrokerServiceImpl() {
        topicSessionIdMap = new HashMap<>();
        sessionIdConsumerMap = new HashMap<>();
        topicSubjectQueue = new HashMap<>();
    }

    public synchronized String generateSessionId() {

        UUID uuid = UUID.randomUUID();
        String sessionId = uuid.toString();

        return sessionId;
    }

    private void registerCustomerSessionIdToTopic(String topic, String sessionId) {

        Set<String > consumerSessionIdSet = topicSessionIdMap.get(topic);

        if( consumerSessionIdSet != null ) {
            consumerSessionIdSet.add(sessionId);
        } else {
            HashSet newConsumerSessionIdSet = new HashSet();
            newConsumerSessionIdSet.add(sessionId);

            topicSessionIdMap.put(topic, newConsumerSessionIdSet);
        }
    }

    private void registerCustomerQueueObserverToSubjectQueue(String topic, String sessionId) {

        QueueObserverImpl queueObserverImpl = new QueueObserverImpl();
        Consumer consumer = new Consumer(sessionId, queueObserverImpl);

        SubjectQueueImpl subjectQueueImplTopic = topicSubjectQueue.get(topic);

        if( subjectQueueImplTopic != null ) {
            subjectQueueImplTopic.attach(queueObserverImpl);
        } else {
            SubjectQueueImpl subjectQueueImpl = new SubjectQueueImpl();
            subjectQueueImpl.attach(queueObserverImpl);

            topicSubjectQueue.put(topic, subjectQueueImpl);
        }

        sessionIdConsumerMap.put(sessionId, consumer);
    }

    @Override
    public String openSession(String topic) {

        String generatedSessionId = generateSessionId();

        registerCustomerSessionIdToTopic(topic, generatedSessionId);

        registerCustomerQueueObserverToSubjectQueue(topic, generatedSessionId);

        return generatedSessionId;
    }

    @Override
    public boolean openSession(String topic, String sessionId) {

        boolean status = false;

        Set<String> consumerSessionIdSet = topicSessionIdMap.get(topic);

        if( consumerSessionIdSet.contains(sessionId) )
            status = true;

        return status;
    }

    @Override
    public Event pop(String sessionId) {

        Consumer consumer = sessionIdConsumerMap.get(sessionId);
        Event event = consumer.consumerQueuePop();

        return event;
    }

    @Override
    public boolean push(String topic, Event event) {

        boolean status = false;

        SubjectQueueImpl subjectQueueImplTopic = topicSubjectQueue.get(topic);

        if(subjectQueueImplTopic != null)
            subjectQueueImplTopic.notifyAllObserversPush(event);

        status = true;

        return status;
    }

    public List<SubjectQueueImpl> getListTopics() {

        List<SubjectQueueImpl> list = (List<SubjectQueueImpl>) topicSubjectQueue.values();

        return list;
    }

}
