public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;
    public void LogEvent (String msg){
        String message = msg.replaceAll((client.getId())+"",client.getName());
        eventLogger.LogEvent(message);
    }

    public static void main(String[] args) {
        App app = new App();
        app.client = new Client(1, "John");
        app.eventLogger = new ConsoleEventLogger();
        app.LogEvent("some event for user 1");
    }

}
