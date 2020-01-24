package edu.escuelaing.arep.collections;

/**
 * The node class for the linked list
 * @param <T> The object type which the node holds
 */
public class Node<T> {

    /**
     * The element the node holds
     */
    private T data;

    /**
     * Pointer to the next node
     */
    private Node<T> nextNode;

    /**
     * Constructs a node given the element which it will hold and the next node
     * @param data The element to hold
     * @param nextNode The next node to point to
     */
    public Node(T data, Node<T> nextNode){
        this.data = data;
        this.nextNode = nextNode;
    }

    /**
     * Gets the data which the node its holding
     * @return The data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the next node
     * @param nextNode The next node to point to
     */
    public void setNextNode(Node<T> nextNode){
        this.nextNode = nextNode;
    }

    /**
     * Gets the next node
     * @return The next node
     */
    public Node<T> getNextNode() {
        return nextNode;
    }
}
