package TicTacToe;
import java.awt.*;
import java.awt.Graphics;

/**
 * The Tic-Tac-Toe marker object.
 * @author Sean Bucholtz
 * @version Project 5 - Tic-Tac-Toe
 */
public abstract class Marker {
	
	private int size;
	private int x;
	private int y;
	private Color color;
	private BasicStroke thickness;
	
	public static final float DEFAULT_THICKNESS = 3.0f;
	public static final Color DEFAULT_COLOR = Color.black;
	public static final Color COLOR_BLUE = Color.blue;
	public static final Color COLOR_RED = Color.red;
	
	/**
	 * Constructs a new marker.
	 * @param x the Upper-Left corner x-coordinate location of the marker
	 * @param y the Upper-Left corner y-coordinate location of the marker
	 * @throws IllegalArgumentException if size is not of an even order
	 */
	public Marker(int x, int y) throws IllegalArgumentException {
		if(x < 0 || y < 0) {
			throw new IllegalArgumentException("coordinates must be greater equal to 0.");
		}
		this.x = x;
		this.y = y;
		setColor(Color.black);
		thickness = new BasicStroke(DEFAULT_THICKNESS);
	}
	
	/**
	 * The general marker constructor.
	 * @param x the Upper-Left corner x-coordinate location of the marker
	 * @param y the Upper-Left corner y-coordinate location of the marker
	 * @param s the size
	 * @param c the color
	 * @throws IllegalArgumentException marker if size is less than 1 or coordinate are less than zero
	 */
	public Marker(int x, int y, int s, Color c) throws IllegalArgumentException {
		this(x,y);
		if(s < 1 || x < 0 || y < 0) {
			throw new IllegalArgumentException("Size and coordinates must be greater than zero");
		}
		size = s;
		setColor(c);
	}
	
	/**
	 * Advanced marker constructor.
	 * @param x the Upper-Left corner x-coordinate location of the marker
	 * @param y the Upper-Left corner y-coordinate location of the marker
	 * @param s the size
	 * @param c the color
	 * @param t the thickness
	 */
	public Marker(int x, int y, int s, Color c, float t) {
		this(x,y,s,c);
		thickness = new BasicStroke(t);
	}
	
	/**
	 * Draws the marker.
	 * @param g the graphics object
	 */
	public abstract void draw(Graphics g);

	
	/**
	 * Returns the size of the marker
	 * @return the size of the marker
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Sets the size of the marker.
	 * @param s the new size
	 */
	public void setSize(int s) {
		size = s;
	}

	/**
	 * Returns the value of x.
	 * @return the xCoordinate
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Sets the value of x.
	 * @param x the new x value
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Returns the value of y.
	 * @return the yCoordinate
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the value of y.
	 * @param y the new y value
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Returns the marker color.
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Sets the marker color.
	 * @param c the new color
	 */
	public void setColor(Color c) {
		color = c;
	}
	
	/**
	 * Returns the thickness of the marker
	 * @return the thickness
	 */
	public BasicStroke getThickness() {
		return thickness;
	}
}
