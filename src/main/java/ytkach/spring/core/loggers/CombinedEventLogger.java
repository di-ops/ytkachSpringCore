package ytkach.spring.core.loggers;

import ytkach.spring.core.beans.Event;

import java.io.IOException;
import java.util.List;

public class CombinedEventLogger implements EventLogger{
    public CombinedEventLogger(List<EventLogger> eventLoggers) {
        this.eventLoggers = eventLoggers;
    }

    private List<EventLogger> eventLoggers;
    @Override
    public void logEvent(Event event) throws IOException {
        for (EventLogger logger: eventLoggers) {
            logger.logEvent(event);
        }
    }
}
