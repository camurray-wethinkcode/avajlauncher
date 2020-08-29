package aircrafts;

public class Coordinates
{
	private int height;
	private int latitude;
	private int longitude;
	Coordinates(int height, int latitude, int longitude)
	{
		this.height = height;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public int getHeight()
	{
		return(this.height);
	}
	public int getLatitude()
	{
		return(this.latitude);
	}
	public int getLongitude()
	{
		return(this.longitude);
	}
	public void changeHeight(int height)
	{
		if(height < 101 && height > 0)
			this.height = height;
		else if (height <= 0)
			this.height = 0;
		else
			this.height = 100;
	}
	public void changeLatitude(int latitude)
	{
		this.latitude = latitude;
	}
	public void changeLongitude(int longitude)
	{
		this.longitude = longitude;
	}
}