package model;

import java.awt.Color;

public class RSet {
	
	protected Color color;
	
	protected int i;
	
	protected boolean isRSet;
	
	RSet(Color c, int j){
		color = c;
		i = j;
		isRSet = false;
	}
	
	RSet(Color c, int j, boolean t){
		color = c;
		i = j;
		isRSet = t;
	}
	
	public Color getRSColor(){
		return color;
	}
	
	public int getRSInt(){
		return i;
	}
	
	public boolean getRSetVisible(){
		return isRSet;
	}
	

}