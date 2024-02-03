package normalCacheLLD;

import normalCacheLLD.evictionPolicy.IEvictionPolicy;
import normalCacheLLD.exceptions.NotFoundException;
import normalCacheLLD.exceptions.StorageFullException;
import normalCacheLLD.storage.IStorage;

public class Cache<Key, Value> {
    private final IEvictionPolicy<Key> evictionPolicy;
    private final IStorage<Key, Value> storage;

    public Cache(IEvictionPolicy<Key> evictionPolicy, IStorage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            storage.add(key, value);
            this.evictionPolicy.markLatestKeyAccessed(key);
        } catch (StorageFullException storageFullException) {
            System.out.println("Got storage full, will try to evict ....");
            Key keyToRemove = evictionPolicy.evictKey();
            if(keyToRemove == null) {
                throw new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }

            this.storage.remove(key);
            System.out.println("Creating space by evicting item..." + keyToRemove + " retrying put call again...");
            put(key, value);
        }
    }

    public Value get(Key key) {
        try {
            Value value = storage.get(key);
            this.evictionPolicy.markLatestKeyAccessed(key);
            return value;
        } catch (NotFoundException exception) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }
}
