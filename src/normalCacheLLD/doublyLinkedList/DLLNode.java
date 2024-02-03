package normalCacheLLD.doublyLinkedList;

// @param <E> Type of element to be inserted into the list.
public class DLLNode<E>{
    DLLNode<E> prev;
    DLLNode<E> next;
    E element;

    public DLLNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    public DLLNode<E> getNext() {
        return next;
    }

    public DLLNode<E> getPrev() {
        return prev;
    }

    public E getElement() {
        return element;
    }
}
