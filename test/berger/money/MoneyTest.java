package berger.money;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MoneyTest
{
    @Test
    public void pay()
    {
        //given
        Cashier bob = new Cashier();
        Cash dollahs = new Cash();

        bob.register.addQuarters(100);
        bob.register.addPennies(100);

        dollahs.addOneDollars(3);

        //when
        Cash change = bob.pay(2.49, dollahs);

        //then
        assertEquals(change.getTotal(), 0.51, 0.01);
    }

}