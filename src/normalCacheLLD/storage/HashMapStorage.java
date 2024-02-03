package normalCacheLLD.storage;

import normalCacheLLD.exceptions.NotFoundException;
import normalCacheLLD.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key, Value> implements IStorage<Key, Value>{
    Map<Key, Value> kv;
    private final Integer cap;

    public HashMapStorage(Integer cap) {
        kv = new HashMap<>();
        this.cap = cap;
    }

    @Override
    public void add(Key k, Value v) throws StorageFullException {
        if(isStorageFull()) {
            throw new StorageFullException("Capacity Full.....");
        }
        kv.put(k, v);
    }

    @Override
    public void remove(Key k) throws NotFoundException {
        if(!kv.containsKey(k)) {
            throw new NotFoundException(k + "doesn't exist in cache.");
        }
        kv.remove(k);
    }

    @Override
    public Value get(Key k) throws NotFoundException {
        if(!kv.containsKey(k)) {
            throw new NotFoundException(k + "doesn't exist in cache.");
        }
        return kv.get(k);
    }

    private boolean isStorageFull() {
        return kv.size() == cap;
    }
}
