package normalCacheLLD.exceptions;

public class StorageFullException extends RuntimeException {
    public StorageFullException(String message) {
        super(message);
    }
}
