**Requirements**:
LLD for a cache system. Support 2 operations:
* Put: allows user to put a value against a key in cache
* Get: allows user to get previously saved value in key
* Eviction: cache should support eviction of few keys in case memory is full and we try to add new key value.

Code should have good OOPS design.
https://github.com/anomaly2104/cache-low-level-system-design

```text
Cache<Key, Value>: This is the class signature, where Cache is the name of the class, and <Key, Value> are the type parameters (generics). The Key and Value inside angle brackets (<>) are placeholders for the actual types that will be specified when an instance of the Cache class is created.

Key: It represents the type of the key used to access or retrieve values from the cache.
Value: It represents the type of the values stored in the cache.

example to use generic class:
 
Cache<String, Integer> stringIntegerCache = new Cache<>();
Cache<Integer, String> integerStringCache = new Cache<>();

```