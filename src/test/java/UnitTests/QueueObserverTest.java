package UnitTests;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
public class QueueObserverTest {

    @Test
    public void push() {
/*
        QueueObserver queueObserver = Mockito.mock(QueueObserver.class);

        Event event = new Event();
        event.setUserId("123");

        Mockito.when(queueObserver.push(event)).thenReturn(true);

        QueueObserverImpl hyperQueueServiceImpl = new QueueObserverImpl();

        Assert.assertEquals( queueObserver.push(event), hyperQueueServiceImpl.push(event) );
*/
    }

    @Test
    public void pop() {
/*
        QueueObserver queueObserver = Mockito.mock(QueueObserver.class);

        Event event = new Event();
        event.setUserId("567");

        Mockito.when(queueObserver.push(event)).thenReturn(true);
        OngoingStubbing<Event> stubbing = Mockito.when(queueObserver.pop());

        QueueObserverImpl hyperQueueServiceImpl = new QueueObserverImpl();
        boolean status = hyperQueueServiceImpl.push(event);

        Assert.assertEquals( queueObserver.push(event), status );
        Assert.assertEquals( stubbing, hyperQueueServiceImpl.pop() );
*/
    }

}
