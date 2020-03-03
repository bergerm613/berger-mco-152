package berger.money;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MoneyTest
{
    @Test
    public void pay() throws NotEnoughChangeException
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

    @Test (expected = NotEnoughChangeException.class)
    public void payWhenBroke() throws NotEnoughChangeException
    {
        //given
        Cashier bob = new Cashier();
        Cash dollahs = new Cash();

        dollahs.addOneDollars(3);

        //when
        Cash change = bob.pay(2.49, dollahs);
    }

    @Test
    public void payInsufChange()
    {

        //given
        Cashier bob = new Cashier();
        Cash dollahs = new Cash();

        bob.register.addQuarters(100);
        dollahs.addOneDollars(3);

        double regBeforePay = bob.register.getTotal();

        try
        {
            //when
            Cash change = bob.pay(2.49, dollahs);

        } catch (NotEnoughChangeException e)
        {
            //then
            assertEquals(bob.register.getTotal(), regBeforePay, 0.01);
        }
    }
}