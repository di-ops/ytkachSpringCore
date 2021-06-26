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
        App app = new App(new Client(1,"John"), new ConsoleEventLogger());
        app.LogEvent("some event for user 1");
    }

}
