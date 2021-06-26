package ytkach.spring.core.beans;
import ytkach.spring.core.EventLogger;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event){
        System.out.println(event);
    }
}
