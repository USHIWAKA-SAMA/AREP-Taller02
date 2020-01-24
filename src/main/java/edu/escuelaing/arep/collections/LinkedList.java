package edu.escuelaing.arep.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Implementation of a linked list using nodes
 *
 * @param <T> The object type which th linked list will contain
 */
public class LinkedList<T> implements List<T> {

    /**
     * Head node of the linked list
     */
    private Node<T> head;

    /**
     * Tail node of the linked list
     */
    private Node<T> tail;

    /**
     * Size of the linked list, number of elements
     */
    private int size;

    /**
     * Constructs an empty linked list
     */
    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    /**
     * Adds the element to the end of the list
     *
     * @param data The element to be added
     * @return true
     */
    public boolean add(T data) {
        if (isEmpty()) {
            head = tail = new Node<T>(data, null);
        } else {
            Node<T> addedNode = new Node<T>(data, null);
            tail.setNextNode(addedNode);
            tail = addedNode;
        }
        size++;
        return true;
    }

    /**
     * Returns the element at the specified position of the linked list.
     *
     * @param i Index of the element to get
     * @return The element at the specified position
     * @throws IndexOutOfBoundsException if the index is negative or equal or greater than the linked list's size
     */
    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Iterator<T> iterator = iterator();
        while (i-- > 0) {
            iterator.next();
        }
        return iterator.next();
    }

    /**
     * Returns the number of elements
     *
     * @return number of elements
     */
    public int size() {
        return size;
    }

    /**
     * Tells if the linked list is empty
     *
     * @return True if it is not empty, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the linked list elements.
     *
     * @return The iterator of the linked list
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> currentNode = head;

            public boolean hasNext() {
                return currentNode != null;
            }

            public T next() {
                T data = currentNode.getData();
                currentNode = currentNode.getNextNode();
                return data;
            }
        };
    }

    /**
     * Adds all of the elements of a given collection
     *
     * @param collection The collection from which the elements will be added
     * @return true
     */
    public boolean addAll(Collection<? extends T> collection) {
        for (T elem : collection) {
            add(elem);
        }
        return true;
    }

    /**
     * Removes an element at the given index
     *
     * @param i Index of the element to remove
     * @return The object removed
     */
    public T remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> removeNode = null;
        if (i == 0) {
            removeNode = head;
            head = head.getNextNode();
        } else {
            Node<T> currentNode = head;
            for (int j = 0; j < i - 1; j++) {
                currentNode = currentNode.getNextNode();
            }
            removeNode = currentNode.getNextNode();
            currentNode.setNextNode(removeNode.getNextNode());
        }
        size--;
        return removeNode.getData();
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void clear() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public T set(int i, T t) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void add(int i, T t) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public ListIterator<T> listIterator(int i) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public List<T> subList(int i, int i1) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public <T1> T1[] toArray(T1[] t1s) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
