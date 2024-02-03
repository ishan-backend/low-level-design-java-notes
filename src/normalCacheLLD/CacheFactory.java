package normalCacheLLD;

import normalCacheLLD.evictionPolicy.LRUEvictionPolicy;
import normalCacheLLD.storage.HashMapStorage;

public class CacheFactory<Key, Value> {
    public Cache<Key, Value> getHashMapCacheWithLRUEviction(final int capacity) {
        return new Cache<>(new LRUEvictionPolicy<>(), new HashMapStorage<>(capacity));
    }
}
