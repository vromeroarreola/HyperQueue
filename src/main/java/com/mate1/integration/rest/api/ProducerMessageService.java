package com.mate1.integration.rest.api;

import com.mate1.broker.api.impl.BrokerServiceImpl;
import com.mate1.integration.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dev/v1/push", consumes = "application/json")
public class ProducerMessageService {

    @Autowired
    private BrokerServiceImpl broker;

    @RequestMapping(value = "/{topic}", method = RequestMethod.POST)
    public boolean consumeMessage(@PathVariable String topic, @RequestBody Event eventRequest) {

         return broker.push(topic, eventRequest);

    }

}
