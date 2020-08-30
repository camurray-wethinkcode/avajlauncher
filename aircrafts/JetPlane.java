package aircrafts;
import java.io.BufferedWriter;
import java.io.IOException;
import weather.Touch;
import weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable
{
	private BufferedWriter output = null;
	private WeatherTower weatherTower;
	JetPlane(String name, Coordinates coordinates)
	{
		super(name,coordinates);
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
			coordinates.changeLatitude(coordinates.getLatitude() + 10);
			try
			{
				output.write("\nSimulation " + Integer.toString(i) + ": " + this.getClass().getSimpleName() + "#" + this.getName() + "   (" + this.getId() + ")" + " Another sunny day for jetting! " + " (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLatitude() + " , longitude - " + this.coordinates.getLongitude() + ")");
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		else if(today == "RAIN")
		{
			coordinates.changeLatitude(coordinates.getLatitude() + 5);
			try
			{
				output.write("\nSimulation " + Integer.toString(i) + ": " + this.getClass().getSimpleName() + "#" + this.getName() + "   (" + this.getId() + ")" + " I'm jetting in the rain! " + "       (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLatitude() + " , longitude - " + this.coordinates.getLongitude() + ")");
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		else if(today == "FOG")
		{
			coordinates.changeLatitude(coordinates.getLatitude() + 1);
			try
			{
				output.write("\nSimulation " + Integer.toString(i) + ": " + this.getClass().getSimpleName() + "#" + this.getName() + "   (" + this.getId() + ")" + " I can't see my jet tail! " + "       (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLatitude() + " , longitude - " + this.coordinates.getLongitude() + ")");
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		else
		{
			if(coordinates.getHeight() > 6)
				coordinates.changeHeight(coordinates.getHeight() - 7);
			else
				coordinates.changeHeight(0);
			try
			{
				output.write("\nSimulation " + Integer.toString(i) + ": " + this.getClass().getSimpleName() + "#" + this.getName() + "   (" + this.getId() + ")" +" The jet is covered in snow! " + "    (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLatitude() + " , longitude - " + this.coordinates.getLongitude() + ")");
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			if(coordinates.getHeight() < 0)
			{
				try
				{
					output.write("\n" + this.getClass().getSimpleName() + "#" + this.getName() + " (" + this.getId() + ")" + " Landing... " + "                    (coordinates: height - " + this.coordinates.getHeight() + ", latitude - " + this.coordinates.getLatitude() + " , longitude - " + this.coordinates.getLongitude() + ")");
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
	public String getName()
	{
		return(super.getName());
	}
}