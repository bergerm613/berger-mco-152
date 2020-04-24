package berger.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService
{
    @GET("http://api.openweathermap.org/data/2.5/weather?APPID=79f8a15bb53f09f66206a4e4187cabbe&units=imperial")
    Call<CurrentWeather> getWeather(@Query("zip") String zip);
}
