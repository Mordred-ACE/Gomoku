
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Panel extends JPanel{
	private static final int tilesX = 19;  //tiles on the board
	private static final int tilesY = 19;
	
	private static final int sizeX = tilesX*50; //size of the board
	private static final int sizeY = tilesY*50;
	private static boolean turn = true;  
	private static boolean gameWon = false;
	private Board boardContent; //encapsulates the board
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Panel panel = new Panel();   //create window
		JFrame window = new JFrame("Noughts and Crosses");

		window.setContentPane(panel);
		//window.setBackground(Color.WHITE);
		window.setSize(sizeX + 120,sizeY + 30);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
	}
	
	public Panel() {
		
		setLayout(null);    //constructor of the class, creates and adds content to the window
		boardContent = new Board(tilesX,tilesY,sizeX,sizeY);
		boardContent.addMouseListener( new CheckMove() );
		add(boardContent);
		boardContent.setBounds(0, 0, boardContent.sizeX, boardContent.sizeY);
		JButton restartButton = new JButton("New Game");
		restartButton.setFont(new Font("Arial", Font.PLAIN, 14));
		add(restartButton);
		restartButton.setBounds(sizeX,10,120,30);
		restartButton.addActionListener(new ActionListener() {
			
			public void actionPerformed( ActionEvent evt ) { //listener for "New Game" button, resets board
				
				gameWon = false; turn = true; 
				boardContent.setBoard();
				repaint();
			}
		});

	}
	
	public int checkTiles(Direction d, int xtile, int ytile, State[][] board, State Tile){ 
		
		//recursively checks how many non-BLANK, adjacent tiles are the same and returns this 
		
		int newXTile = xtile, newYTile = ytile;											   	
		int[] coordinates = new int[2];
		
		try{
			if (board[newYTile][newXTile].equals(Tile)){
				coordinates = d.change(newXTile, newYTile);
				newXTile = coordinates[0];
				newYTile = coordinates[1];
				
				return 1 + checkTiles(d,  newXTile, newYTile, board, Tile);
			}
			else{
				return 0;
			}
		}
		catch ( IndexOutOfBoundsException e ) {
			return 0;
		}
	}
	
	public boolean checkWin(State[][] board, int xtile, int ytile){
		//returns True if the method above returns 5 or more 
		State tile = board[ytile][xtile];
		
		
		for (int i = 0; i < 8; i++){
			Direction direction = new Direction(i);
			
			
			if (checkTiles(direction, xtile, ytile, board, tile ) >= 5){
				return true;
			}
			else{
				continue;
			}
				
		}
		return false;
		
	}
	
	private class CheckMove implements MouseListener{
		
		
		public void mousePressed(MouseEvent event) {
			int x = event.getX(), y = event.getY(); 
			int xtile = Math.floorDiv(x, (boardContent.sizeX)/tilesX);
			int ytile = Math.floorDiv(y, (boardContent.sizeY)/tilesY);
			
			if (!gameWon){
				if (turn && boardContent.getBoard(xtile, ytile) == State.BLANK){
					boardContent.setBoard(State.NOUGHT,xtile, ytile);
					turn = !turn;
				
					repaint();
				}
				else if (!turn && boardContent.getBoard(xtile, ytile) == State.BLANK){
					boardContent.setBoard(State.CROSS,xtile, ytile);
					turn = !turn;
					repaint();
				}
				gameWon = checkWin(boardContent.getBoard(), xtile, ytile);
				
			}
			
		}
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}	
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
}
