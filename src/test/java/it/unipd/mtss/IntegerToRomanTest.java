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
import java.util.Arrays;
import org.junit.experimental.runners.Enclosed;

@RunWith(Enclosed.class)
public class IntegerToRomanTest
{
    @RunWith(Parameterized.class)
    public static class IntegerToRomanParamTests
    {
        private int numero;
        private String expected;

        public IntegerToRomanParamTests(int numero, String expected)
        {
            super();
            this.numero = numero;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Collection input()
        {
            return Arrays.asList(new Object[][] {{1,"I"},{2,"II"},{3,"III"},{4,"IV"},{5,"V"},{6,"VI"}});
        }

        @Test
        public void testIntegerToRomanTest()
        {
            // Arrange
            String actual = "";

            // Act
            actual = IntegerToRoman.convert(numero);

            // Assert
            assertEquals(expected, actual);
        }
    }

}