package ytkach.spring.core.beans;

public class Client {
    private int id;
    private String name;
    private String greet;

    public void setGreeting(String greet) {
        this.greet = greet;
    }

    public int getId() {
        return id;
    }

    public Client() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
