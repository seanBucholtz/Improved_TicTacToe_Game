package TicTacToe;
import java.awt.*;

/**
 * The Tic-Tac-Toe o-marker object.
 * @author Sean Bucholtz
 * @version Project 5 - Tic-Tac-Toe
 */
public class MarkerO extends Marker {
	
	/**
	 * The basic constructor.
	 * @param x the x-coordinate value
	 * @param y the y-coordinate value
	 */
	public MarkerO(int x, int y) {
		super(x,y);
	}
	
	/**
	 * The general constructor.
	 * @param x the x-coordinate value
	 * @param y the y-coordinate value
	 * @param s the size
	 * @param c the color
	 */
	public MarkerO(int x, int y, int s, Color c) {
		super(x,y,s,c);
	}
	
	/**
	 * The advanced constructor.
	 * @param x the x-coordinate value
	 * @param y the y-coordinate value
	 * @param s the size
	 * @param c the color
	 * @param t the thickness
	 */
	public MarkerO(int x, int y, int s, Color c, float t) {
		super(x,y,s,c,t);
	}
	
	/**
	 * Draws the circle marker object.
	 * @param g the graphic object
	 */
	public void draw(Graphics g) {
		Graphics2D graphic = (Graphics2D) g;
		graphic.setStroke(getThickness());
		// sets the outline color of the circle
		graphic.setColor(getColor());
		// draws the circle marker
		graphic.drawOval(getX(), getY(), getSize(), getSize());
	}
}
