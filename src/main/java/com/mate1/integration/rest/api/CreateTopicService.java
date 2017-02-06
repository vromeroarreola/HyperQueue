package com.mate1.integration.rest.api;

import com.mate1.broker.api.impl.BrokerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dev/v1/topic")
public class CreateTopicService {

    @Autowired
    private BrokerServiceImpl broker;

    @RequestMapping(value = "/{topic}", method = RequestMethod.POST)
    public String createTopic(@PathVariable String topic) {

        return broker.openSession(topic);

    }

}
