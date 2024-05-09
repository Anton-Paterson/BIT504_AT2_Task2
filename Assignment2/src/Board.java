import java.awt.*;


public class Board {
	// grid line width
	public static final int GRID_WIDTH = 8;
	// grid line half width
	public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2;
	
	
	//2D array of ROWS-by-COLS Cell instances
	Cell [][] cells;
	
	/** Constructor to create the game board */
	public Board() {
	
	 //TODO: initialise the cells array using ROWS and COLS constants 
	Cell [][] cells	= new Cell	[GameMain.ROWS][GameMain.COLS];
	cells = this.cells;
	
	cells[0][0] = new Cell(1,1);
	//cells[0][0].content = Player.Empty;
	cells[0][1] = new Cell(1,1);
	cells[0][2] = new Cell(1,1);
	cells[1][0] = new Cell(1,1);
	cells[1][1] = new Cell(1,1);
	cells[1][2] = new Cell(1,1);
	cells[2][0] = new Cell(1,1);
	cells[2][1] = new Cell(1,1);
	cells[2][2] = new Cell(1,1);
	
	for (int row = 0; row < GameMain.ROWS; ++row) {
		for (int col = 0; col < GameMain.COLS; ++col) {
			cells[row][col].content =  Player.Empty;;
		}
	}
	
			
	/*for (int row = 0; row < GameMain.ROWS; ++row) {
			for (int col = 0; col < GameMain.COLS; ++col) {
				cells[row][col] = new Cell(row, col);
			}
		}
	*/
	}
	

	 /** Return true if it is a draw (i.e., no more EMPTY cells) */ 
	public boolean isDraw() {
		 
		// TODO: Check whether the game has ended in a draw. 
		// Hint: Use a nested loop (see the constructor for an example). Check whether any of the cells content in the board grid are Player.Empty. If they are, it is not a draw.
		// Hint: Return false if it is not a draw, return true if there are no empty positions left
		
		//for (int row = 0; row <GameMain.ROWS; ++row) {
		//	if 
		//}
		return false; 
	}
	
	/** Return true if the current player "thePlayer" has won after making their move  */
	public boolean hasWon(Player thePlayer, int playerRow, int playerCol) {
		 // check if player has 3-in-that-row
		if(cells[playerRow][0].content == thePlayer && cells[playerRow][1].content == thePlayer && cells[playerRow][2].content == thePlayer )
			return true; 
		
		 // TODO: Check if the player has 3 in the playerCol.
		if(cells[0][playerCol].content == thePlayer && cells[1][playerCol].content == thePlayer && cells[2][playerCol].content == thePlayer )
			return true; 
		
		 // Hint: Use the row code above as a starting point, remember that it goes cells[row][column] 
		
		
		
		 // 3-in-the-diagonal (Top left to bottom right)
		if( cells[0][0].content == thePlayer && cells[1][1].content == thePlayer && cells[2][2].content == thePlayer)
			return true;
		 
		
		// TODO: Check the diagonal in the other direction (Top Right to bottom Left)
		if( cells[0][2].content == thePlayer && cells[1][1].content == thePlayer && cells[2][0].content == thePlayer)
			return true;

		
		//no winner, keep playing
		return false;
	}
	
		
	/**
	 * Draws the grid (rows then columns) using constant sizes, then call on the
	 * Cells to paint themselves into the grid
	 */
	public void paint(Graphics g) {
		//draw the grid
		g.setColor(Color.gray);
		for (int row = 1; row < GameMain.ROWS; ++row) {          
			g.fillRoundRect(0, GameMain.CELL_SIZE * row - GRID_WIDHT_HALF,                
					GameMain.CANVAS_WIDTH - 1, GRID_WIDTH,                
					GRID_WIDTH, GRID_WIDTH);       
			}
		for (int col = 1; col < GameMain.COLS; ++col) {          
			g.fillRoundRect(GameMain.CELL_SIZE * col - GRID_WIDHT_HALF, 0,                
					GRID_WIDTH, GameMain.CANVAS_HEIGHT - 1,                
					GRID_WIDTH, GRID_WIDTH);
		}
		
		//Draw the cells
		for (int row = 0; row < GameMain.ROWS; ++row) {          
			for (int col = 0; col < GameMain.COLS; ++col) {  
				cells[row][col].paint(g);
			}
		}
	}
		
}
