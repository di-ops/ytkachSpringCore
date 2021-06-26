package ytkach.spring.core.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ytkach.spring.core.EventLogger;

public class App {
    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void LogEvent (String msg){
        String message = msg.replaceAll((client.getId())+"",client.getName());
        eventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring XML.xml");
        App app =(App) applicationContext.getBean("app");
        app.LogEvent("some event for user 1");
        app.LogEvent("some event for user 2");
    }

}
