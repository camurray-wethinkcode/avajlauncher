package weather;
import aircrafts.AircraftFactory;
import aircrafts.Flyable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Start
{
	private static BufferedWriter output = null;
	private static List<Flyable> flyables = new ArrayList<Flyable>();
	private static WeatherTower weatherTower;
	public static void main(String[] args) throws InterruptedException
	{
		try
		{
			BufferedReader read = new BufferedReader(new FileReader(args[0]));
			output = Touch.getWriter();
			String next = read.readLine();
			if(next != null)
			{
				weatherTower = new WeatherTower();
				int sim = Integer.parseInt(next.split(" ")[0]);
				if(sim < 0)
				{
					System.out.println("Must have atleast one simulation! Please check input file...");
					System.exit(1);
				}
				while((next = read.readLine()) != null)
				{
					Flyable flyable = AircraftFactory.aircraftFactory(next.split(" ")[0], next.split(" ")[1], Integer.parseInt(next.split(" ")[2]), Integer.parseInt(next.split(" ")[3]), Integer.parseInt(next.split(" ")[4]));
					if(flyable == null)
					{
						System.out.println("Invalid aircraft type in input file, please double check input file, aircraft type name may also have been misspelt...");
						System.exit(1);
					}
					flyables.add(flyable);
				}
				for(Flyable flyable: flyables)
					flyable.registerTower(weatherTower);
				int i = 0;
				output.write("\n");
				while(i <= sim)
				{
					weatherTower.changeWeather(++i);
					output.write("\n");
				}
				output.close();
			}
		}
		catch(ArrayIndexOutOfBoundsException a)
		{
			System.out.println("Input submitted incorrect, segfault from array probably lol...");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("The file does not exist...");
		}
		catch(IOException io)
		{
			System.out.println("Unable to open file specified...");
		}
	}
}