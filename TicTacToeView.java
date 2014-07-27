package TicTacToe;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import java.awt.Graphics;
import java.util.*;

/**
 * The Tic-Tac-Toe view.
 * @author Sean Bucholtz
 * @version Project 5 - Tic-Tac-Toe
 */
public class TicTacToeView extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private TicTacToeModel model;
	
	/**
	 * Constructs a new game viewer.
	 * @param m the game model
	 */
	public TicTacToeView(TicTacToeModel m) {
		model = m;
	}

	/**
	 * Updates the game.
	 * @param o
	 * @param arg
	 */
	public void update(Observable o, Object arg) {
		repaint();
	}
	
	/**
	 * Displays the game on the panel.
	 * @param g graphics object
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ArrayList<Marker> markers = model.getMarkers();
		for(Marker marker:markers) {
			marker.draw(g);
		}
		model.getGrid().draw(g);
	}
	
}
