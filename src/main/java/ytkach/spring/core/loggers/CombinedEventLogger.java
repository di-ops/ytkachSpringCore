package ytkach.spring.core.loggers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ytkach.spring.core.beans.Event;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Component
public class CombinedEventLogger implements EventLogger{

    @Resource(name = "combinedLoggers")
    private Collection<EventLogger> eventLoggers;

    @Override
    public void logEvent(Event event){
        for (EventLogger logger: eventLoggers) {
            logger.logEvent(event);
        }
    }
}
