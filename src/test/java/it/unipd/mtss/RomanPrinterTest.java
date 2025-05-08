////////////////////////////////////////////////////////////////////
// [Enrico] [Sorgato] [2071112]
// [Alessandro] [Bertolazzi] [1227274]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RomanPrinterTest {

    private int input;
    private String expected;

    public RomanPrinterTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    // Mappa delle rappresentazioni ASCII
    private static final Map<Character, String[]> romanCharArt = new HashMap<>();
    static {
        romanCharArt.put('I', new String[]{
            "  _____ ",
            " |_   _|",
            "   | |  ",
            "   | |  ",
            "  _| |_ ",
            " |_____|"
        });

        romanCharArt.put('V', new String[]{
            "__      __",
            "\\ \\    / /",
            " \\ \\  / / ",
            "  \\ \\/ /  ",
            "   \\  /   ",
            "    \\/    "
        });

        romanCharArt.put('X', new String[]{
            "__   __",
            "\\ \\ / /",
            " \\ V / ",
            "  > <  ",
            " / . \\ ",
            "/_/ \\_\\"
        });

        romanCharArt.put('L', new String[]{
            " _      ",
            "| |     ",
            "| |     ",
            "| |     ",
            "| |____ ",
            "|______|"
        });

        romanCharArt.put('C', new String[]{
            "  _____ ",
            " / ____|",
            "| |     ",
            "| |     ",
            "| |____ ",
            " \\_____|"
        });

        romanCharArt.put('D', new String[]{
            " _____  ",
            "|  __ \\ ",
            "| |  | |",
            "| |  | |",
            "| |__| |",
            "|_____/ "
        });
    }

    private static String generateExpectedAscii(String roman) {
        StringBuilder sb = new StringBuilder();
        for (int line = 0; line < 6; line++) {
            for (char c : roman.toCharArray()) {
                sb.append(romanCharArt.get(c)[line]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String intToRoman(int num) {
        if (num < 1 || num > 500) return "";
        
        int[] values = {500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }

    @Parameterized.Parameters(name = "Test {0} -> {1}")
    public static Collection<Object[]> data() {
        return IntStream.rangeClosed(1, 500)
            .mapToObj(i -> new Object[]{i, generateExpectedAscii(intToRoman(i))})
            .collect(Collectors.toList());
    }

    @Test
    public void testPrintAsciiArt() {
        assertEquals(expected, RomanPrinter.print(input));
    }
}