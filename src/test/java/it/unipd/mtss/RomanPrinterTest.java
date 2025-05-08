package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
    }

    private static String generateExpectedAscii(String roman) {
        StringBuilder expected = new StringBuilder();
        for (int line = 0; line < 6; line++) {
            for (char c : roman.toCharArray()) {
                expected.append(romanCharArt.get(c)[line]).append(" ");
            }
            expected.append("\n");
        }
        return expected.toString();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {1, generateExpectedAscii("I")},
            {2, generateExpectedAscii("II")},
            {3, generateExpectedAscii("III")},
            {4, generateExpectedAscii("IV")},
            {5, generateExpectedAscii("V")},
            {6, generateExpectedAscii("VI")},
            {7, generateExpectedAscii("VII")},
            {8, generateExpectedAscii("VIII")},
            {9, generateExpectedAscii("IX")},
            {10, generateExpectedAscii("X")}
        });
    }

    @Test
    public void testPrintAsciiArt() {
        assertEquals(expected, RomanPrinter.print(input));
    }
}