package berger.money;

public class Cash
{

    private int pennies, nickels, dimes, quarters, oneDollars, fiveDollars, tenDollars, twentyDollars, total;

    public double getTotal()
    {
        return total / 100.0;
    }

    public Cash remove(double amount)
    {

        amount *= 100; //I calculated everything in cents because when subtracting 2 dec. places, numbers turned bizarre
        Cash toReturn = new Cash();

        while (amount >= 2000 && twentyDollars > 0)
        {
            amount -= 2000;
            total -= 2000;
            twentyDollars--;
            toReturn.addTwentyDollars(1);
        }

        while (amount >= 1000 && tenDollars > 0)
        {
            amount -= 1000;
            total -= 1000;
            tenDollars--;
            toReturn.addTenDollars(1);
        }

        while (amount >= 500 && fiveDollars > 0)
        {
            amount -= 500;
            total -= 500;
            fiveDollars--;
            toReturn.addFiveDollars(1);
        }

        while (amount >= 100 && oneDollars > 0)
        {
            amount -= 100;
            total -= 100;
            oneDollars--;
            toReturn.addOneDollars(1);
        }

        while (amount >= 25 && quarters > 0)
        {
            amount -= 25;
            total -= 25;
            quarters--;
            toReturn.addQuarters(1);
        }

        while (amount >= 10 && dimes > 0)
        {
            amount -= 10;
            total -= 10;
            dimes--;
            toReturn.addDimes(1);
        }

        while (amount >= 5 && nickels > 0)
        {
            amount -= 5;
            total -= 5;
            nickels--;
            toReturn.addNickels(1);
        }

        while (amount >= 1 && pennies > 0)
        {
            amount -= 1;
            total -= 1;
            pennies--;
            toReturn.addPennies(1);
        }

        return toReturn;
    }

    public void add(Cash moneyToAdd)
    {
        pennies += moneyToAdd.pennies;
        nickels += moneyToAdd.nickels;
        quarters += moneyToAdd.quarters;
        oneDollars += moneyToAdd.oneDollars;
        fiveDollars += moneyToAdd.fiveDollars;
        tenDollars += moneyToAdd.tenDollars;
        twentyDollars += moneyToAdd.twentyDollars;

        total += moneyToAdd.getTotal() * 100;
    }

    public int getPennies()
    {
        return pennies;
    }

    public void addPennies(int pennies)
    {
        this.pennies += pennies;
        total += pennies;
    }

    public int getNickels()
    {
        return nickels;
    }

    public void addNickels(int nickels)
    {
        this.nickels += nickels;
        total += nickels * 5;
    }

    public int getDimes()
    {
        return dimes;
    }

    public void addDimes(int dimes)
    {
        this.dimes += dimes;
        total += dimes * 10;
    }

    public int getQuarters()
    {
        return quarters;
    }

    public void addQuarters(int quarters)
    {
        this.quarters += quarters;
        total += quarters * 25;
    }

    public int getOneDollars()
    {
        return oneDollars;
    }

    public void addOneDollars(int oneDollars)
    {
        this.oneDollars += oneDollars;
        total += oneDollars * 100;
    }

    public int getFiveDollars()
    {
        return fiveDollars;
    }

    public void addFiveDollars(int fiveDollars)
    {
        this.fiveDollars += fiveDollars;
        total += fiveDollars * 500;
    }

    public int getTenDollars()
    {
        return tenDollars;
    }

    public void addTenDollars(int tenDollars)
    {
        this.tenDollars += tenDollars;
        total += tenDollars * 1000;
    }

    public int getTwentyDollars()
    {
        return twentyDollars;
    }

    public void addTwentyDollars(int twentyDollars)
    {
        this.twentyDollars += twentyDollars;
        total += twentyDollars * 2000;
    }

    @Override
    public String toString()
    {
        return "Cash{" + "pennies=" + pennies + ", nickels=" + nickels + ", dimes=" + dimes + ", quarters=" + quarters
                + ", oneDollars=" + oneDollars + ", fiveDollars=" + fiveDollars + ", tenDollars=" + tenDollars
                + ", twentyDollars=" + twentyDollars + ", total=" + total / 100.0 + '}';
    }


}