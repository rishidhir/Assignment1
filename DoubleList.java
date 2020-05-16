/**
 * This class represents a doubly linked list of nodes of the class DoubleNode
 * @author rishidhir
 *
 * @param <T>
 */
public class DoubleList<T> {
	
	private DoubleNode<T> head; //Declaring the instance variable head, that has a reference to the first node in the list
	private DoubleNode<T> rear; //Declaring the instance variable rear, that has a reference the the last node in the list
	private int numDataItems; //Declaring the instance variable numDataItems, that counts the number of nodes in the list
	
	/**
	 * This is the constructor of the class DoubleList which creates an empty list with zero nodes 
	 */
	public DoubleList() {
		head = null;
		rear = null;
		numDataItems = 0;
	}
	
	/**
	 * This method adds a new node to the list at a particular index, storing the information from newData
	 * @param index - the index at which the new node is added in the list
	 * @param newData - the data to be added in the node
	 * @throws InvalidPositionException exception which may be generated if the index is not valid 
	 */
	public void addData(int index, T newData) throws InvalidPositionException {
		//Checking the index to see if an exception may arise
		if (index < 0||index > numDataItems)
			throw new InvalidPositionException("Cannot add node to the list: Invalid index position");
		
		DoubleNode<T> newNode = new DoubleNode<T>(newData);
		
		//The case in which there are no nodes in the list
		if (head == null) {
			head = newNode;
			rear = newNode;
		}
		//The case in which the new node is added to the front of the list
		else if (index == 0) {
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		}
		//The case in which the new node is added to the rear of the list
		else if (index == numDataItems) {
			rear.setNext(newNode);
			newNode.setPrev(rear);
			rear = newNode;
		}
		//The case in which the index position is in between the list
		else {
			DoubleNode<T> current = head;
			//Using a loop to find the correct index place to insert the newNode
			for (int i = 1; i < index; i++)
				current = current.getNext();
			
			newNode.setNext(current.getNext());
			newNode.setPrev(current);
			current.setNext(newNode);
			(current.getNext()).setPrev(newNode);
		}
		numDataItems++;	//Increasing the count after adding a node
	}
	
	/**
	 * This method returns the node at a particular index position in the list
	 * @param index - the index of the node to be returned
	 * @return the node at the particular index position
	 * @throws InvalidPositionException exception which may be generated if the index position is not valid
	 */
	public DoubleNode<T> getNode(int index) throws InvalidPositionException {
		
		//Checking the index to see if an exception may arise
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Invalid index position");
		
		if (index == 0) return head; //returns head, which points to the first node in the list
		else if(index == numDataItems-1) return rear; //returns rear, which points to the last node in the list
		else {
			DoubleNode<T> current = head;
			//Using a loop to find the correct index place
			for (int i = 1; i < index; i++)
				current = current.getNext();
			return current.getNext();
		}
	}
	
	/**
	 * This method removes a node from the list at a particular index position
	 * @param index - the index at which the node has to be removed
	 * @throws InvalidPositionException exception which may arrise if the index position is invalid
	 */
	public void removeData(int index) throws InvalidPositionException {
		
		//Checking the index to see if an exception may arise
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Cannot remove data: Invalid index position");
		
		//The case when the first node has to be removed
		if (index == 0) {
			head = head.getNext();
		}
		//The case when the last node in the list has to be removed
		else if (index == numDataItems -1) {
			rear = rear.getPrev();
		}
		//The case when the index is between the first and last node
		else {
			DoubleNode<T> current = head;
			//Using a loop to find the correct index for the node to be removed
			for (int i = 1; i < index; i++)
				current = current.getNext();
			
			DoubleNode<T> target = current.getNext();
			current.setNext(target.getNext());
			(target.getNext()).setPrev(current);
		}
		numDataItems--; //Decreasing count after removing a node
	}
	
	/**
	 * This method returns the data in a node at a particular index position
	 * @param index - the index at which the data from the node needs to be retrieved
	 * @return the data in the node at the index
	 * @throws InvalidPositionException exception which may arise if the index position is invalid in the list
	 */
	public T getData(int index) throws InvalidPositionException {
		
		//Checking the index to see if an exception may arise
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Invalid index position");
		return getNode(index).getData(); //Using the method getNode to help return the data at a particular index
	}
	
	/**
	 * This method stores newData at the node in the position given by the index
	 * @param index - the index at which the node is in the list
	 * @param newData - the data that needs to be stored in the node
	 * @throws InvalidPositionException exception which may arise if the index position is invalid in the list
	 */
	public void setData(int index, T newData) throws InvalidPositionException {
		
		//Checking the index to see if an exception may arise
		if (index < 0 || index >= numDataItems)
			throw new InvalidPositionException("Invalid index position");
		
		DoubleNode<T> result = getNode(index);
		result.setData(newData);
	}
}