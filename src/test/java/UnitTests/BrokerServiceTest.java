package UnitTests;

import com.mate1.broker.api.BrokerService;
import com.mate1.broker.api.impl.BrokerServiceImpl;
import com.mate1.integration.model.Event;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

@RunWith(SpringJUnit4ClassRunner.class)
public class BrokerServiceTest {

    @Test
    public void push() {
/*
        BrokerService brokerService = Mockito.mock( BrokerService.class );

        Event event = new Event();
        event.setUserId("123");

        Mockito.when( brokerService.push("Topic1" , event)).thenReturn( true );

        BrokerServiceImpl brokerServiceImpl = new BrokerServiceImpl();

        Assert.assertEquals( brokerService.push("Topic1", event), brokerServiceImpl.push("Topic1", event) );
*/
    }

    @Test
    public void pop() {
/*
        BrokerService brokerService = Mockito.mock( BrokerService.class );

        Event event = new Event();
        event.setUserId("567");

        Mockito.when( brokerService.push("Topic2" , event)).thenReturn( true );

        OngoingStubbing<Event> stubbing = Mockito.when(brokerService.pop("Topic2"));

        BrokerServiceImpl brokerServiceImpl = new BrokerServiceImpl();

        Assert.assertEquals( brokerService.push("Topic1", event), brokerServiceImpl.push("Topic1", event) );
        Assert.assertEquals( stubbing, brokerServiceImpl.pop("Topic1") );
*/
    }

}
