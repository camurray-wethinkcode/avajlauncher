package weather;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Touch extends BufferedWriter
{
	private static Touch touch = null;
	private Touch() throws IOException
	{
		super(new FileWriter("Simulation.txt"));
	}
	public static BufferedWriter getWriter() throws IOException
	{
		if(touch == null)
			touch = new Touch();
		return(touch);
	}
}
//super() used to invoke immediate parent class constructor