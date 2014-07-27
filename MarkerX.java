package TicTacToe;
import java.awt.*;

/**
 * The Tic-Tac-Toe x-marker object.
 * @author Sean Bucholtz
 * @version Project 5 - Tic-Tac-Toe
 */
public class MarkerX extends Marker {
	
	int[] negBeam;
	int[] posBeam;
	
	/**
	 * The basic constructor.
	 * @param x the x-coordinate value
	 * @param y the y-coordinate value
	 */
	public MarkerX(int x, int y) {
		super(x,y);
		negBeam = new int[4];
		posBeam = new int[4];
		setBeamCoordinates();
	}
	
	/**
	 * The general constructor.
	 * @param x the x-coordinate value
	 * @param y the y-coordinate value
	 * @param s the size
	 * @param c the color
	 */
	public MarkerX(int x, int y, int s, Color c) {
		super(x,y,s,c);
		negBeam = new int[4];
		posBeam = new int[4];
		setBeamCoordinates();
	}
	
	/**
	 * The advanced constructor.
	 * @param x the x-coordinate value
	 * @param y the y-coordinate value
	 * @param s the size
	 * @param c the color
	 * @param t the thickness
	 */
	public MarkerX(int x, int y, int s, Color c, float t) {
		super(x,y,s,c,t);
		negBeam = new int[4];
		posBeam = new int[4];
		setBeamCoordinates();
	}
	
	/**
	 * Draws the x-marker object.
	 * @param g the graphic object
	 */
	public void draw(Graphics g) {
		Graphics2D graphic = (Graphics2D) g;
		graphic.setStroke(getThickness());
		graphic.setColor(getColor());
		graphic.drawLine(negBeam[0], negBeam[1], negBeam[2], negBeam[3]);
		graphic.drawLine(posBeam[0], posBeam[1], posBeam[2], posBeam[3]);
	}
	
	/**
	 * Sets the coordinate locations of the marker.
	 */
	public void setBeamCoordinates() {
		negBeam[0] = getX();
		negBeam[1] = getY();
		negBeam[2] = getX() + getSize();
		negBeam[3] = getY() + getSize();
		posBeam[0] = getX();
		posBeam[1] = getY() + getSize();
		posBeam[2] = getX() + getSize();
		posBeam[3] = getY();
	}
	
	/**
	 * Sets the size of the marker.
	 */
	public void setSize(int s) {
		super.setSize(s);
		setBeamCoordinates();
	}
	
	/**
	 * Sets the x-coordinate value.
	 * @param x the new coordinate
	 */
	public void setX(int x) {
		super.setX(x);
		setBeamCoordinates();
	}
	
	/**
	 * Sets the y-coordinate value.
	 * @param y the new coordinate
	 */
	public void setY(int y) {
		super.setY(y);
		setBeamCoordinates();
	}
}
