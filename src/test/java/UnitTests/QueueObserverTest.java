package UnitTests;

import com.mate1.integration.model.Event;
import com.mate1.queue.api.QueueObserver;
import com.mate1.queue.api.impl.QueueObserverImpl;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
public class QueueObserverTest {

    @Test
    public void push() {

        QueueObserver queueObserver = Mockito.mock(QueueObserver.class);

        Event event = new Event();
        event.setData("123");

        Mockito.when(queueObserver.updatePushAction(event)).thenReturn(true);

        QueueObserverImpl hyperQueueServiceImpl = new QueueObserverImpl();

        Assert.assertEquals( queueObserver.updatePushAction(event), hyperQueueServiceImpl.updatePushAction(event) );

    }

    @Test
    public void pop() {

        QueueObserver queueObserver = Mockito.mock(QueueObserver.class);

        Event event = new Event();
        event.setData("567");

        Mockito.when(queueObserver.updatePushAction(event)).thenReturn(true);
        Mockito.when(queueObserver.updatePopAction()).thenReturn(event);

        QueueObserverImpl hyperQueueServiceImpl = new QueueObserverImpl();

        Assert.assertEquals( queueObserver.updatePushAction(event), hyperQueueServiceImpl.updatePushAction(event) );
        Assert.assertEquals( queueObserver.updatePopAction(), hyperQueueServiceImpl.updatePopAction() );

    }

}
