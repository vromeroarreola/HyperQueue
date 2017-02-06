package UnitTests;

import com.mate1.broker.api.BrokerService;
import com.mate1.broker.api.impl.BrokerServiceImpl;
import com.mate1.integration.model.Event;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

@RunWith(SpringJUnit4ClassRunner.class)
public class BrokerServiceTest {

    @Test
    public void push() {

        BrokerService brokerService = Mockito.mock( BrokerService.class );

        Event event = new Event();
        event.setData("123");

        Mockito.when(brokerService.push("Topic1" , event)).thenReturn( true );

        BrokerServiceImpl brokerServiceImpl = new BrokerServiceImpl();

        Assert.assertEquals( brokerService.push("Topic1", event), brokerServiceImpl.push("Topic1", event) );

    }

    @Test
    public void pop() {

        BrokerService brokerService = Mockito.mock( BrokerService.class );

        Event event = new Event();
        event.setData("567");

        Mockito.when(brokerService.push("Topic2" , event)).thenReturn(true);
        Mockito.when(brokerService.pop("Topic2")).thenReturn(event);

        BrokerServiceImpl brokerServiceImpl = new BrokerServiceImpl();
        brokerServiceImpl.registerCustomerQueueObserverToSubjectQueue("Topic2", "cde303d3-fb79-42ab-bf52-de2854b3c418");

        Assert.assertEquals( brokerService.push("Topic2", event), brokerServiceImpl.push("Topic2", event) );
        Assert.assertEquals( brokerService.pop("Topic2"), brokerServiceImpl.pop("cde303d3-fb79-42ab-bf52-de2854b3c418") );

    }

}
