package Kabasuji;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/** Assumes UTF-8 encoding. JDK 7+. */
public class ReadWithScanner {
  
  /**
   Constructor.
   @param aFileName full name of an existing, readable file.
  */
  public ReadWithScanner(String aFileName,Kabasuji kab){
    fFilePath = Paths.get(aFileName);
    this.kab = kab;
  }
  
  
  /** Template method that calls {@link #processLine(String)}.  */
  public Kabasuji processLineByLine() throws IOException {
    try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){
      while (scanner.hasNextLine()){
        processLine(scanner.nextLine());
      }      
    }
    return this.kab;
  }

  private void checkBadge (int badgeNum, String badgeName, String txtName, String txtValue){
	  if ((txtName.trim().equals(badgeName)) && (txtValue.trim().equals("1"))){
		  this.kab.badges[badgeNum-1].achieved = true;
	  }
	  else if ((txtName.trim().equals(badgeName)) && (!txtValue.trim().equals("1"))){
		  this.kab.badges[badgeNum-1].achieved = false;
	  }
  }
  
  private void checkLightningLevels (int levelNum, String lvlName, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Integer x = Integer.parseInt(ar[1]);
		  Lightning lLevel = new Lightning(levelNum, x);
		  if (ar[0].trim().equals("")){
			  lLevel.unlocked = false;
			  lLevel.star = 0;
		  }else if ((ar[0].trim().equals("0"))||(ar[0].trim().equals("1"))||(ar[0].trim().equals("2"))||(ar[0].trim().equals("3"))){
			  lLevel.star = Integer.parseInt(ar[0].trim());
			  lLevel.unlocked = true;
		  }
		  this.kab.llevels.add(lLevel);
	  }
  }
  
  private void checkPuzzleLevels (int levelNum, String lvlName, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Integer x = Integer.parseInt(ar[1]);
		  Puzzle pLevel = new Puzzle(levelNum, x);
		  if (ar[0].trim().equals("")){
			  pLevel.unlocked = false;
			  pLevel.star = 0;
		  }else if ((ar[0].trim().equals("0"))||(ar[0].trim().equals("1"))||(ar[0].trim().equals("2"))||(ar[0].trim().equals("3"))){
			  pLevel.star = Integer.parseInt(ar[0].trim());
			  pLevel.unlocked = true;
		  }
		  this.kab.plevels.add(pLevel);
	  }
  }
  
  private void checkReleaseLevels (int levelNum, String lvlName, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Release rLevel = new Release(levelNum);
		  if (ar[0].trim().equals("")){
			  rLevel.unlocked = false;
			  rLevel.star = 0;
		  }else if ((ar[0].trim().equals("0"))||(ar[0].trim().equals("1"))||(ar[0].trim().equals("2"))||(ar[0].trim().equals("3"))){
			  rLevel.star = Integer.parseInt(ar[0].trim());
			  rLevel.unlocked = true;
		  }
		  this.kab.rlevels.add(rLevel);
	  }
  }
  
  private void checkLightningPieces (int levelNum, String lvlName,PieceFactory pF, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Bullpen bpen = new Bullpen();
		  this.kab.llevels.get(levelNum-1).bullpen = bpen;
		  for (int i = 0; i < ar.length; i++) {
			  Integer x = Integer.parseInt(ar[i]);
			  Piece piece =  pF.makePiece(x);
			  this.kab.llevels.get(levelNum-1).bullpen.boxes.add(new Box(piece));//setPiece will depend on the factory pieces
		  }
	  }
  }
  
  private void checkPuzzlePieces (int levelNum, String lvlName, PieceFactory pF, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Bullpen bpen = new Bullpen();
		  this.kab.plevels.get(levelNum-1).bullpen = bpen;
		  for (int i = 0; i < ar.length; i++) {
			  Integer x = Integer.parseInt(ar[i]);
			  Piece piece =  pF.makePiece(x);
			  this.kab.plevels.get(levelNum-1).bullpen.boxes.add(new Box(piece));//setPiece will depend on the factory pieces
		  }
	  }
  }
  
  private void checkReleasePieces (int levelNum, String lvlName, PieceFactory pF, String txtName, String txtValue){
	  if (txtName.trim().equals(lvlName)){
		  String[] ar=txtValue.trim().split(",");
		  Bullpen bpen = new Bullpen();
		  this.kab.rlevels.get(levelNum-1).bullpen = bpen;
		  for (int i = 0; i < ar.length; i++) {
			  Integer x = Integer.parseInt(ar[i]);
			  Piece piece =  pF.makePiece(x);
			  this.kab.rlevels.get(levelNum-1).bullpen.boxes.add(new Box(piece));//setPiece will depend on the factory pieces
		  }
	  }
  }
  
  protected void processLine(String aLine){
    //use a second Scanner to parse the content of each line 
    Scanner scanner = new Scanner(aLine);
    scanner.useDelimiter("=");
    PieceFactory pFactory = new PieceFactory();
    if (scanner.hasNext()){
      //assumes the line has a certain structure
      String name = scanner.next();
      String value = scanner.next();
      
      checkBadge (1,"BADGEONE", name, value);
      checkBadge (2,"BADGETWO", name, value);
      checkBadge (3,"BADGETHREE", name, value);
      checkBadge (4,"BADGEFOUR", name, value);
      checkBadge (5,"BADGEFIVE", name, value);
      checkBadge (6,"BADGESIX", name, value);
      checkBadge (7,"BADGESEVEN", name, value);
      checkBadge (8,"BADGEEIGHT", name, value);
      checkBadge (9,"BADGENINE", name, value);
      checkBadge (10,"BADGETEN", name, value);
      checkLightningLevels (1,"LLEVEL1", name, value);
      checkLightningLevels (2,"LLEVEL2", name, value);
      checkLightningLevels (3,"LLEVEL3", name, value);
      checkLightningLevels (4,"LLEVEL4", name, value);
      checkLightningLevels (5,"LLEVEL5", name, value);
      checkPuzzleLevels (1,"PLEVEL1", name, value);
      checkPuzzleLevels (2,"PLEVEL2", name, value);
      checkPuzzleLevels (3,"PLEVEL3", name, value);
      checkPuzzleLevels (4,"PLEVEL4", name, value);
      checkPuzzleLevels (5,"PLEVEL5", name, value);
      checkReleaseLevels (1,"RLEVEL1", name, value);
      checkReleaseLevels (2,"RLEVEL2", name, value);
      checkReleaseLevels (3,"RLEVEL3", name, value);
      checkReleaseLevels (4,"RLEVEL4", name, value);
      checkReleaseLevels (5,"RLEVEL5", name, value);
      checkLightningPieces (1, "LLEVEL1_PIECES",pFactory, name, value);
      checkLightningPieces (2, "LLEVEL2_PIECES",pFactory, name, value);
      checkLightningPieces (3, "LLEVEL3_PIECES",pFactory, name, value);
      checkLightningPieces (4, "LLEVEL4_PIECES",pFactory, name, value);
      checkLightningPieces (5, "LLEVEL5_PIECES",pFactory, name, value);
      checkPuzzlePieces (1, "PLEVEL1_PIECES",pFactory, name, value);
      checkPuzzlePieces (2, "PLEVEL2_PIECES",pFactory, name, value);
      checkPuzzlePieces (3, "PLEVEL3_PIECES",pFactory, name, value);
      checkPuzzlePieces (4, "PLEVEL4_PIECES",pFactory, name, value);
      checkPuzzlePieces (5, "PLEVEL5_PIECES",pFactory, name, value);
      checkReleasePieces (1, "RLEVEL1_PIECES",pFactory, name, value);
      checkReleasePieces (2, "RLEVEL2_PIECES",pFactory, name, value);
      checkReleasePieces (3, "RLEVEL3_PIECES",pFactory, name, value);
      checkReleasePieces (4, "RLEVEL4_PIECES",pFactory, name, value);
      checkReleasePieces (5, "RLEVEL5_PIECES",pFactory, name, value);

      log("Name is : " + quote(name.trim()) + ", and Value is : " + quote(value.trim()));
    }
  }
  
  // PRIVATE 
  private final Path fFilePath;
  private final static Charset ENCODING = StandardCharsets.UTF_8;  
  
  private static void log(Object aObject){
    System.out.println(String.valueOf(aObject));
  }
  
  private String quote(String aText){
    String QUOTE = "'";
    return QUOTE + aText + QUOTE;
  }
  
  private Kabasuji kab;
} 