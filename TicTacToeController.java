package TicTacToe;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 * The Tic-Tac-Toe controller.
 * @author Sean Bucholtz
 * @version Project 5 - Tic-Tac-Toe
 */
public class TicTacToeController implements MouseListener {
	
	private TicTacToeModel model;
	private int x;
	private int y;
	
	/**
	 * Constructs new controller.
	 * @param m the model
	 */
	public TicTacToeController(TicTacToeModel m) {
		model = m;
		x = 0;
		y = 0;
	}
	
	/**
	 * Determines a course of action for mouse clicks in the game.
	 * @param e the event
	 */
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		int sector;
		if(x < model.getGrid().getSize()/3) {
			if(y < model.getGrid().getSize()/3) {
				sector = 1;
			}
			else if(y < 2*model.getGrid().getSize()/3) {
				sector = 4;
			}
			else {
				sector = 7;
			}
		}
		else if(x < 2*model.getGrid().getSize()/3) {
			if(y < model.getGrid().getSize()/3) {
				sector = 2;
			}
			else if(y < 2*model.getGrid().getSize()/3) {
				sector = 5;
			}
			else {
				sector = 8;
			}
		}
		else {
			if(y < model.getGrid().getSize()/3) {
				sector = 3;
			}
			else if(y < 2*model.getGrid().getSize()/3) {
				sector = 6;
			}
			else {
				sector = 9;
			}
		}
		switch(sector) {
		case 1:
			if(model.isAvailable(0, 0)) {
				model.addMarker(0, 0);
				model.updateGameState(0, 0);
				if(model.gameOver()) {
					prompt();
					break;
				}
				model.changeTurn();
			}
			break;
		case 2: 
			if(model.isAvailable(0, 1)) {
				model.addMarker(model.getGrid().getSize()/3, 0);
				model.updateGameState(0, 1);
				if(model.gameOver()) {
					prompt();
					break;
				}
				model.changeTurn();
			}
			break;
		case 3: 
			if(model.isAvailable(0, 2)) {
				model.addMarker(2*model.getGrid().getSize()/3, 0);
				model.updateGameState(0, 2);
				if(model.gameOver()) {
					prompt();
					break;
				}
				model.changeTurn();
			}
			break;
		case 4:
			if(model.isAvailable(1, 0)) {
				model.addMarker(0, model.getGrid().getSize()/3);
				model.updateGameState(1, 0);
				if(model.gameOver()) {
					prompt();
					break;
				}
				model.changeTurn();
			}
			break;
		case 5:
			if(model.isAvailable(1, 1)) {
				model.addMarker(model.getGrid().getSize()/3, model.getGrid().getSize()/3);
				model.updateGameState(1, 1);
				if(model.gameOver()) {
					prompt();
					break;
				}
				model.changeTurn();
			}
			break;
		case 6: 
			if(model.isAvailable(1, 2)) {
				model.addMarker(2*model.getGrid().getSize()/3, model.getGrid().getSize()/3);
				model.updateGameState(1, 2);
				if(model.gameOver()) {
					prompt();
					break;
				}
				model.changeTurn();
			}
			break;
		case 7: 
			if(model.isAvailable(2, 0)) {
				model.addMarker(0, 2*model.getGrid().getSize()/3);
				model.updateGameState(2, 0);
				if(model.gameOver()) {
					prompt();
					break;
				}
				model.changeTurn();
			}
			break;
		case 8: 
			if(model.isAvailable(2, 1)) {
				model.addMarker(model.getGrid().getSize()/3, 2*model.getGrid().getSize()/3);
				model.updateGameState(2, 1);
				if(model.gameOver()) {
					prompt();
					break;
				}
				model.changeTurn();
			}
			break;
		case 9: 
			if(model.isAvailable(2, 2)) {
				model.addMarker(2*model.getGrid().getSize()/3, 2*model.getGrid().getSize()/3);
				model.updateGameState(2, 2);
				if(model.gameOver()) {
					prompt();
					break;
				}
				model.changeTurn();
			}
			break;
		}
	}
	
	/**
	 * Prompts the user at the end of the game.
	 */
	public void prompt() {
		int playAgain;
		if(model.isWin()) {
			playAgain = JOptionPane.showConfirmDialog(null, "Congratulations! " + 
					model.getTurn() + " wins.\nWould you like to play again?", 
					"GameOver", JOptionPane.YES_NO_OPTION);
		}
		else {
			playAgain = JOptionPane.showConfirmDialog(null, 
					"Stalemate!\nWould you like to play again?", 
					"GameOver", JOptionPane.YES_NO_OPTION);
		}
		if(playAgain == 0) {
			model.resetGame();
		}
		else {
			int exit = JOptionPane.showConfirmDialog(null,"Would you like to quit?","Quit?", JOptionPane.YES_NO_OPTION);
			if(exit == 0) {
				System.exit(exit);
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {}
	
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
}
