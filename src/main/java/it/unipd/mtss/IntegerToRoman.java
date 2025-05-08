////////////////////////////////////////////////////////////////////
// [Enrico] [Sorgato] [2071112]
// [Alessandro] [Bertolazzi] [1227274]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class IntegerToRoman {
    public static String convert(int number) {
        if (number < 1 || number > 500) {
            throw new IllegalArgumentException("Il numero deve essere tra 1 e 500");
        }

        int[] values = {500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                roman.append(symbols[i]);
                number -= values[i];
            }
        }

        return roman.toString();
    }
}