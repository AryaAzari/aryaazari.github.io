import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ArrayDeque61B<T> implements Deque61B<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    private int increment(int i) {
        return (i + 1) % items.length;
    }
    private int decrement(int i) {
        return (i - 1 + items.length) % items.length;
    }

    public ArrayDeque61B() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }


    private void resizeHelper(int newSize) {
        T[] a = (T[]) new Object[newSize];

        int N = items.length;
        int first = increment(nextFirst);

        for (int i = 0; i < size; i++) {
            a[1 + i] = items[(first + i) % N];
        }

        items = a;
        nextFirst = 0;
        nextLast = size + 1;
    }
    private final int sixteen = 16;

    private void downsizeHelper() {
        int maxSize = items.length;
        if (maxSize >= sixteen && size <= maxSize / 4) {
            resizeHelper(maxSize / 2);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Deque61B<?> otherDeq) {
            if (this.size != otherDeq.size()) {
                return false;
            }
            for (int i = 0; i < this.size; i++) {
                T x = this.get(i);
                Object y = otherDeq.get(i);
                if (x == null && y == null) {
                    return false;
                } else if (!x.equals(y)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("[");
        int N = items.length;
        int index = (nextFirst + 1) % N;

        for (int i = 0; i < size; i++) {
            sBuilder.append(items[index]);
            if (i < size - 1) {
                sBuilder.append(", ");
            }
            index = (index + 1) % N;
        }

        sBuilder.append("]");

        return sBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;

        public ArrayDequeIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            int index = ((nextFirst + 1) + wizPos) % items.length;
            T returnItem = items[index];
            wizPos += 1;
            return returnItem;
        }
    }

    /**
     * Add {@code x} to the front of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        if (size == items.length - 1) {
            resizeHelper(items.length * 2);
        }
        items[nextFirst] = x;
        nextFirst = decrement(nextFirst);
        size++;
    }


    /**
     * Add {@code x} to the back of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        if (size == items.length - 1) {
            resizeHelper(items.length * 2);
        }
        items[nextLast] = x;
        nextLast = increment(nextLast);
        size++;
    }

    /**
     * Returns a List copy of the deque. Does not alter the deque.
     *
     * @return a new list copy of the deque.
     */
    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        if (size == 0) {
            return returnList;
        }
        for (int i = increment(nextFirst); i <= size; i++) {
            returnList.add(items[i]);
        }
        return returnList;
    }

    /**
     * Returns if the deque is empty. Does not alter the deque.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
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
        } else {
            downsizeHelper();
            nextFirst = increment(nextFirst);
            T a = items[nextFirst];
            items[nextFirst] = null;
            size--;
            return a;
        }
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
        } else {
            downsizeHelper();
            nextLast = decrement(nextLast);
            T a = items[nextLast];
            items[nextLast] = null;
            size--;
            return a;
        }
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
        if (index >= size || index < 0) {
            return null;
        }

        int first = increment(nextFirst);
        int idx = (first + index) % items.length;

        return items[idx];
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
        throw new UnsupportedOperationException("No need to implement getRecursive for ArrayDeque61B.");
    }
}
