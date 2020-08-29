package aircrafts;

public class Aircraft
{
	protected Coordinates coordinates;
	private static long idCounter = 0;
	protected long id;
	protected String name;
	public Aircraft(String name, Coordinates coordinates)
	{
		this.coordinates = coordinates;
		this.id = nextId();
		this.name = name;
	}
	public Coordinates getCoordinates()
	{
		return(this.coordinates);
	}
	private long nextId()
	{
		idCounter++;
		return(idCounter);
	}
	public long getId()
	{
		return(this.id);
	}
	public String getName()
	{
		return(this.name);
	}
}