////////////////////////////////////////////////////////////////////
// [Enrico] [Sorgato] [2071112]
// [Alessandro] [Bertolazzi] [1227274]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.experimental.runners.Enclosed;

@RunWith(Enclosed.class)
public class IntegerToRomanTest {

    @RunWith(Parameterized.class)
    public static class IntegerToRomanParamTests {
        private int numero;
        private String expected;

        public IntegerToRomanParamTests(int numero, String expected) {
            this.numero = numero;
            this.expected = expected;
        }

        private static String convertToRoman(int num) {
            if (num < 1 || num > 1000) return "";
            
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                while (num >= values[i]) {
                    sb.append(symbols[i]);
                    num -= values[i];
                }
            }
            return sb.toString();
        }

        @Parameterized.Parameters(name = "{0} -> {1}")
        public static Collection<Object[]> data() {
            return IntStream.rangeClosed(1, 1000)
                .mapToObj(i -> new Object[]{i, convertToRoman(i)})
                .collect(Collectors.toList());
        }

        @Test
        public void testIntegerToRomanConversion() {
            assertEquals(expected, IntegerToRoman.convert(numero));
        }
    }

    public static class IntegerToRomanEdgeTests {
        @Test(expected = IllegalArgumentException.class)
        public void testZeroThrowsException() {
            IntegerToRoman.convert(0);
        }

        @Test(expected = IllegalArgumentException.class)
        public void testNegativeThrowsException() {
            IntegerToRoman.convert(-5);
        }

        @Test(expected = IllegalArgumentException.class)
        public void testAbove1000ThrowsException() {
            IntegerToRoman.convert(1001);
        }

        @Test(expected = IllegalArgumentException.class)
        public void testGreatAbove1000ThrowsException() {
            IntegerToRoman.convert(99999);
        }

        @Test(expected = IllegalArgumentException.class)
        public void testGreatNegativeThrowsException() {
            IntegerToRoman.convert(-99999);
        }
    }
}