import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

/**
 * PJ Desamero
 *   
 * Tic Tac Toe game played between two users. 
 * Game board consists of 9 buttons,
 * 	in which each button can be either 
 *    an X or O, depending on who's turn.
 *  
 */

public class TicTacToe implements ActionListener {
	/*
	 * Necessary variables: game board, pieces (X or O), 
	 * boolean for winner, a counter to keep track of who's turn,
	 * 9 buttons for the board.
	 *
	 */
	private JFrame board = new JFrame("Tic Tac Toe: User vs User");
	
	//9 Possible Buttons on the Board, default to containing an empty string
	private JButton button1 = new JButton("");
	private JButton button2 = new JButton("");
	private JButton button3 = new JButton("");
	private JButton button4 = new JButton("");
	private JButton button5 = new JButton("");
	private JButton button6 = new JButton("");
	private JButton button7 = new JButton("");
	private JButton button8 = new JButton("");
	private JButton button9 = new JButton("");
	
	//Win or Draw
	private boolean win = false;
	
	//String for 'X' or 'O', defaulted to an empty string 
	private String piece = "";
	
	//Count used to keep track of who's turn
	private int count = 0;

	
	public TicTacToe(){	
		
	/**
	 * Create board, create and add buttons to board,
	 * add ActionListener functionality to buttons,
	 * 
	 */
		
		//Create Game Board
		board.setSize(500,500);
		board.setLayout(new GridLayout(3,3));
		board.setBackground(Color.blue);
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Add Buttons To The Game Board, Red Font, Font of Size 50f
		button1.setForeground(Color.red);
		button1.setFont(button1.getFont().deriveFont(50f));
		board.add(button1);
		button2.setForeground(Color.red);
		button2.setFont(button1.getFont().deriveFont(50f));
		board.add(button2);
		button3.setForeground(Color.red);
		button3.setFont(button1.getFont().deriveFont(50f));
		board.add(button3);
		button4.setForeground(Color.red);
		button4.setFont(button1.getFont().deriveFont(50f));
		board.add(button4);
		button5.setForeground(Color.red);
		button5.setFont(button1.getFont().deriveFont(50f));
		board.add(button5);
		button6.setForeground(Color.red);
		button6.setFont(button1.getFont().deriveFont(50f));
		board.add(button6);
		button7.setForeground(Color.red);
		button7.setFont(button1.getFont().deriveFont(50f));
		board.add(button7);
		button8.setForeground(Color.red);
		button8.setFont(button1.getFont().deriveFont(50f));
		board.add(button8);
		button9.setForeground(Color.red);
		button9.setFont(button1.getFont().deriveFont(50f));
		board.add(button9);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);	

		board.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent ae) {
	
		/*
		 * Count increments by 1, starting at 0, for every turn that goes by.
		 * If turn is an odd number, then "X" is placed in button.
		 * Else if turn is an even number, then "O" in the button.
		 * 
		 */
		
		//Determine which player's turn it is, first turn should be an "X"
		if(count % 2 == 0){
			piece = "X";
		} 
		else {
			piece = "O";
		} 

		/*  If a button is clicked, then add the proper piece, 
		 *  	if and only if that button is blank.
		 *  Increment count to let next player place his/her piece.
		 */
		
		if(button1.getText() == "" && ae.getSource() == button1){
			button1.setText(piece);
			count++;
		//	System.out.println("Button 1 pressed");
		} 
		else if(button2.getText() == "" && ae.getSource() == button2){
			button2.setText(piece);
			count++;
		//	System.out.println("Button 2 pressed");
		} 
		else if(button3.getText() == "" && ae.getSource() == button3){
			button3.setText(piece);
			count++;
		//	System.out.println("Button 3 pressed");
		} 
		else if(button4.getText() == "" && ae.getSource() == button4){
			button4.setText(piece);
			count++;
		//	System.out.println("Button 4 pressed");
		} 
		else if(button5.getText() == "" && ae.getSource() == button5){
			button5.setText(piece);
			count++;
		//	System.out.println("Button 5 pressed");
		} 
		else if(button6.getText() == "" && ae.getSource() == button6){
			button6.setText(piece);
			count++;
		//	System.out.println("Button 6 pressed");
		} 
		else if(button7.getText() == "" && ae.getSource() == button7){
			button7.setText(piece);
			count++;
		//	System.out.println("Button 7 pressed");
		} 
		else if(button8.getText() == "" && ae.getSource() == button8){
			button8.setText(piece);
			count++;
		//	System.out.println("Button 8 pressed");
		} 
		else if(button9.getText() == "" && ae.getSource() == button9){
			button9.setText(piece);
			count++;
		//	System.out.println("Button 9 pressed");
		}
	
		/**
		 * 
		 * Determine winner, if any. Tie if otherwise. 
		 * Possibilities: horizontal (3), vertical (3), diagonal (2).
		 * 
		 * 	      Board:
		 *		1 | 2 | 3     1,2,3 | 2,5,8 | 3,6,9 | 4,5,6
		 *		__|___|___	  1,4,7	| 		| 3,5,7 | 7,8,9
		 * 		4 | 5 | 6	  1,5,9	
		 *		__|___|___
		 * 		7 | 8 | 9
		 *           
		 */
		
		//first parameter in each if clause requires there to be a piece in that location
		
		//if button1's piece is same as 2 and 3 = winner by horizontal across the top
		if(button1.getText() != "" &&
		   button1.getText() == button2.getText() && 
		   button1.getText() == button3.getText()){
					win = true;
					button1.setForeground(Color.green);
					button2.setForeground(Color.green);
					button3.setForeground(Color.green);
		}
		
		//if button1's piece is same as 4 and 7 = winner by vertical down first column
		else if(button1.getText() != "" &&
				button1.getText() == button4.getText() &&
			    button1.getText() == button7.getText()){
					win = true;
					button1.setForeground(Color.green);
					button4.setForeground(Color.green);
					button7.setForeground(Color.green);
		}
		
		//if button1's piece is same as 5 and 9 = winner by diagonal
		else if(button1.getText() != "" &&
				button1.getText() == button5.getText() &&
			    button1.getText() == button9.getText()){
					win = true;
					button1.setForeground(Color.green);
					button5.setForeground(Color.green);
					button9.setForeground(Color.green);
		}
		
		//if button2's piece is same as 5 and 8 = winner by vertical down second column
		else if(button2.getText() != "" &&
				button2.getText() == button5.getText() &&
			    button2.getText() == button8.getText()){
					win = true;
					button2.setForeground(Color.green);
					button5.setForeground(Color.green);
					button8.setForeground(Color.green);
		}
		
		
		//if button3's piece is same as 6 and 9 = winner by vertical down third column
		else if(button3.getText() != "" &&
				button3.getText() == button6.getText() &&
			    button3.getText() == button9.getText()){
					win = true;
					button3.setForeground(Color.green);
					button6.setForeground(Color.green);
					button9.setForeground(Color.green);
		}
		
		//if button3's piece is same as 5 and 7 = winner by diagonal
		else if(button3.getText() != "" &&
				button3.getText() == button5.getText() &&
				button3.getText() == button7.getText()){
					win = true;
					button3.setForeground(Color.green);
					button5.setForeground(Color.green);
					button7.setForeground(Color.green);
					
		}		
			
		//if button4's piece is same as 2 and 3 = winner by horizontal across the middle
		else if(button4.getText() != "" &&
			    button4.getText() == button5.getText() &&
			    button4.getText() == button6.getText()){
					win = true;
					button4.setForeground(Color.green);
					button5.setForeground(Color.green);
					button6.setForeground(Color.green);
		}
				

		//if button7's piece is same as 8 and 9 = winner by horizontal across the bottom
		else if(button7.getText() != "" &&
			    button7.getText() == button8.getText() &&
			    button7.getText() == button9.getText()){
					win = true;
					button7.setForeground(Color.green);
					button8.setForeground(Color.green);
					button9.setForeground(Color.green);
		}
		
		//no winner results in a tie game
		else {
			win = false;
		}
		
		/**
		 * Show a dialog if someone wins or the game is a tie.
		 * Also asks the users to play another game. If yes, new game. If no, exit.
		 * 
		 */
		
		//winner
		if(win == true){
			int gameover = JOptionPane.showConfirmDialog(null, piece + " Wins!" + '\n' 
                    + "Play Again?");
				if (gameover == JOptionPane.YES_OPTION){
					new TicTacToe();
				}
				else {
					System.exit(0);
				}
		} 
		

		//tie game
		else if(count == 9){
				button1.setForeground(Color.black);
				button2.setForeground(Color.black);
				button3.setForeground(Color.black);
				button4.setForeground(Color.black);
				button5.setForeground(Color.black);
				button6.setForeground(Color.black);
				button7.setForeground(Color.black);
				button8.setForeground(Color.black);
				button9.setForeground(Color.black);
			int gameover = JOptionPane.showConfirmDialog(null, "Tie Game!" + '\n' 
				+ "Play Again?");
			if (gameover == JOptionPane.YES_OPTION){
				new TicTacToe();
			}
			else {
				System.exit(0);
			}
		}
	}

	public static void main(String[] args){
		int start = JOptionPane.showConfirmDialog(null, "Do you want to play Tic-Tac-Toe?");    
		if (start == JOptionPane.YES_OPTION){
				new TicTacToe();
		}
		else{
			System.exit(0);
		}
	}
}
