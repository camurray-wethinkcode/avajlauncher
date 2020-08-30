package aircrafts;
import java.io.BufferedWriter;
import java.io.IOException;
import weather.Touch;
import weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable
{
	private BufferedWriter output = null;
	private WeatherTower weatherTower;
	Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}
	public void updateConditions(int i)
	{
		try
		{
			output = Touch.getWriter();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		String today = weatherTower.getWeather(coordinates);
		if(today == "SUN")
		{
			coordinates.changeHeight(coordinates.getHeight() + 4);
			coordinates.changeLongitude(coordinates.getLongitude() + 2);
			try
			{
				output.write("\nSimulation " + Integer.toString(i) + ": " + this.getClass().getSimpleName() + "#" + this.getName() + "     (" + this.getId() + ")" + " Another sunny day for floating! " + "(coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLongitude() + " , longitude - " + this.coordinates.getLatitude() + ")");
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		else if(today == "RAIN")
		{
			if(coordinates.getHeight() > 4)
				coordinates.changeHeight(coordinates.getHeight() - 5);
			else
				coordinates.changeHeight(0);
			try
			{
				output.write("\nSimulation " + Integer.toString(i) + ": " + this.getClass().getSimpleName() + "#" + this.getName() + "     (" + this.getId() + ")" + " I'm floating in the rain! " + "      (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLongitude() + " , longitude - " + this.coordinates.getLatitude() + ")");
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			if(coordinates.getHeight() == 0)
			{
				try
				{
					output.write("\n" + this.getClass().getSimpleName() + " #" + this.getName() + " (" + this.getId() + ")" + " Landing.... " + "                                     (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLongitude() + " , longitude - " + this.coordinates.getLatitude() + ")");
				}
				catch(IOException e)
				{
					System.out.println(e);
				}
				weatherTower.unregister(this);
			}
		}
		else if(today == "FOG")
		{
			if(coordinates.getHeight() > 2)
				coordinates.changeHeight(coordinates.getHeight() - 3);
			else
				coordinates.changeHeight(0);
			try
			{
				output.write("\nSimulation " + Integer.toString(i) + ": " + this.getClass().getSimpleName() + "#" + this.getName() + "     (" + this.getId() + ")" + " I can't see the view! " + "          (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLongitude() + " , longitude - " + this.coordinates.getLatitude() + ")");
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			if(coordinates.getHeight() == 0)
			{
				try
				{
					output.write("\n" + this.getClass().getSimpleName() + " #" + this.getName() + " (" + this.getId() + ")" + " Landing.... " + "                                       (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLongitude() + " , longitude - " + this.coordinates.getLatitude() + ")");
				}
				catch(IOException e)
				{
					System.out.println(e);
				}
				weatherTower.unregister(this);
			}
		}
		else
		{
			if(coordinates.getHeight() > 14)
				coordinates.changeHeight(coordinates.getHeight() - 15);
			else
				coordinates.changeHeight(0);
			try
			{
				output.write("\nSimulation " + Integer.toString(i) + ": " + this.getClass().getSimpleName() + "#" + this.getName() + "     (" + this.getId() + ")" + " Six feet deep in snow! " + "         (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLongitude() + " , longitude - " + this.coordinates.getLatitude() + ")");
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			if(coordinates.getHeight() == 0)
			{
				try
				{
					output.write("\n" + this.getClass().getSimpleName() + " #" + this.getName() + " (" + this.getId() + ")" + " Landing...." + "                                       (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLongitude() + " , longitude - " + this.coordinates.getLatitude() + ")");
				}
				catch(IOException e)
				{
					System.out.println(e);
				}
				weatherTower.unregister(this);
			}
		}
	}
	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
	@Override
	public String getName()
	{
		return(super.getName());
	}
	@Override
	public Coordinates getCoordinates()
	{
		return(super.getCoordinates());
	}
}
//@Override annotation informs the compiler that the element is meant to override an element declared in a superclass. Overriding methods involve Interfaces and Inheritance. While it is not required to use this annotation when overriding a method, it helps to prevent errors. In any object-oriented programming language, Overriding is a feature that allows a subclass or child class to provide a specific implementation of a method that is already provided by one of its super-classes or parent classes.