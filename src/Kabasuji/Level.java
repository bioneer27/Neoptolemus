package Kabasuji;

import view.LevelPlayView;

public class Level {
	
	Board board;
	int number;
	Bullpen bullpen;
	int star;
	PieceType type;
	boolean unlocked;
	

	
	public Level(int number, PieceType type){//, Board board, Bullpen bullpen){
		this.number = number; 
		this.type = type;
		//this.board = board;
		//this.bullpen = bullpen;
	}
	
	public void resetLevel(){
		/*Add logic here*/
		
		return;
	}
	
	void completeLevel(PieceType type){
		/*Add logic here */

		return;
	}
	

}
