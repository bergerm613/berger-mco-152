package berger.weather;

import berger.earthquakes.CurrentEarthquakes;
import berger.earthquakes.EarthquakeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    Retrofit retrofit;

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

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
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
        WeatherService service = retrofit.create(WeatherService.class);

        service.getWeather(zip.getText() + ",US").enqueue(new Callback<CurrentWeather>()
        {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response)
            {
                CurrentWeather currentWeather = response.body();
                city.setText(currentWeather.name);
                temp.setText(currentWeather.main.temp + " degrees");
                weather.setText(currentWeather.weather[0].main + "");
                description.setText(currentWeather.weather[0].description + "");
                error.setText("");
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t)
            {
                reset();
                error.setText("Error occurred. Please try again.");
            }
        });
    }

    public static void main(String[] args)
    {
        new berger.weather.CurrentWeatherFrame().setVisible(true);
    }
}

