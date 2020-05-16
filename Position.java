/**
 * This is the Position Class, that keeps a track of the position row and col of the game board.
 * @author rishidhir
 *
 */
public class Position {
	
	private int positionRow; //declaring the instance variable to keep track of the row
	private int positionCol; //declaring the instance variable to keep track of the col

	/**
	 * This is the class constructor, that sets both instance variables equal to the parameters passed. 
	 * @param row
	 * @param col
	 */
	public Position (int row, int col) {
		positionRow = row;
		positionCol = col; 
	}
	
	/**
	 * Getter method
	 * @return positionRow
	 */
	
	public int getRow() {
		return positionRow;
	}
	/**
	 * Getter method
	 * @return positionCol
	 */
	
	public int getCol() {
		return positionCol;
	}
	
	/**
	 * Setter method
	 * @param newRow
	 */
	public void setRow(int newRow) {
		positionRow = newRow;
	}
	
	/**
	 * Setter method
	 * @param newCol
	 */
	public void setCol(int newCol) {
		positionCol = newCol;
	}
	
	/**
	 * This method checks the positionRow and positionCol with another object's positionRow and poisitionCol
	 * @param otherPosition
	 * @return
	 */
	public boolean equals(Position otherPosition) {
		if (positionRow == otherPosition.positionRow && positionCol == otherPosition.positionCol) {
			return true;
		}
		else return false;
	}
}