package ytkach.spring.core.beans;

import org.springframework.format.datetime.DateFormatter;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {

    private int id = new Random().nextInt(1000);

    private String msg;

    private Date date;

    private DateFormat dateFormat;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
