package weather;
import java.util.ArrayList;
import java.io.BufferedWriter;
import aircrafts.Flyable;
import java.io.IOException;
import java.util.List;

public class Tower
{
	private List<Flyable> takeoff = new ArrayList<>();
	private List<Flyable> land = new ArrayList<>();
	private BufferedWriter output = null;
	public void register(Flyable flyable)
	{
		try
		{
			output = Touch.getWriter();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		takeoff.add(flyable);
		try
		{
			output.write("\nTower says: " + flyable.getClass().getSimpleName() + "#" + flyable.getName() + " (" + flyable.getId() + ")" + " registered to the weather tower.");
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	public void unregister(Flyable flyable)
	{
		try
		{
			output.write("\nTower says: " + flyable.getClass().getSimpleName() + "#" + flyable.getName() + " (" + flyable.getId() + ")" + " unregistered from the weather tower.");
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	protected void conditionsChanged(int i)
	{
		for(Flyable flyable : takeoff)
		{
			flyable.updateConditions(i);
			if(flyable.getCoordinates().getHeight() == 0)
			{
				land.add(flyable);
			}
		}
		takeoff.removeAll(land);
	}
}