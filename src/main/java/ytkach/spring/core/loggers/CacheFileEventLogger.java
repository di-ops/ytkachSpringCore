package ytkach.spring.core.loggers;

import ytkach.spring.core.beans.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger{
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
    }

    @Override
    public void logEvent(Event event) throws IOException {
        cache.add(event);
        if (cacheSize == cache.size()){
            writeEventFromCache();
            cache.clear();
        }
    }

    private void writeEventFromCache() throws IOException {
        for (Event e: cache) {
            super.logEvent(e);
//            System.out.println(e);
        }
    }
    public void destroy() throws IOException {
        if (!cache.isEmpty()){
            writeEventFromCache();
        }
    }

}
