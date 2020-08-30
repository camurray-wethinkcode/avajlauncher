package aircrafts;
import java.io.BufferedWriter;
import weather.Touch;
import java.io.IOException;
import weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable
{
	private BufferedWriter output = null;
	private WeatherTower weatherTower;
	Helicopter(String name, Coordinates coordinates)
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
			coordinates.changeHeight(coordinates.getHeight() + 2);
			coordinates.changeLongitude(coordinates.getLongitude() + 10);
			try
			{
				output.write("\nSimulation " + Integer.toString(i) + ": " + this.getClass().getSimpleName() + "#" + this.getName() + " (" + this.getId() + ")" + " Another sunny day for hovering! " + "(coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLatitude() + " , longitude - " + this.coordinates.getLongitude() + ")");
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		else if(today == "RAIN")
		{
			coordinates.changeLongitude(coordinates.getLongitude() + 5);
			try
			{
				output.write("\nSimulation " + Integer.toString(i) + ": " + this.getClass().getSimpleName() + "#" + this.getName() + " (" + this.getId() + ")" + " I'm hovering in the rain! " + "      (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLatitude() + " , longitude - " + this.coordinates.getLongitude() + ")");
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		else if(today == "FOG")
		{
			coordinates.changeLongitude(coordinates.getLongitude() + 1);
			try
			{
				output.write("\nSimulation " + Integer.toString(i) + ": " + this.getClass().getSimpleName() + "#" + this.getName() + " (" + this.getId() + ")" + " I can't see my hover blades! " + "   (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLatitude() + " , longitude - " + this.coordinates.getLongitude() + ")");
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		else
		{
			if(coordinates.getHeight() > 11)
				coordinates.changeHeight(coordinates.getHeight() - 12);
			else
				coordinates.changeHeight(0);
			try
			{
				output.write("\nSimulation " + Integer.toString(i) + ": " + this.getClass().getSimpleName() + "#" + this.getName() + " (" + this.getId() + ")" + " Hover blades covered in snow! " + "  (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLatitude() + " , longitude - " + this.coordinates.getLongitude() + ")");
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			if(coordinates.getHeight() == 0)
			{
				try
				{
					output.write("\n" + this.getClass().getSimpleName() + " #" + this.getName() + " (" + this.getId() + ")" + " Landing... " + "                                   (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLatitude() + " , longitude - " + this.coordinates.getLongitude() + ")");
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
	public Coordinates getCoordinates()
	{
		return(super.getCoordinates());
	}
	@Override
	public long getId()
	{
		return(super.getId());
	}
	@Override
	public String getName()
	{
		return(super.getName());
	}
}