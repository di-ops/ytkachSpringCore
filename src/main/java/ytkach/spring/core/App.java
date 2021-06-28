package ytkach.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ytkach.spring.core.beans.Client;
import ytkach.spring.core.beans.Event;
import ytkach.spring.core.loggers.EventLogger;

import java.io.IOException;

public class App {
    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void LogEvent (String msg, Event event) throws IOException {
        String message = msg.replaceAll((client.getId())+"",client.getName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring XML.xml");
        App app =(App) applicationContext.getBean("app");
        Event event = applicationContext.getBean(Event.class);
        Thread.sleep(1000);
        app.LogEvent("some event for user 1", event);
        event = applicationContext.getBean(Event.class);
        app.LogEvent("some event for user 2", event);

    }

}
