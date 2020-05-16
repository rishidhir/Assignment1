/**
 * This class represents the nodes in a doubly linked list
 * @author rishidhir
 *
 * @param <T> 
 */
public class DoubleNode <T> {
	
	private DoubleNode<T> next; //Declaring the instance variable next, that has a reference to the next node in the list
	private DoubleNode<T> prev; //Declaring the instance variable prev, that has a reference to the previous node in the list
	private T data; //Declaring the instance variable data, that stores the information in a node
	
	/**
	 * This is the constructor for the class DoubleNode that creates an empty node with all instance variables set to null 
	 */
	public DoubleNode() {
		next = null;
		prev = null;
		data = null;
	}
	
	/**
	 * This method created a node which stores the data given in the instance variable, and sets next and prev to null
	 * @param newData added to a new node
	 */
	public DoubleNode(T newData) {
		next = null;
		prev = null;
		data = newData;
	}
	
	/**
	 * This method returns the reference to the next node in the list 
	 * @return next
	 */
	public DoubleNode<T> getNext() {
		return next;
	}
	
	/**
	 * This method returns the reference to the previous node in the list
	 * @return previous
	 */
	public DoubleNode<T> getPrev() {
		return prev;
	}
	
	/**
	 * This method returns the data in a node
	 * @return data
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * This method sets the reference for the next node in the list
	 * @param nextNode
	 */
	public void setNext(DoubleNode<T> nextNode) {
		next = nextNode;
	}
	
	/**
	 * This method sets the reference for the previous node in the list
	 * @param prevNode
	 */
	public void setPrev(DoubleNode<T> prevNode) {
		prev = prevNode;
	}
	
	/**
	 * Setter method to set data in a node
	 * @param newData
	 */
	public void setData(T newData) {
		data = newData;
	}
}
