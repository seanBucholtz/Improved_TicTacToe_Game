package TicTacToe;
import java.util.*;
import java.awt.*;

/**
 * The Tic-Tac-Toe model.
 * @author Sean Bucholtz
 * @version Project 5 - Tic-Tac-Toe
 */
public class TicTacToeModel extends Observable {
	
	private int size;
	private Grid grid;
	private String turn;
	private int[][] gameState;
	private ArrayList<Marker> markers;
	private int markerSize;
	private Color xColor;
	private Color oColor;
	
	public static final int DEFAULT_SIZE = 300;
	public static final float DEFAULT_THICKNESS = 5.0f;
	public static final Color DEFAULT_COLOR = Color.black;
	public static final double REDUCTION_RATIO = 0.80;
	
	/**
	 * The basic constructor.
	 */
	public TicTacToeModel() {
		size = DEFAULT_SIZE;
		turn = "x";
		markers = new ArrayList<Marker>();
		markerSize = DEFAULT_SIZE/3;
		gameState = new int[3][3];
		grid = new Grid(0,0,DEFAULT_SIZE);
		xColor = Marker.COLOR_BLUE;
		oColor = Marker.COLOR_RED;
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * The general constructor.
	 * @param size the size of the game
	 * @param color the color of the grid
	 * @param xColor the x marker color
	 * @param yColor the y marker color
	 */
	public TicTacToeModel(int size, Color color, Color xColor, Color yColor) {
		this();
		this.size = size;
		grid.setSize(size);
		grid.setColor(color);
		markerSize = size/3;
		this.xColor = xColor;
		this.oColor = yColor;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * The advanced constructor.
	 * @param size the size of the game
	 * @param color the color of the grid
	 * @param boardThickness the thickness of the grid
	 * @param xColor the x marker color
	 * @param yColor the y marker color
	 */
	public TicTacToeModel(int size, Color color, float boardThickness, Color xColor, Color yColor) {
		this(size, color, xColor, yColor);
		grid.setThickness(boardThickness);
	}
	
	/**
	 * Returns the size of the board.
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size of the board.
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * Reduces the size of a marker.
	 * @param m the marker
	 */
	public void reduceMarkerSize(Marker m) {
		int newSize = (int)(m.getSize()*REDUCTION_RATIO);
		m.setSize(newSize);
	}
	
	/**
	 * Centers the marker in its region.
	 * @param m the marker
	 */
	public void centerMarker(Marker m) {
		int sizeDelta = (int)(grid.getSize()/3) - m.getSize();
		int shift = (int)(sizeDelta/2);
		int newX = m.getX() + shift;
		int newY = m.getY() + shift;
		m.setX(newX);
		m.setY(newY);
	}

	/**
	 * Returns a grid object.
	 * @return the board
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * Switches the player turn.
	 */
	public void changeTurn() {
		if(turn.equals("x")) {
			turn = "o";
		}
		else if(turn.equals("o")) {
			turn = "x";
		}
	}
	
	/**
	 * Returns the current turn.
	 * @return the current turn
	 */
	public String getTurn() {
		return turn;
	}
	
	/**
	 * Tracks the progress of the game.
	 * @param row the row of the MD array
	 * @param col the column of the MD array
	 */
	public void updateGameState(int row, int col) {
		if(turn.equals("x")) {
			gameState[row][col] = 1;
			setChanged();
			notifyObservers();
			clearChanged();
		}
		else {
			gameState[row][col] = -1;
			setChanged();
			notifyObservers();
			clearChanged();
		}
	}
	
	/**
	 * Determines if a position on the grid is available.
	 * @param row the row of the MD array
	 * @param col the column of the MD array
	 * @return if position is available
	 */
	public boolean isAvailable(int row, int col) {
		if(gameState[row][col] == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns the game state.
	 * @return the current game state array
	 */
	public int[][] getGameState() {
		return gameState;
	}
	

	/**
	 * Returns the list of markers
	 * @return the markers
	 */
	public ArrayList<Marker> getMarkers() {
		return markers;
	}

	/**
	 * Adds a marker to the list.
	 * @param x the x location
	 * @param y the y location
	 */
	public void addMarker(int x, int y) {
		Marker m;
		if(turn.equals("x")) {
			m = new MarkerX(x,y,markerSize,xColor,Marker.DEFAULT_THICKNESS);
			reduceMarkerSize(m);
			centerMarker(m);
			markers.add(m);
		}
		else {
			m = new MarkerO(x,y,markerSize,oColor,Marker.DEFAULT_THICKNESS);
			reduceMarkerSize(m);
			centerMarker(m);
			markers.add(m);
		}
	}

	/**
	 * Returns player x color
	 * @return the xColor
	 */
	public Color getxColor() {
		return xColor;
	}

	/**
	 * Returns player x color
	 * @return the yColor
	 */
	public Color getyColor() {
		return oColor;
	}
	
	/**
	 * Determines if the game is over.
	 * @return true if the game is over, and false otherwise
	 */
	public boolean gameOver() {
		if(isWin()) {
			return true;
		}
		for(int row = 0; row < gameState.length; row ++) {
			for(int col = 0; col < gameState[row].length; col ++) {
				if(gameState[row][col] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Determines if a player has won the game.
	 * @return the isWin
	 */
	public boolean isWin() {
		int playerX = 3;
		int playerO = -3;
		for(int row = 0; row < gameState.length; row ++) {
			int sum = 0;
			for(int col = 0; col < gameState.length; col ++) {
				sum += gameState[row][col];
			}
			if(sum == playerX || sum == playerO) {
				return true;
			}
		}
		for(int col = 0; col < gameState.length; col ++) {
			int sum = 0;
			for(int row = 0; row < gameState.length; row ++) {
				sum += gameState[row][col];
			}
			if(sum == playerX || sum == playerO) {
				return true;
			}
		}
		int sumNeg = 0;
		int sumPos = 0;
		int row = 2;
		int col= 0;
		for(int i = 0; i < gameState.length; i ++) {
			sumNeg += gameState[i][i];
			sumPos += gameState[row-i][col+i];
		}
		if(sumNeg == playerX || sumNeg == playerO || sumPos == playerX || sumPos == playerO) {
			return true;
		}
		return false;
	}

	
	/**
	 * Resets the game.
	 */
	public void resetGame() {
		markers = new ArrayList<Marker>();
		gameState = new int[3][3];
		turn = "x";
		setChanged();
		notifyObservers();
		clearChanged();
	}

}
