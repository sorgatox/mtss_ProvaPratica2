////////////////////////////////////////////////////////////////////
// [Enrico] [Sorgato] [2071112]
// [Alessandro] [Bertolazzi] [1227274]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;
public class IntegerToRoman {
  public static String convert(int number){
    if (number < 1 || number > 3){
      throw new IllegalArgumentException("Il numero deve essere tra 1 e 3 per questo step");
    }
    
    String[] numeriRomani = {"I", "II", "III"};
    return numeriRomani[number - 1];
  }
}
