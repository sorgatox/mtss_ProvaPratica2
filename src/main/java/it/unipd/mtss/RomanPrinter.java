////////////////////////////////////////////////////////////////////
// [Enrico] [Sorgato] [2071112]
// [Alessandro] [Bertolazzi] [1227274]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;
 
public class RomanPrinter {
 
    public static String print(int number) {
        String roman = IntegerToRoman.convert(number);
        return printAsciiArt(roman);
    }
 
    private static String printAsciiArt(String roman) {
        String[] ascii = {
            "  _____ ",
            " |_   _|",
            "   | |  ",
            "   | |  ",
            "  _| |_ ",
            " |_____|"
        };
 
        StringBuilder output = new StringBuilder();
        for (String riga : ascii) {
            for (int i = 0; i < roman.length(); i++) {
                output.append(riga).append(" ");
            }
            output.append("\n");
        }
 
        return output.toString();
    }
}
  
