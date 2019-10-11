import java.io.Serializable;
import java.util.Iterator;

public class GenericLinkedList<T> implements Iterable<T>, Serializable {

    private class L_Node<T> implements Serializable {
        private T value;
        protected L_Node<T> next;

        public L_Node(T value) {
            this.value = value;
        }
    }

    private L_Node<T> head = null, tail = null;
    private int size = 0;

    public void insert(T t) {
        L_Node<T> node = new L_Node<T>(t);
        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int indexOf(T t) {
        L_Node<T> node = head;
        int i = 0;
        while (node != null && node.value != t) {
            node = node.next;
            i++;
        }
        return i;
    }

    public void remove(int index){
        size --;
        L_Node<T> node = head;
        for (int i = 0; i < index-1; i++)
            node = node.next;
            if (node.next == null) {
                head = null;
                tail = null;
            }
            if (node == head)
                head = head.next;
            if (node.next == tail) {
                tail = node;
                tail.next = null;
            } else if (node != head && node.next != tail)
                node.next = node.next.next;
    }

    public int getSize() {
        return size;
    }

    public T[] toArray() {
        T arr[] = (T[]) new Object[size];
        L_Node<T> node = head;
        for (int i = 0; i < size; i++) {
            arr[i] = node.value;
            node = node.next;
        }
        return arr;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        L_Node<T> node = head;
        for (int i = 0; i < size; i++) {
            str.append(node.value);
            node = node.next;
        }
        return str.toString();
    }

    private class InnerIterator implements Iterator<T> {
        private L_Node<T> node = head;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T nxt = node.value;
                node = node.next;
                return nxt;
            }
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }
}

