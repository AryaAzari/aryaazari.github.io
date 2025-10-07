import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    private class Node {
        T item;
        Node next;
        Node prev;

        Node(T item) {
            this.item = item;
        }

        Node() {
            this.item = null;
        }
    }

    Node sentinel;
    int size;

    public LinkedListDeque61B() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public static void main(String[] args) {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(0);   // [0]
        lld.addLast(1);   // [0, 1]
        lld.addFirst(-1); // [-1, 0, 1]
    }

    /**
     * Add {@code x} to the front of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        Node newnode = new Node(x);
        newnode.next = sentinel.next;
        newnode.prev = sentinel;
        sentinel.next.prev = newnode;
        sentinel.next = newnode;
        size++;
    }

    /**
     * Add {@code x} to the back of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        Node newnode = new Node(x);
        newnode.next = sentinel;
        newnode.prev = sentinel.prev;
        sentinel.prev.next = newnode;
        sentinel.prev = newnode;
        size++;
    }

    /**
     * Returns a List copy of the deque. Does not alter the deque.
     *
     * @return a new list copy of the deque.
     */
    @Override
    public List<T> toList() {
        ArrayList<T> toListArray = new ArrayList<>();
        if (sentinel.next == sentinel) {
            return new ArrayList<>();
        }
        Node currNode = sentinel.next;
        for (int i = 0; i < size; i++) {
            toListArray.add(currNode.item);
            currNode = currNode.next;
        }
        return toListArray;
    }

    /**
     * Returns if the deque is empty. Does not alter the deque.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns the size of the deque. Does not alter the deque.
     *
     * @return the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Remove and return the element at the front of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T ans = sentinel.next.item;
        if (size == 1) {
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
        } else {
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
        }
        size--;
        return ans;
    }

    /**
     * Remove and return the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T ans = sentinel.prev.item;
        if (size == 1) {
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
        } else {
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
        }
        size--;
        return ans;
    }

    /**
     * The Deque61B abstract data type does not typically have a get method,
     * but we've included this extra operation to provide you with some
     * extra programming practice. Gets the element, iteratively. Returns
     * null if index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T get(int index) {
        if (index < 0) {
            return null;
        }
        Node currNode = sentinel.next;
        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode.item;
    }

    /**
     * This method technically shouldn't be in the interface, but it's here
     * to make testing nice. Gets an element, recursively. Returns null if
     * index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return (getRecursiveHelper(sentinel.next, index));
    }

    private T getRecursiveHelper(Node node, int index) {
        if (node == sentinel) {
            return null;
        }
        if (index == 0) {
            return node.item;
        }
        return (getRecursiveHelper(node.next, index - 1));
    }
}
