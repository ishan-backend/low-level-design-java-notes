package logger2.pubsub;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOnlySubscriber implements ISubscriber{
    private final BufferedWriter bufferedWriter;
    public FileOnlySubscriber() throws IOException {
        this.bufferedWriter = new BufferedWriter(new FileWriter("log.txt", true));
    }

    @Override
    public void send(String message) {
        try {
            this.bufferedWriter.write(message);
            this.bufferedWriter.newLine();
            this.bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("could not write to file");
        }
    }

    // Close the file writer when finished
    public void close() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not close file writer");
        }
    }
}
