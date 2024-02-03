package normalCacheLLD.evictionPolicy;

// IEvictionPolicy @param <Key> : type of Key
public interface IEvictionPolicy<Key> {
    void markLatestKeyAccessed(Key key);
    Key evictKey();
}
