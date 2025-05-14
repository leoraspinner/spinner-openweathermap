package spinner.weather;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface WeatherService {
    @GET("data/2.5/weather")
    Single<WeatherResponse> weatherNow(
          @Query("q") String query,         //@Query("q") this is what is in the url
          @Query("appid") String appikey,
          @Query("units") String units
    );
}
