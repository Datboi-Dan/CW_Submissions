import java.util.ArrayList;

/**
 * This class creates Door objects for the Monty Hall game.
 * MILCS
 * @author Daniel B)
 */
public class Door 
{
	
	//Class Attributes
	
	//Boolean representing whether the door is open or not.
	private boolean isOpen;
	
	//Special doors representing the door that has a prize behind it and the door that the user has picked, respectively.
	private static Door prizeDoor;
	private static Door pickedDoor;
	
	//The door's door number.
	private int doorNumber;
	
	//A list of all the doors that have been instantiated.
	private static ArrayList<Door> doorList = new ArrayList<Door>();
	private static ArrayList<Door> closedDoors = new ArrayList<Door>();
	
	//----------------------------------------------------------------------------------------------------
	
	//Constructor
	
	/**
	 * Creates a door object. 
	 * @param doorNumber - The number of the door.
	 */
	public Door(int doorNumber) 
	{
		
		isOpen = false;
		this.doorNumber = doorNumber;
		doorList.add(this);
		closedDoors.add(this);
		
	}
	
	//----------------------------------------------------------------------------------------------------
	
	//Functionalities
	
	/**
	 * Generates a number of door objects.
	 * @param doors - The number of door objects to be generated.
	 */
	public static void generateDoors(int doors)
	{
		
		for (int i = 1; i <= doors; i++)
		{
			
			new Door(i);
			
		}
		
	}
	
	/**
	 * Gets the door number.
	 * @return The door number.
	 */
	public int getDoorNumber() 
	{
		
		return doorNumber;
	
	}

	
	/**
	 * Tells whether the door is open.
	 * @return The value of isOpen for the door.
	 */
	public boolean isOpen() 
	{
		
		return isOpen;
		
	}

	
	/**
	 * Sets a door to either open or closed.
	 * @param isOpen - A boolean representing if the door is open. True means the door is open, false means the door is closed.
	 */
	public void setOpen(boolean isOpen) 
	{
		
		
		this.isOpen = isOpen;
		if (isOpen)
		{
			
			closedDoors.remove(this);
			
		}
		else
		{
			
			closedDoors.add(this);
			
		}
		
		
	}


	/**
	 * Gets the door that the user picked.
	 * @return The picked door.
	 */
	public static Door getPickedDoor() 
	{
		
		return pickedDoor;
		
	}


	/**
	 * Sets the door picked door to a door.
	 * @param door - The door to be set as picked by the user.
	 */
	public static void setPickedDoor(Door door) 
	{
		
		pickedDoor = door;
		
	}
	
	
	/**
	 * Gets the door with a prize behind it.
	 * @return The prize door.
	 */
	public static Door getPrizeDoor() 
	{
		
		return prizeDoor;
		
	}


	/**
	 * Sets the prize door as a door.
	 * @param door - The door to be set as having a prize behind it.
	 */
	public static void setPrizeDoor(Door door) 
	{
		
		prizeDoor = door;
		
	}
	
	
	/**
	 * Gets the list of doors that have been instantiated.
	 * @return The door list.
	 */
	public static ArrayList<Door> getDoorList() 
	{
		
		return doorList;
		
	}

	
	/**
	 * Gets the list of closed doors.
	 * @return The closed door list.
	 */
	public static ArrayList<Door> getClosedDoors() 
	{
		
		return closedDoors;
	
	}
	
}
