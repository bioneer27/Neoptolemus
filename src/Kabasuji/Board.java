package Kabasuji;

import java.awt.Color;
import java.util.ArrayList;

public class Board {
	
	public static final int SIZE = 12;
	
	ArrayList<Box> boxes;
	Square squares[][] = new Square[SIZE][SIZE];
	ArrayList<Piece> pieces;
	ArrayList<Piece> hintPiece;
	
	
	public Board(PieceType type){
		
		this.boxes = new ArrayList<Box>();
		this.pieces = new ArrayList<Piece>();
		this.hintPiece = new ArrayList<Piece>();
		
		for(int i=0; i<12; i++)
			for(int j= 0; j<12; j++){
				squares[i][j].color = Color.black;
				squares[i][j].visible = true;
				squares[i][j].taken = false;
				
			}
	}
	
	
	public void resetBoard(){
		for(int i =0; i < squares.length; i++)
			for(int j=0; j< squares[i].length; j++){
				squares[i][j].taken = false;
			}
	}
	
	public int countEmptySquares(){
		int count = 0;
		for(int i =0; i < squares.length; i++)
			for(int j=0; j< squares[i].length; j++){
				if(squares[i][j].visible == true && squares[i][j].taken == false)
					count++;
			}
	return count;
	}
	
	public boolean isValid(Box newBox){
		return false;
	}

}
