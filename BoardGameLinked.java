/**
 * This class represents the game board in which the snake moves around and eats apples. 
 * @author rishidhir
 *
 */
public class BoardGameLinked {
	
	private int boardLength; //Declaring the instance variable boardLength, that stores the number of columns in the board
	private int boardWidth; //Declaring the instance variable boardWdith, that stores the number of rows in the board
	private SnakeLinked theSnake; //Declaring the instance variable theSnake, that represents an object of the class snakeLinked
	private DoubleList<String>[]board; //Represents an array of doubly linked lists
	
	/**
	 * This is the constructor of the class that sets up the game board
	 * @param boardFile
	 */
	public BoardGameLinked(String boardFile) {
		MyFileReader in = new MyFileReader(boardFile);
		int value = in.readInt(); //Reading the first number and not using it
		value = in.readInt();  //Reading the second number and not using it
		
		boardLength = in.readInt();
		boardWidth = in.readInt();
		
		int first = in.readInt();
		int second = in.readInt();
		
		theSnake = new SnakeLinked(first,second); //Creating a snake object and using first and second as parameters for the snakeLinked object
		
		board = new DoubleList[boardWidth];
		
		//Using nested loops to initialize and set the entries of the game board as "empty"
		for(int i = 0; i < boardWidth; i++) {
			for(int col = 0; col < boardLength; col++) {
				if (board[i] == null)
					board[i] = new DoubleList<String>();
				board[i].addData(col, "empty");
			}
		}

		//Using a while loop to go through the file to read each element and store information of the game board
		while (in.endOfFile() == false) {
			int num1 = in.readInt();
			int num2 = in.readInt();
			String gameObject = in.readString();
			board[num1].setData(num2, gameObject);
		}	
	}
	
	/**
	 * Getter method that returns the information stored in game
	 * @param row
	 * @param col
	 * @return the information stored at a particular row and col
	 * @throws InvalidPositionException
	 */
	public String getObject(int row, int col) throws InvalidPositionException {
		//Checking to see if an exception may arise
		if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength)
			throw new InvalidPositionException("Invalid index position");
		return board[row].getData(col);
	}
	
	/**
	 * Setter method that stores information at a particular row and col in the board
	 * @param row
	 * @param col
	 * @param newObject
	 * @throws InvalidPositionException
	 */
	public void setObject(int row, int col, String newObject) throws InvalidPositionException {
		if (row < 0 || col < 0 || row >= boardWidth || col >= boardLength)
			throw new InvalidPositionException("Invalid index positon");
		board[row].setData(col, newObject);
	}
	
	/**
	 * Getter method
	 * @return
	 */
	public SnakeLinked getSnakeLinked() {
		return theSnake;
	}
	
	/**
	 * Setter method
	 * @param newSnake
	 */
	public void setSnake(SnakeLinked newSnake) {
		theSnake = newSnake;
	}
	
	/**
	 * Getter method
	 * @return boardLength
	 */
	public int getLength() {
		return boardLength;
	}
	
	/**
	 * Getter method
	 * @return boardWidth
	 */
	public int getWidth() {
		return boardWidth;
	}

}
