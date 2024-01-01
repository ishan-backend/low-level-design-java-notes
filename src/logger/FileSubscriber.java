package logger;

import java.io.FileWriter;
import java.io.IOException;

public class FileSubscriber implements ISubscriber {
    private final FileWriter fileWriter;

    public FileSubscriber(String filePath) throws IOException { // throw IO exception
        this.fileWriter = new FileWriter(filePath); // takes file path, creates file writer
    }

    @Override
    public void update(String message) {
        try {
            this.fileWriter.write(message + "\n"); // try writing message, use try catch to catch exception or delegate it to parent
            this.fileWriter.flush();
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage()); // throw custom exception
        }
    }
}
