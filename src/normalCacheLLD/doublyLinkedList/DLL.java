package normalCacheLLD.doublyLinkedList;

import normalCacheLLD.doublyLinkedList.exceptions.NoSuchElementException;
import normalCacheLLD.exceptions.InvalidElementException;

public class DLL<E> {
    DLLNode<E> dummyHead, dummyTail;
    public DLL() {
        dummyHead = new DLLNode<>(null); // we can initialise it as null, since we will never use it
        dummyTail = new DLLNode<>(null);

        dummyTail.prev = dummyHead;
        dummyHead.next = dummyTail;
    }

    public void detachNode(DLLNode<E> node) { // removes node from DLL but it stays in memory
        if(node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public DLLNode<E> addElementAtLast(E element) {
        if(element == null)
            throw new InvalidElementException();

        DLLNode<E> newNode = new DLLNode<E>(element);
        addNodeAtLast(newNode);
        return newNode;
    }

    public void addNodeAtLast(DLLNode<E> node) {
        DLLNode<E> curLastNode = dummyTail.prev;
        curLastNode.next = node;
        node.next = dummyTail;
        dummyTail.prev = node;
        node.prev = curLastNode;
    }

    public boolean isDLLHavingElements() {
        return dummyHead.next != dummyTail;
    }

    public DLLNode<E> getFirstNode() throws NoSuchElementException {
        if(!isDLLHavingElements())
            throw new NoSuchElementException();
        return dummyHead.next;
    }

    public DLLNode<E> getLastNode() throws NoSuchElementException{
        if(!isDLLHavingElements())
            throw new NoSuchElementException();
        return dummyTail.prev;
    }
}
