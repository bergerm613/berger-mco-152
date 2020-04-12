package berger.weather;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

//http://api.openweathermap.org/data/2.5/weather?zip=07055,US&APPID=79f8a15bb53f09f66206a4e4187cabbe

public class CurrentWeatherFrame extends JFrame
{
    private JLabel zipLabel;
    private JTextField zip;
    private JLabel error;
    private JLabel city;
    private JLabel temp;
    private JLabel weather;
    private JLabel description;
    private JButton searchButton;
    private JButton clearButton;


    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;

    public CurrentWeatherFrame()
    {

        setSize(300,200);
        setTitle("Weather App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        zipLabel = new JLabel("Enter zip code:");
        zip = new JTextField();
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,2));
        topPanel.add(zipLabel);
        topPanel.add(zip);

        error = new JLabel();
        city = new JLabel();
        temp = new JLabel();
        weather = new JLabel();
        description = new JLabel();
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5,1));
        centerPanel.add(error);
        error.setForeground(Color.RED);
        centerPanel.add(city);
        centerPanel.add(temp);
        centerPanel.add(weather);
        centerPanel.add(description);

        searchButton = new JButton("Search");
        searchButton.addActionListener(actionEvent -> getWeatherData());
        clearButton = new JButton("Clear");
        clearButton.addActionListener(actionEvent -> reset());
        bottomPanel = new JPanel();
        bottomPanel.add(searchButton);
        bottomPanel.add(clearButton);


        add(topPanel, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private void reset()
    {
        error.setText("");
        zip.setText("");
        city.setText("");
        temp.setText("");
        weather.setText("");
        description.setText("");
    }

    public void getWeatherData()
    {
        try
        {
            GetCurrentWeather weatherData = new GetCurrentWeather();
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=" + zip.getText() + ",US&APPID=79f8a15bb53f09f66206a4e4187cabbe&units=imperial");
            CurrentWeather currWeather = weatherData.getCurrentWeather(url);
            city.setText(currWeather.name);
            temp.setText(currWeather.main.temp + " degrees");
            weather.setText(currWeather.weather[0].main + "");
            description.setText(currWeather.weather[0].description + "");
            error.setText("");
        } catch (Exception e)
        {
            reset();
            error.setText("Error occurred. Please try again.");
        }
    }

    public static void main(String[] args)
    {
        new berger.weather.CurrentWeatherFrame().setVisible(true);
    }
}

