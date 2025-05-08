////////////////////////////////////////////////////////////////////
// [Enrico] [Sorgato] [2071112]
// [Alessandro] [Bertolazzi] [1227274]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;
public class IntegerToRoman {
  public static String convert(int number){
    if (number < 1 || number > 6){
      throw new IllegalArgumentException("Il numero deve essere tra 1 e 6 per questo step");
    }
    
    String[] numeriRomani = {"I", "II", "III", "IV", "V", "VI"};
    return numeriRomani[number - 1];
  }
}
