package ytkach.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ytkach.spring.core.beans.Client;
import ytkach.spring.core.beans.Event;
import ytkach.spring.core.beans.EventType;
import ytkach.spring.core.loggers.EventLogger;

import java.io.IOException;
import java.util.Map;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map <EventType, EventLogger> loggerMap;

    public static void main(String[] args) throws InterruptedException, IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring XML.xml");
        App app =(App) applicationContext.getBean("app");
        Event event = applicationContext.getBean(Event.class);
        Thread.sleep(1000);
        app.logEvent("some event for user 1", event, EventType.INFO);
        event = applicationContext.getBean(Event.class);
        app.logEvent("some event for user 2", event, EventType.ERROR);
        Thread.sleep(1000);
        event = applicationContext.getBean(Event.class);
        app.logEvent("some event for user 3", event, null);
        Thread.sleep(1000);
        event = applicationContext.getBean(Event.class);
        app.logEvent("some event for user 4", event, EventType.INFO);

    }

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggerMap) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggerMap = loggerMap;
    }
    public void logEvent(String msg, Event event) throws IOException {
        String message = msg.replaceAll((client.getId())+"",client.getName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

    private void logEvent(String msg, Event event, EventType eventType) throws IOException {
        String message = msg.replaceAll((client.getId())+"",client.getName());
        event.setMsg(message);

        EventLogger logger = loggerMap.get(eventType);
        if (logger ==null){
            logger = eventLogger;
        }
        logger.logEvent(event);

    }

}
