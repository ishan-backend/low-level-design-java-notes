package normalCacheLLD.storage;

import normalCacheLLD.exceptions.NotFoundException;
import normalCacheLLD.exceptions.StorageFullException;

public interface IStorage<Key, Value> {
        void add(Key key, Value value) throws StorageFullException;

        void remove(Key key) throws NotFoundException;

        Value get(Key key) throws NotFoundException;
}
