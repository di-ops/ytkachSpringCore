package ytkach.spring.core.loggers;

import org.apache.commons.io.FileUtils;
import ytkach.spring.core.beans.Event;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String filename;
    private File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }



    @Override
    public void logEvent(Event event) throws IOException {
        FileUtils.writeStringToFile(file, event.toString() + "\n", true);
    }

    private void init(){
        this.file = new File(filename);
        if(file.exists() && !file.canWrite()){
            throw new IllegalArgumentException("Can't write to file" + filename);
        }
        else if (!file.exists()){
            try {
                file.createNewFile();
            }
            catch (Exception e){
                throw new IllegalArgumentException(("Can't create new file" + e));
            }

        }
    }
}
