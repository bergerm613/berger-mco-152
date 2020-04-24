package berger.money;

import javax.swing.*;
import java.awt.*;

public class CashierFrame extends JFrame
{
    Cashier cashier;
    Cash customer;

    private JLabel penniesLabel;
    private JTextField pennies;
    private  JLabel nickelsLabel;
    private  JTextField nickels;
    private JLabel dimesLabel;
    private JTextField dimes;
    private JLabel quartersLabel;
    private JTextField quarters;
    private JLabel dollarsLabel;
    private JTextField dollars;
    private JLabel tensLabel;
    private JTextField tens;
    private JLabel fivesLabel;
    private JTextField fives;
    private JLabel twentiesLabel;
    private JTextField twenties;

    private JLabel total;
    private JButton clearButton;
    private JLabel priceLabel;
    private JTextField price;
    private JButton payButton;
    private JLabel change;

    private JLabel cPennies;
    private JLabel cNickels;
    private JLabel cDimes;
    private JLabel cQuarters;
    private JLabel cDollars;
    private JLabel cFives;
    private JLabel cTens;
    private JLabel cTwenties;

    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;

    public CashierFrame()
    {
        cashier = new Cashier();
        customer = new Cash();

        cashier.register.addQuarters(100);
        cashier.register.addPennies(100);

        setSize(750,300);
        setTitle("Cashier Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        penniesLabel = new JLabel("Pennies");
        pennies = new JTextField("0");
        nickelsLabel = new JLabel("Nickels");
        nickels = new JTextField("0");
        dimesLabel = new JLabel("Dimes");
        dimes = new JTextField("0");
        quartersLabel = new JLabel("Quarters");
        quarters = new JTextField("0");
        dollarsLabel = new JLabel("Dollars");
        dollars = new JTextField("0");
        fivesLabel = new JLabel("Fives");
        fives = new JTextField("0");
        tensLabel = new JLabel("Tens");
        tens = new JTextField("0");
        twentiesLabel = new JLabel("Twenties");
        twenties = new JTextField("0");

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2,8));

        topPanel.add(penniesLabel);
        topPanel.add(nickelsLabel);
        topPanel.add(dimesLabel);
        topPanel.add(quartersLabel);
        topPanel.add(dollarsLabel);
        topPanel.add(fivesLabel);
        topPanel.add(tensLabel);
        topPanel.add(twentiesLabel);
        topPanel.add(twenties);
        topPanel.add(pennies);
        topPanel.add(nickels);
        topPanel.add(dimes);
        topPanel.add(quarters);
        topPanel.add(dollars);
        topPanel.add(fives);
        topPanel.add(tens);
        topPanel.add(twenties);

        total = new JLabel("Total: $0.00");
        clearButton = new JButton("Clear");
        clearButton.addActionListener(actionEvent -> resetCashier());

        priceLabel = new JLabel("Price:");
        price = new JTextField();
        payButton = new JButton("Pay");
        payButton.addActionListener(actionEvent -> calculateCashier());
        change = new JLabel();

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4,2));

        centerPanel.add(total);
        centerPanel.add(new JLabel());
        centerPanel.add(priceLabel);
        centerPanel.add(price);
        centerPanel.add(payButton);
        centerPanel.add(clearButton);
        centerPanel.add(change);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,8));

        cPennies= new JLabel("Pennies: " + cashier.register.getPennies());
        cNickels = new JLabel("Nickels: " + cashier.register.getNickels());
        cDimes = new JLabel("Dimes: " + cashier.register.getDimes());
        cQuarters = new JLabel("Quarters: " + cashier.register.getQuarters());
        cDollars = new JLabel("Dollars: " + cashier.register.getOneDollars());
        cFives = new JLabel("Fives: " + cashier.register.getFiveDollars());
        cTens = new JLabel("Tens: " + cashier.register.getTenDollars());
        cTwenties = new JLabel("Twenties: " + cashier.register.getTwentyDollars());

        bottomPanel.add(cPennies);
        bottomPanel.add(cNickels);
        bottomPanel.add(cDimes);
        bottomPanel.add(cQuarters);
        bottomPanel.add(cDollars);
        bottomPanel.add(cFives);
        bottomPanel.add(cTens);
        bottomPanel.add(cTwenties);

        add(topPanel, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private void resetCashier()
    {
        pennies.setText("0");
        nickels.setText("0");
        dimes.setText("0");
        quarters.setText("0");
        dollars.setText("0");
        fives.setText("0");
        tens.setText("0");
        twenties.setText("0");

        total.setText("$0.00");
        change.setText("");
        price.setText("");
        customer.remove(customer.getTotal());
    }

    public void calculateCashier()
    {
        try
        {
            customer.addPennies(Integer.parseInt(pennies.getText()));
            customer.addNickels(Integer.parseInt(nickels.getText()));
            customer.addDimes(Integer.parseInt(dimes.getText()));
            customer.addQuarters(Integer.parseInt(quarters.getText()));
            customer.addOneDollars(Integer.parseInt(dollars.getText()));
            customer.addFiveDollars(Integer.parseInt(fives.getText()));
            customer.addTenDollars(Integer.parseInt(tens.getText()));
            customer.addTwentyDollars(Integer.parseInt(twenties.getText()));

            total.setText(String.format("total: $%,.2f", customer.getTotal()));

            double priceEntered = Double.parseDouble(price.getText());

            change.setText(String.format("Change given: $%,.2f", (cashier.pay(priceEntered, customer)).getTotal()));

            cPennies.setText("Pennies: " + cashier.register.getPennies());
            cNickels.setText("Nickels: " + cashier.register.getNickels());
            cDimes.setText("Dimes: " + cashier.register.getDimes());
            cQuarters.setText("Quarters: " + cashier.register.getQuarters());
            cDollars.setText("Dollars: " + cashier.register.getOneDollars());
            cFives.setText("Fives: " + cashier.register.getFiveDollars());
            cTens.setText("Tens: " + cashier.register.getTenDollars());
            cTwenties.setText("Twenties: " + cashier.register.getTwentyDollars());
        } catch (NotEnoughChangeException e)
        {
            change.setText("Error: Not enough change.");
        } catch (NumberFormatException e)
        {
            change.setText("Error: Please ensure numbers are formatted correctly.");
        }

        customer.remove(customer.getTotal());
    }

    public static void main(String[] args)
    {
        new CashierFrame().setVisible(true);
    }
}
