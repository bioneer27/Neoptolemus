package Kabasuji;

import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Himanjal
 *
 */
public class Board {

	public static final int SIZE = 12;

	Square[][] board;
	
	ArrayList<WindowClass> pieces = new ArrayList<WindowClass>();

	
	public Board(){
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				board[i][j] = new Square(i, j, this, true, false);
				if((i+j)%2 ==0){
					board[i][j].color = Color.DARK_GRAY;
				}
				else board[i][j].color = Color.lightGray;
			}
		}
	}
	
	public int getNumSquaresRem(){
		int count =0;
		for(int i =0; i< SIZE; i++){
			for(int j=0; j< SIZE; j++){
				if(!board[i][j].taken){
					count++;
				}
			}
		}
		return count;
	}
	
	public boolean removePiece(WindowClass p, int row, int col){
		if(pieces.contains(p)){
			for(int i=0; i<6; i++){
				
			}
		}
		
		
		return false;
	}
	
	public boolean isValid(WindowClass p, int row, int col){
		int index =3;
		for(int i=0; i<6;i++){
			int prow = p.squareList.get(i).x;
			int pcol = p.squareList.get(i).y;
			if(row-(prow-index)>0 || row-(prow-index) <11){
				if(col-(pcol-index)>0 || col-(pcol-index)>11){
					if(!board[row-(prow-index)][col-(pcol-index)].taken){
						if(board[row-(prow-index)][col-(pcol-index)].visible){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	

	public boolean putPieceOnBoard(WindowClass p, int row, int col){
		int index = 3;
		if(isValid(p,row,col)){
			for(int i=0; i<6;i++){
				int prow = p.squareList.get(i).x;
				int pcol = p.squareList.get(i).y;
				colorBoard((row-(prow-index)),(col-(pcol-index)), p.c);
			}
			pieces.add(p);
			return true;
		}
		
		return false;
	}
	
	public void colorBoard(int row, int col, Color color){
		board[row][col].taken = true;
		board[row][col].color = color;
		
	}
	
}


