////////////////////////////////////////////////////////////////////
// [Enrico] [Sorgato] [2071112]
// [Alessandro] [Bertolazzi] [1227274]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class IntegerToRoman {
    public static String convert(int number) {
        if (number < 1 || number > 20) {
            throw new IllegalArgumentException("Il numero deve essere tra 1 e 20");
        }

        String[] numeriRomani = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
        return numeriRomani[number - 1];
    }
}