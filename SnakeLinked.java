/**
 * This class represents the snake, and it stores the information as the snake moves around the game board
 * @author rishidhir
 *
 */
public class SnakeLinked {
	
	//Declaring instance variables
	private int snakeLength;
	private DoubleList<Position> snakeBody; //Stores the tiles of the game board occupied by the snake in a doubly linked list 
	
	/**
	 * This is the constructor for the SnakeLinked class that initializes the SnakeLinked object 
	 * @param row
	 * @param col
	 */
	public SnakeLinked(int row, int col) {
		snakeLength = 1;
		snakeBody = new DoubleList<Position>();
		Position initial = new Position(row, col);
		snakeBody.addData(0, initial);		
	}
	
	/**
	 * Getter method
	 * @return snakeLength
	 */
	public int getLength() {
		return snakeLength;
	}
	
	/**
	 * Getter method 
	 * @param index
	 * @return the position of the snake at a particular index
	 */
	public Position getPosition(int index) {
		if (index < 0 || index >= snakeLength) return null;
		return snakeBody.getData(index);		
	}

	/**
	 * This method returns a boolean value based on if pos is in the doubly linked list that tracks the tiles a snake occupies
	 * @param pos
	 * @return 
	 */
	public boolean snakePosition(Position pos) {
		//Using a loop to go through the entire doubly linked list to check if pos exists in the doubly linked list
		for(int i = 0; i < snakeLength; i++) {
			if (snakeBody.getData(i).equals(pos)) return true;
		}
		return false;
	}
	
	/**
	 * This method returns the position of a snake after it moves in a particular direction 
	 * @param direction
	 * @return
	 */
	public Position newHeadPosition(String direction) {
		//Initializing two local variables to track changes based on direction
		int newHeadRow = snakeBody.getData(0).getRow();
		int newHeadCol = snakeBody.getData(0).getCol();
		
		//Changing the values of the variables based on the direction the snake goes 
		if (direction == "right") newHeadCol +=1;
		else if (direction == "left") newHeadCol -=1; 
		else if (direction == "up") newHeadRow -=1;
		else if (direction == "down") newHeadRow +=1;
		
		Position newPosition = new Position(newHeadRow, newHeadCol);
		return newPosition;
	}
	
	/**
	 * This method updates the doubly linked list based on the direction the snake moves to
	 * @param direction
	 */
	public void moveSnakeLinked(String direction) {
		//The case for when there is only one node in the list
		if (snakeLength==1) {
			snakeBody.setData(0, newHeadPosition(direction));
		}
		//The case for when there are multiple nodes in the list
		else {
			snakeBody.removeData(snakeLength-1);
			snakeBody.addData(0, newHeadPosition(direction));
		}
	}
	
	/**
	 * This method shrinks the snake by 1 and updates the count
	 */
	public void shrink() {
		snakeBody.removeData(snakeLength-1);
		snakeLength--;
	}
	
	/**
	 * This method grows the snake by 1 and updates the doubly linked list based on the direction the snake moves to
	 * @param direction
	 */
	public void grow(String direction) {
		snakeBody.addData(0, newHeadPosition(direction));
		snakeLength++;
	}
}	