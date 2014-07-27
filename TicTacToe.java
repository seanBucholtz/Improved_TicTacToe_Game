/**
 * 
 */
package TicTacToe;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * The Tic-Tac-Toe application client.
 * @author Sean Bucholtz
 * @version Project 5 - Tic-Tac-Toe
 */
public class TicTacToe {

	/**
	 * The application method.
	 * @param args the command-line arguments.
	 */
	public static void main(String[] args) {
		TicTacToeModel model = new TicTacToeModel(TicTacToeModel.DEFAULT_SIZE, 
				TicTacToeModel.DEFAULT_COLOR, TicTacToeModel.DEFAULT_THICKNESS, Marker.COLOR_BLUE, 
				Marker.COLOR_RED);
		TicTacToeView view = new TicTacToeView(model);
		Dimension dim = new Dimension(TicTacToeModel.DEFAULT_SIZE,TicTacToeModel.DEFAULT_SIZE);
		view.setPreferredSize(dim);
		TicTacToeController controller = new TicTacToeController(model);
		view.addMouseListener(controller);
		model.addObserver(view);
		
		JFrame frame = new JFrame("Tic-Tac-Toe");
		frame.getContentPane().add(view, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
