////////////////////////////////////////////////////////////////////
// [Enrico] [Sorgato] [2071112]
// [Alessandro] [Bertolazzi] [1227274]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

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

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        String I = "  _____  \n" +
                   " |_   _| \n" +
                   "   | |   \n" +
                   "   | |   \n" +
                   "  _| |_  \n" +
                   " |_____| \n";

        String II = "  _____    _____  \n" +
                    " |_   _|  |_   _| \n" +
                    "   | |      | |   \n" +
                    "   | |      | |   \n" +
                    "  _| |_    _| |_  \n" +
                    " |_____|  |_____| \n";
       
       String III = "  _____    _____    _____  \n" +
                    " |_   _|  |_   _|  |_   _| \n" +
                    "   | |      | |      | |   \n" +
                    "   | |      | |      | |   \n" +
                    "  _| |_    _| |_    _| |_  \n" +
                    " |_____|  |_____|  |_____| \n";
       
       String IV = "  _____  __      __ \n" +
                   " |_   _| \\ \\    / / \n" +
                   "   | |    \\ \\  / /  \n" +
                   "   | |     \\ \\/ /   \n" +
                   "  _| |_     \\  /    \n" +
                   " |_____|     \\/     \n";
       
       String V = "__      __ \n" +
                  "\\ \\    / / \n" +
                  " \\ \\  / /  \n" +
                  "  \\ \\/ /   \n" +
                  "   \\  /    \n" +
                  "    \\/     \n";
       
       String VI = "__      __   _____  \n" +
                   "\\ \\    / /  |_   _| \n" +
                   " \\ \\  / /     | |   \n" +
                   "  \\ \\/ /      | |   \n" +
                   "   \\  /      _| |_  \n" +
                   "    \\/      |_____| \n";

        return Arrays.asList(new Object[][] {
            {1, I},
            {2, II},
            {3, III},
            {4, IV},
            {5, V},
            {6, VI}
        });
    }

    @Test
    public void testPrintAsciiArt() {
        assertEquals(expected, RomanPrinter.print(input));
    }
}
