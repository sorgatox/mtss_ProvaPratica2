////////////////////////////////////////////////////////////////////
// [Enrico] [Sorgato] [2071112]
// [Alessandro] [Bertolazzi] [1227274]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class IntegerToRoman {
    public static String convert(int number) {
        if (number < 1 || number > 100) {
            throw new IllegalArgumentException("Il numero deve essere tra 1 e 50");
        }

        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

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