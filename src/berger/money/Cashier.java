package berger.money;

public class Cashier
{
    Cash register = new Cash();

    public Cash pay(double price, Cash moneyGiven) throws NotEnoughChangeException
    {
        double changeNeeded = Math.round((moneyGiven.getTotal() - price) * 100);
        changeNeeded /= 100.0;

        Cash change = register.remove(changeNeeded);

        if ((register.getTotal() < changeNeeded) || (change.getTotal() < changeNeeded))
        {
            throw new NotEnoughChangeException();
        }

        register.add(moneyGiven);

        return change;
    }
}
