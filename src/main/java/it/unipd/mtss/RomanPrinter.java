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
        StringBuilder output = new StringBuilder();

        for (int line = 0; line < 6; line++) {
            for (char c : roman.toCharArray()) {
                switch (c) {
                    case 'I':
                        output.append(getILine(line)).append(" ");
                        break;
                    case 'V':
                        output.append(getVLine(line)).append(" ");
                        break;
                    case 'X':
                        output.append(getXLine(line)).append(" ");
                        break;
                }
            }
            output.append("\n");
        }

        return output.toString();
    }

    private static String getILine(int line) {
        String[] iArt = {
            "  _____ ",
            " |_   _|",
            "   | |  ",
            "   | |  ",
            "  _| |_ ",
            " |_____|"
        };
        return iArt[line];
    }

    private static String getVLine(int line) {
        String[] vArt = {
            "__      __",
            "\\ \\    / /",
            " \\ \\  / / ",
            "  \\ \\/ /  ",
            "   \\  /   ",
            "    \\/    "
        };
        return vArt[line];
    }

    private static String getXLine(int line) {
        String[] xArt = {
            "__   __",
            "\\ \\ / /",
            " \\ V / ",
            "  > <  ",
            " / . \\ ",
            "/_/ \\_\\"
        };
        return xArt[line];
    }
}