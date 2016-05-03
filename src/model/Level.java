/*
 * 
 */
package model;

import java.io.IOException;

import Kabasuji.DataTxtWriter;
import Kabasuji.PieceType;

/**
 * @author Jetro
 *
 */
public class Level  {
	
	/** The board. */
	//general Level attributes
	private Board board;
	
	/** The number. */
	int number;
	
	/** The bullpen. */
	private Bullpen bullpen;
	
	/** The star. */
	private int star;
	
	/** The type. */
	PieceType type;
	
	/** The unlocked. */
	private boolean unlocked;
	
	/** The counter. */
	//counter used for lightning and puzzle levels
	private int counter = 0;
	
	/** The cur count. */
	private int curCount = 0;
	
	//release sets for release levels
	
	/**
	 * @param number
	 * @param type
	 * Constructor for Lightning and Puzzle type levels
	 */
	public Level(int number, PieceType type, Bullpen bullpen, int counter){
		this.number = number; 
		this.type = type;
		//this.setBoard(board);
		this.setBullpen(bullpen);
		setStars(0);
		
		this.setCounter(counter);
		setCurCount(0);
		
		//if this is the first level it should be unlocked by default
		if(number == 1)
			unlocked = true;
		else
			unlocked = false;
	}
	
	/**
	 * @param number
	 * @param type
	 * Constructor for Release type levels
	 */
	public Level(int number, PieceType type, Bullpen bullpen){
		this.number = number; 
		this.type = type;
		this.setBoard(board);
		this.setBullpen(bullpen);
		star = 0;
		//this.board.moves = this.curCount;
		//if this is the first level it should be unlocked by default
		if(number == 1)
			unlocked = true;
		else
			unlocked = false;
	}
	
	/**
	 * @param starsWon
	 */
	public void completeLevel(Model model){
		int starsWon = 0;
		System.out.println("NUM EMPTY SPACES: " + board.getNumSquaresRem());
		//star logic
		if(type == PieceType.LIGHTNING || type == PieceType.PUZZLE){
			if(board.getNumSquaresRem() == 0){
				System.out.println("3 STARS MOTHER FUCKER");
				starsWon = 3;
			}
			else if(board.getNumSquaresRem() <= 6){
				System.out.println("2 STARS BITCH");
				starsWon = 2;
			}
			else if(board.getNumSquaresRem() <= 12){
				System.out.println("1 STAR ASSHOLE");
				starsWon = 1;
			}
			else
				System.out.println("YOU LOSE");
		}
		else if(type == PieceType.RELEASE){
			if(board.getRedGot().length() == 18 && board.getBlueGot().length() == 18 && board.getGreenGot().length() == 18){
				System.out.println("3 STARS MOTHER FUCKER");
				starsWon = 3;
			}
			else if((board.getRedGot().length() == 18 && board.getBlueGot().length() == 18) || (board.getBlueGot().length() == 18 && board.getGreenGot().length() == 18) || (board.getRedGot().length() == 18 && board.getGreenGot().length() == 18)){
				System.out.println("2 STARS BITCH");
				starsWon = 2;
			}
			else if(board.getRedGot().length() == 18 || board.getBlueGot().length() == 18 || board.getGreenGot().length() == 18){
				System.out.println("1 STAR ASSHOLE");
				starsWon = 1;
			}
			else
				System.out.println("YOU LOSE");
		}

		//check if even need to update
		if(starsWon > star){
			try {
				if(type == PieceType.LIGHTNING)
					new DataTxtWriter("src/Data.txt").txtReplace("LLEVEL" + number + " = " + star + "," + getCounter(), "LLEVEL" + number + " = " + starsWon + "," + getCounter());
				if(type == PieceType.PUZZLE)
					new DataTxtWriter("src/Data.txt").txtReplace("PLEVEL" + number + " = " + star + "," + getCounter(), "PLEVEL" + number + " = " + starsWon + "," + getCounter());
				if(type == PieceType.RELEASE)
					new DataTxtWriter("src/Data.txt").txtReplace("RLEVEL" + number + " = " + star + ",", "RLEVEL" + number + " = " + starsWon + ",");
			} catch (IOException e) {
				e.printStackTrace();
			}
			star = starsWon;
		}
		
		
		//unlock the next level
		if(starsWon > 0 && number + 1 <= model.getNumLevels(type)){
			model.getLevel(type, number + 1).unlocked = true;
			try {
				if(type == PieceType.LIGHTNING)
					new DataTxtWriter("src/Data.txt").txtReplace("LLEVEL" + (number + 1) + " = ," + model.getLevel(type, number + 1).counter, "LLEVEL" + (number + 1) + " = " + 0 + "," + model.getLevel(type, number + 1).counter);
				if(type == PieceType.PUZZLE)
					new DataTxtWriter("src/Data.txt").txtReplace("PLEVEL" + (number + 1) + " = ," + model.getLevel(type, number + 1).counter, "PLEVEL" + (number + 1) + " = " + 0 + "," + model.getLevel(type, number + 1).counter);
				if(type == PieceType.RELEASE)
					new DataTxtWriter("src/Data.txt").txtReplace("RLEVEL" + (number + 1) + " = ,", "RLEVEL" + (number + 1) + " = " + 0 + ",");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.getBoard().clearBoard();
		bullpen = new Bullpen();
	}
	
	/**
	 * @param stars
	 */
	public void setStars(int stars){
		star = stars;
	}
	
	/**
	 * @return
	 */
	public int getStars(){
		return star;
	}

	/**
	 * @return
	 */
	public int getNumber(){
		return number;
	}
	
	/**
	 * @return
	 */
	public PieceType getType(){
		return type;
	}
	
	/**
	 * Gets the bullpen.
	 *
	 * @return the bullpen
	 */
	public Bullpen getBullpen () {return bullpen; }
	
	/**
	 * @return
	 */
	public boolean isUnlocked(){return unlocked;}
	
	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public Board getBoard(){return board;}

	/**
	 * Sets the unlocked.
	 *
	 * @param unlocked
	 *            the new unlocked
	 */
	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

	/**
	 * Sets the bullpen.
	 *
	 * @param bullpen
	 *            the new bullpen
	 */
	public void setBullpen(Bullpen bullpen) {
		this.bullpen = bullpen;
	}

	/**
	 * Sets the board.
	 *
	 * @param board
	 *            the new board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Gets the counter.
	 *
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * Sets the counter.
	 *
	 * @param counter
	 *            the new counter
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * Gets the cur count.
	 *
	 * @return the cur count
	 */
	public int getCurCount() {
		return curCount;
	}

	/**
	 * Sets the cur count.
	 *
	 * @param curCount
	 *            the new cur count
	 */
	public void setCurCount(int curCount) {
		this.curCount = curCount;
	}

	
}
