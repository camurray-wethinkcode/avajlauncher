package weather;
import aircrafts.Coordinates;
import java.util.Random;

public class WeatherProvider
{
	private static String[] weather = {"FOG", "RAIN", "SNOW", "SUN"};
	private static final WeatherProvider weatherProvider = new WeatherProvider();
	public static WeatherProvider getProvider()
	{
		return(WeatherProvider.weatherProvider);
	}
	public String getCurrentWeather(Coordinates coordinates)
	{
		Random rand = new Random();
		int upperbound = 25;
		int int_random = rand.nextInt(upperbound);
		int index = (coordinates.getLatitude() + coordinates.getHeight() + coordinates.getLongitude() + int_random) % 4;
		return(weather[index]);
	}
}
//final is there to make sure subclasses are not overwriting value which is an error that does pop up??? final is not in uml diagram...change made by me to avoid error :)