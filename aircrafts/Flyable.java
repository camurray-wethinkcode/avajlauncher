package aircrafts;
import weather.WeatherTower;

public interface Flyable
{
	public Coordinates getCoordinates();
	public long getId();
	public String getName();
	public void registerTower(WeatherTower weatherTower);
	public void updateConditions(int i);
}
//An interface is a reference type in Java. It is similar to class. It is a collection of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface. Along with abstract methods, an interface may also contain constants, default methods, static methods, and nested types.