package com.mate1.integration.rest.api;

import com.mate1.broker.api.impl.BrokerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dev/v1/connect/topic", consumes = "application/json")
public class OpenSessionService {

    @Autowired
    private BrokerServiceImpl broker;

    // String sessionId
    @RequestMapping(value = "/{topic}", method = RequestMethod.POST)
    public boolean openSession(@PathVariable String topic, @RequestBody String sessionIdRequest) {

        return broker.openSession(topic, sessionIdRequest);

    }

}
