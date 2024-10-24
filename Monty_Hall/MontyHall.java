import java.util.Scanner;

public class MontyHall 
{
	
	//Class Attributes
	
	//Instantiates 3 door objects, which will manipulated later on in the code. 
	static Door door1 = new Door(1);
	static Door door2 = new Door(2);
	static Door door3 = new Door(3);
	
	//Instantiates a scanner object that will read what the user inputs into the console.
	static Scanner myReader = new Scanner(System.in);
	
	//Instantiates a string that will later on be set to what the user inputs into the console.
	static String userInput;
	

	public static void main(String[] args) 
	{
		
		//Door is randomly picked as prize door.
		pickPrizeDoor();
		
		//Contestant picks door.
		pickUserDoor();
		
		//Host reveals a WRONG DOOR.
		openWrongDoor();
		
		//Contestant is asked to switch.
		switchDoors();
		
		//Picked door revealed.
		endGame();
		
		myReader.close();

	}
	
	
	/**
	 * This method picks a random door as the prize door.
	 */
	private static void pickPrizeDoor()
	{
		
		//Picks a random number, then decides which door to set as a prize door based on that number.
		switch ((int)(Math.random() * 3) + 1)
		{
			
		case 1:
			Door.setPrizeDoor(door1);
			break;
			
		case 2:
			Door.setPrizeDoor(door2);
			break;
			
		case 3:
			Door.setPrizeDoor(door3);
			break;
		
		}
		
	}
	
	
	/**
	 * Allows the user to pick a door.
	 */
	private static void pickUserDoor()
	{
		
		//Prompts the user to pick a door.
		System.out.println("Please pick a door. (Allowed inputs: one, two, three)");
		userInput = myReader.nextLine().toLowerCase();
		
		//If the user inputs anything other than 1, 2, or 3, the user is repeatedly prompted to input something valid until they do.
		if (!userInput.equals("one") && !userInput.equals("two") && !userInput.equals("three"))
		{
			
			System.out.println("Invalid input. Please input either: one, two, or three.");
			pickUserDoor();
			
		}
		
		//Sets an attribute in the Door class called pickedDoor as the door corresponding to the user's input.
		switch (userInput)
		{
			
		case "one":
			Door.setPickedDoor(door1);
			break;
				
		case "two":
			Door.setPickedDoor(door2);
			break;
				
		case "three":
			Door.setPickedDoor(door3);
			break;
			
		}
		
	}
	
	
	/**
	 * Reveals the door one of the wrong doors.
	 */
	private static void openWrongDoor()
	{
	
		//Iterates through an arraylist in the Door class that includes every door object that has been instantiated.
		for (Door d : Door.getDoorList())
		{
			
			//Opens the current door, then exits the loop. Ignores the current door if it is the picked door or the prize door.
			if (d == Door.getPickedDoor() || d == Door.getPrizeDoor())
			{
			
				continue;
			
			}
			else
			{
				
				d.setOpen(true);
				System.out.println("Door " + d.getDoorNumber() + " is the WRONG door.");
				break;
			
			}
			
		}
		
	}
	
	
	/**
	 * Allows the user to switch the picked door.
	 */
	private static void switchDoors()
	{
		
		//Asks the user whether to switch doors or not.
		System.out.println("Would you like to switch? (Allowed inputs: yes, no)");
		userInput = myReader.nextLine().toLowerCase();
		
		//If the user inputs anything other than yes or no, the user is repeatedly prompted to input something valid until they do.
		if (!userInput.equals("yes") && !userInput.equals("no"))
		{
			
			System.out.println("Invalid input. Please input either yes or no.");
			switchDoors();
			
		}
		
		//Iterates through an arraylist in the Door class that includes every door object that has been instantiated.
		for(Door d : Door.getDoorList())
		{
			
			//Sets the picked door as the current door. Ignores the current door if it is already the picked door or the prize door.
			if (d == Door.getPickedDoor() || d.isOpen())
			{
				
				continue;
				
			}
			else
			{
				
				Door.setPickedDoor(d);
				break;
				
			}
			
		}
		
	}
	
	
	/**
	 * Reveals the picked door.
	 */
	private static void endGame()
	{
		
		//Informs the user that they have won if the picked door is the prize door. If it is not, it informs them they have lost.
		if (Door.getPickedDoor() == Door.getPrizeDoor())
		{
			
			System.out.print("You Won");
			
		}
		else
		{
			
			System.out.print("You Lost");
			
		}
			
		
	}
	
}
