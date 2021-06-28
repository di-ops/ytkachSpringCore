package ytkach.spring.core.loggers;

import ytkach.spring.core.beans.Event;

import java.io.IOException;

public interface EventLogger {
    void logEvent(Event event) throws IOException;
}
