import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
public class Board extends JPanel{
	
	public int sizeX, sizeY;
	private int rows, columns; //number of tiles 
	private int width, height; //size of the tiles
	
	private State [][] board; //represents the board
	public Board(int rows, int columns, int x, int y){
		

		this.rows = rows; this.columns = columns;
		sizeX = x; sizeY = y;
		board = new State[rows][columns];
		width = (int)(x / columns);
		height = (int)(y / rows);
		
		//setMinimumSize(new Dimension(sizeX, sizeY));
		//setMaximumSize(new Dimension(sizeX, sizeY));
		System.out.println(sizeX + " " + sizeY);
		System.out.println(width + " " + height);
		setBackground(Color.BLACK);
		for (int row = 0; row < rows; row++){
			for (int column = 0; column < columns; column++){
				board[row][column] = State.BLANK; 
			}
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2;
		g2 = (Graphics2D)g;
		g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
		g2.setStroke( new BasicStroke(10) );
		

		
		g2.setColor(Color.WHITE);
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++){
				
				if ( (i + j) % 2 == 0 ){
					g2.fillRect(j*width, i*height, height, width);
					if (board[i][j] == State.CROSS){
						g2.setColor(Color.ORANGE);
						g2.drawLine(j*width+5, i*height+5, j*width + width-5, i*width + width-5);
						g2.drawLine(j*width+5, i*height+height-5, j*width +width-5, i*height+5);						
					}
					else if (board[i][j] == State.NOUGHT){
						g2.setColor(Color.CYAN);
						Ellipse2D.Double shape = new Ellipse2D.Double(j*width,i*height,height,width);
						g2.fill(shape);
						
					}				
				}
				else{	
					g2.setColor(Color.ORANGE);
					if (board[i][j] == State.CROSS){	
						g2.drawLine(j*width+5, i*height+5, j*width + width-5, i*width + width-5);
						g2.drawLine(j*width+5, i*height+height-5, j*width +width-5, i*height+5);						
					}
					else if (board[i][j] == State.NOUGHT){
						g2.setColor(Color.CYAN);
						Ellipse2D.Double shape = new Ellipse2D.Double(j*width,i*height,height,width);
						g2.fill(shape);
					}
				}					
				g.setColor(Color.white);				
			}
		}				
	}

	public State getBoard(int x, int y){
		return board[y][x];
	}
	public State[][] getBoard(){
		return board;
	}
	public void setBoard(State state, int x, int y){
		board[y][x] = state;
	}
	public void setBoard(){
		for (int row = 0; row < rows; row++){
			for (int column = 0; column < columns; column++){
				board[row][column] = State.BLANK; 
			}
		}
	}

}
