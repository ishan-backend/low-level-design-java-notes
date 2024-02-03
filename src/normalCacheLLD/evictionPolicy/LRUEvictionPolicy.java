package normalCacheLLD.evictionPolicy;

import normalCacheLLD.doublyLinkedList.DLL;
import normalCacheLLD.doublyLinkedList.DLLNode;
import normalCacheLLD.exceptions.InvalidElementException;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements IEvictionPolicy<Key> { // LRUEvictionPolicy needs to adjust elements in DLL and remove any element
    private DLL<Key> dll; // original dll datastore
    private Map<Key, DLLNode<Key>> dllNodeLocationMap;

    public LRUEvictionPolicy() {
        dll = new DLL<>();
        dllNodeLocationMap = new HashMap<>();
    }

    @Override
    public void markLatestKeyAccessed(Key k) {
        if(dllNodeLocationMap.containsKey(k)) {
            dll.detachNode(dllNodeLocationMap.get(k));
            dll.addNodeAtLast(dllNodeLocationMap.get(k));
        } else {
            DLLNode<Key> newNode = dll.addElementAtLast(k); // while making new node in DLL, return Node and add it to dllNodeLocationMap
            dllNodeLocationMap.put(k, newNode);
        }
    }

    @Override
    public Key evictKey() {
        DLLNode<Key> firstNode = dll.getFirstNode();
        if(firstNode == null) // handles if DLL is empty
            return null;

        dll.detachNode(firstNode);
        dllNodeLocationMap.remove(firstNode.getElement());
        return firstNode.getElement();
    }
}
