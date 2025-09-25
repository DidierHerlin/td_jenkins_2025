package Money;

import static org.junit.Assert.*;
import org.junit.Test;

public class MoneyTest {

    @Test
    public void testSimpleAdd() {
        Money m12CHF = new Money(12, "CHF");
        Money m14CHF = new Money(14, "CHF");
        Money expected = new Money(26, "CHF");
        IMoney result = m12CHF.add(m14CHF);
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDifferentCurrencyThrowsException() {
        Money m10EUR = new Money(10, "EUR");
        Money m14CHF = new Money(14, "CHF");
        m10EUR.add(m14CHF); // Doit lancer une exception !
    }
}
