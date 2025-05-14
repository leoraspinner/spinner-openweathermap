package spinner.weather;

import com.andrewoid.apikeys.ApiKey;
import io.reactivex.rxjava3.schedulers.Schedulers;

import javax.swing.*;

class Main
{
    double temp;
    //this is because in the weather object there is a main and in the main there is a temp
    //that's what we want to call

    public static void main(String[] args)
    {
        //Frame
        WeatherFrame frame = new WeatherFrame();
        frame.setVisible(true);

        WeatherServiceFactory factory = new WeatherServiceFactory();
        WeatherService service = factory.getService();

        String location = "Edison,NewJersey";
        ApiKey apiKey = new ApiKey();
        String keyString = apiKey.get();
        String units = "imperial";

        // Calls the API
        service.weatherNow(location, keyString, units)
                .subscribeOn(Schedulers.io())
                .subscribe(
                        response -> SwingUtilities.invokeLater(()
                                -> frame.setTemperature(location, response.main.temp)),
                        throwable -> SwingUtilities.invokeLater(()
                                -> frame.setError(throwable.getMessage())
                        )
                );

    }

}
