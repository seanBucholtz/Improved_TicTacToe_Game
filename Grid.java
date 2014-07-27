package TicTacToe;
import java.awt.*;
/**
 * The Tic-Tac-Toe grid object.
 * @author Sean Bucholtz
 * @version Project 5 - Tic-Tac-Toe
 */
public class Grid {
	
	//the size of the board
	private int size;
	// the standard x-coordinate location
	private int x;
	// the standard y-coordinate
	private int y;
	// the color of the board
	private Color color;
	private BasicStroke thickness;
	// the right vertical beam coordinates
	private int[] rightVertBeam;
	// the left vertical beam 
	private int[] leftVertBeam;
	private int[] topHorzBeam;
	private int[] bottomHorzBeam;
	
	public static final int DEFAULT_BOARD_SIZE = 300;
	public static final float DEFAULT_BOARD_THICKNESS = 5.0f;
	public static final Color DEFAULT_COLOR = Color.black;
	
	/**
	 * The basic grid constructor.
	 * @param x the x-coordinate value
	 * @param y the y-coordinate value
	 * @throws IllegalArgumentException if the coordinate are less than zero
	 */
	public Grid(int x, int y) throws IllegalArgumentException {
		if(x < 0 || y < 0) {
			// if size argument is not even
			throw new IllegalArgumentException("coordinates must be greater equal to 0.");
		}
		rightVertBeam = new int[4];
		leftVertBeam = new int[4];
		topHorzBeam = new int[4];
		bottomHorzBeam = new int[4];
		size = DEFAULT_BOARD_SIZE;
		this.x = x;
		this.y = y;
		setBeams();
		thickness = new BasicStroke(DEFAULT_BOARD_THICKNESS);
		color = DEFAULT_COLOR;
	}
	
	/**
	 * General grid constructor that defines the size of the grid.
	 * @param x the x-coordinate value
	 * @param y the y-coordinate value
	 * @param s the size
	 * @throws IllegalArgumentException if the size is not divisible by 3 and/or less-than 90
	 */
	public Grid(int x, int y, int s) throws IllegalArgumentException {
		this(x,y);
		if(s < 90 || s % 3 != 0) {
			throw new IllegalArgumentException("size must be equal-or-greater-than 90 " + 
		"and evenly divisible by 3.");
		}
		setBeams();
	}
	/**
	 * Advanced grid constructor
	 * @param x the x-coordinate value
	 * @param y the y-coordinate value
	 * @param s the size
	 * @param c the color
	 * @param t the thickness of the grid
	 */
	public Grid(int x, int y, int s, Color c, float t) {
		this(x,y,s);
		color = c;
		thickness = new BasicStroke(t);
		size = s;
		setBeams();
	}
	
	/**
	 * Draws the grid.
	 * @param g the graphics object
	 */
	public void draw(Graphics g) {
		Graphics2D graphic = (Graphics2D) g;
		graphic.setColor(color);
		graphic.setStroke(thickness);
		graphic.drawLine(rightVertBeam[0], rightVertBeam[1], rightVertBeam[2], rightVertBeam[3]);
		graphic.drawLine(leftVertBeam[0], leftVertBeam[1], leftVertBeam[2], leftVertBeam[3]);
		graphic.drawLine(topHorzBeam[0], topHorzBeam[1], topHorzBeam[2], topHorzBeam[3]);
		graphic.drawLine(bottomHorzBeam[0], bottomHorzBeam[1], bottomHorzBeam[2], bottomHorzBeam[3]);
	}

	
	/**
	 * Returns the size of the object.
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Sets the size of the object.
	 * @param s the new size
	 */
	public void setSize(int s) {
		size = s;
		setBeams();
	}
	
	/**
	 * Sets the coordinate locations of the grid.
	 */
	public void setBeams() {
		rightVertBeam[0] = x + 2*size/3; 
		rightVertBeam[1] = y;
		rightVertBeam[2] = x + 2*size/3;
		rightVertBeam[3] = y + size; 
		
		leftVertBeam[0] = x + size/3; 
		leftVertBeam[1] = y;
		leftVertBeam[2] = x + size/3;
		leftVertBeam[3] = y + size; 
		
		topHorzBeam[0] = x;
		topHorzBeam[1] = y + size/3;
		topHorzBeam[2] = x + size;
		topHorzBeam[3] = y + size/3;
		
		bottomHorzBeam[0] = x;
		bottomHorzBeam[1] = y + 2*size/3;
		bottomHorzBeam[2] = x + size;
		bottomHorzBeam[3] = y + 2*size/3;
	}
	
	/**
	 * Returns the grid color.
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the grid color.
	 * @param c the new color
	 */
	public void setColor(Color c) {
		color = c;
	}
	
	/**
	 * Sets the thickness of the grid.
	 * @param t the new thickness
	 */
	public void setThickness(float t) {
		thickness = new BasicStroke(t);
	}

}
