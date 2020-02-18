package berger.money;

public class Cashier
{
    Cash register = new Cash();

    public Cash pay(double price, Cash moneyGiven)
    {
        double changeNeeded = Math.round((moneyGiven.getTotal() - price) * 100);
        changeNeeded /= 100.0;

        register.add(moneyGiven);

        Cash change = register.remove(changeNeeded);

        if (change.getTotal() < changeNeeded)
        {
            System.out.println("Do you have any more change on you? Here's all I got in this register.");
        }
        else if (changeNeeded < 0)
        {
            System.out.println("Sir, that is not enough money.");
        }

        return change;
    }
}
