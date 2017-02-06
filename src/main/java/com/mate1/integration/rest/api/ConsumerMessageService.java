package com.mate1.integration.rest.api;

import com.mate1.broker.api.impl.BrokerServiceImpl;
import com.mate1.integration.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dev/v1/pop/{sessionId}", produces = "application/json")
public class ConsumerMessageService {

    @Autowired
    private BrokerServiceImpl broker;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Event retrieveEvents(@PathVariable String sessionId) {

        return broker.pop(sessionId);

    }

}
