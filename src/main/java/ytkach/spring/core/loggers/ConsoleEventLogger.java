package ytkach.spring.core.loggers;
import ytkach.spring.core.beans.Event;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event){
        System.out.println(event);
    }
}
