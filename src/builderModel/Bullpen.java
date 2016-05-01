/*
 * 
 */
package builderModel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import builderModel.PieceFactory;

/**
 * @author xavier & Himanjal
 *
 */
public class Bullpen {
	
	/** The pieces. */
	ArrayList<Piece> pieces = new ArrayList<Piece>();
	
	/** The piece factory. */
	PieceFactory pieceFactory = new PieceFactory();
	
	/** The selected piece. */
	Piece selectedPiece = pieceFactory.makePiece(100);
	
	//bullpen constructor
	/**
	 * @param pieces
	 */
	
	
	public Bullpen(ArrayList<Piece> pieces){
		this.pieces.addAll(pieces);
	}
	
	/**
	 * Instantiates a new bullpen.
	 */
	//default constructor
	public Bullpen(){
		int i;
		for (i = 1; i < 36; i++){
			addPiece(i);
		}
	}
	
	

	
	/**
	 * Adds a piece to he bullpen
	 * @param piece the piece to add
	 */
	public void addPiece(int ID){
		pieces.add(pieceFactory.makePiece(ID));
	}
	
	/**
	 * Adds the random piece.
	 *
	 * @param numOfPieces
	 *            the num of pieces
	 */
	public void addRandomPiece(int numOfPieces){
		if(numOfPieces<0){
			throw new RuntimeException("Cannot add negative number of piece");
		}
		for(int i=0; i<numOfPieces; i++){
			this.pieces.add(pieceFactory.makePiece(new Random().nextInt(35)+1));
		}
	}
	
	/**
	 * Removes the given piece from the bullpen, if present.
	 * @param piece the piece to remove.
	 * @return true if piece was found and removed, false otherwise.
	 */
	public boolean removePiece(int ID){
		for(int i=0;i<this.pieces.size(); i++){

			if(this.pieces.get(i).getId() == ID ){
				this.pieces.remove(i);
				if(this.pieceFactory.getPlace().containsValue(i)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * @return
	 */
	public int numOfPiecesAvailable(){
		int count = 0;
		for(int i=0; i<this.pieces.size(); i++){
			count++;
		}
		return count;
	}
	
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty(){
		return this.pieces.size() == 0;
	}
	
	
	/**
	 * Gets the selected piece.
	 *
	 * @return the selected piece
	 */
	public Piece getSelectedPiece(){
		return selectedPiece;
	}
	
	/**
	 * Sets the selected piece.
	 *
	 * @param ID
	 *            the id
	 * @return true, if successful
	 */
	public boolean setSelectedPiece(int ID){
		if(selectedPiece != null){
			for(int i=0; i< this.pieces.size(); i++){
				if(selectedPiece.getId() == pieces.get(i).getId()){
					pieces.get(i).setC(pieces.get(i).getBackupColor());
				}
			}
		}
		
		if(ID == 100){
			selectedPiece = pieceFactory.makePiece(100);
		}
		for(int i=0; i<this.pieces.size(); i++){
			if(this.pieces.get(i).getId() == ID){
				this.selectedPiece = this.pieces.get(i);
				this.pieces.get(i).setC(Color.RED);
				System.out.println("SelectedPiece Updated");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Clear selected piece.
	 */
	public void clearSelectedPiece(){
		this.selectedPiece = null;
	}
	
	
	/**
	 * 
	 */
	public void resetBullpen(){
		return;
	}

	public void rotate(int i){
		pieces.get(i).rotatePiece();
		System.out.println("YES");
	}
	public Piece getPiece(int i){
		return pieces.get(i);
	}
	/**
	 * @return
	 */
	public ArrayList<Piece> getPieces(){
		return pieces;
	}
}
