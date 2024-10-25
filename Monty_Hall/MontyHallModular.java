import java.util.Scanner;
import java.util.ArrayList;

public class MontyHallModular
{
	
	//Class Attributes
	
	//Instantiates a scanner object that will read what the user inputs into the console.
	static Scanner myReader = new Scanner(System.in);
	
	//Instantiates a string that will later on be set to what the user inputs into the console.
	static String userInput;
	
	static int extraDoorReveals;

	
	public static void main(String[] args) 
	{
		
		//Door is randomly picked as prize door.
		startGame(false, false);
		
		//Contestant picks door.
		pickUserDoor(false);
		
		//Host reveals a WRONG DOOR.
		openWrongDoor();
		
		//Contestant is asked to switch.
		switchDoors(false, false);
		
		//Picked door revealed.
		endGame();
		
		myReader.close();

	}
	
	
	/**
	 * This method picks a random door as the prize door.
	 */
	private static void startGame(boolean hasFailedGeneration, boolean hasFailedSetDoorReveals)
	{
		
		if (!hasFailedGeneration && !hasFailedSetDoorReveals)
		{
			
		System.out.println("How many doors would you like to play with? (Allowed inputs: Any number from 3 to 20)");
		
		}
		if (!hasFailedSetDoorReveals)
		{
			
			userInput = myReader.nextLine();
			
		}
		
		try
		{
			
			if (!hasFailedSetDoorReveals)
			{
				
				while (!(Integer.valueOf(userInput) >= 3 && Integer.valueOf(userInput) <= 20))
				{
				
					System.out.println("Invalid input. Please input a number from 3 to 20.");
					userInput = myReader.nextLine();
				
				}
				
				Door.generateDoors(Integer.valueOf(userInput));
				
				//Sets a the prize door as a random door from the door list.
				Door.setPrizeDoor(Door.getDoorList().get((int)(Math.random() * Door.getDoorList().size())));
				
			}
			
			if (Door.getDoorList().size() != 3)
			{
				
				if (!hasFailedSetDoorReveals)
				{
					
					System.out.println("How many times do you want a door to be revealed? (Allowed inputs: 1 to " + (Door.getDoorList().size() - 2) + ")");
				
				}
				userInput = myReader.nextLine();
			
				while (!(Integer.valueOf(userInput) >= 1 && Integer.valueOf(userInput) <= Door.getDoorList().size() - 2))
				{
			
					System.out.println("Invalid input. Please input a number from 1 to " + (Door.getDoorList().size() - 2) + ".");
					userInput = myReader.nextLine();
			
				}
				
				extraDoorReveals = Integer.valueOf(userInput) - 1;
				
			}
			else if (Door.getDoorList().size() == 3)
			{
				
				extraDoorReveals = 0;
				
			}
			
		
		}
		catch (Exception e)
		{
			
			if (Door.getDoorList().size() == 0)
			{
				
				System.out.println("Invalid input. Please input a number from 3 to 20.");
				startGame(true, false);
			
			}
			else
			{
				
				System.out.println("Invalid input. Please input a number from 1 to " + (Door.getDoorList().size() - 2) + ".");
				startGame(false, true);
				
			}
			
		}
		
	}
	
	
	/**
	 * Allows the user to pick a door.
	 */
	private static void pickUserDoor(boolean hasFailed)
	{
		
		if (!hasFailed)
		{
			
			//Prompts the user to pick a door.
			System.out.println("Please pick a door. (Allowed inputs: Any number from 1 to " +  Door.getDoorList().size() + ")");
			
		}
		userInput = myReader.nextLine();
		
		//If the user inputs anything other than 1, 2, or 3, the user is repeatedly prompted to input something valid until they do.
		try
		{
			
			Door.setPickedDoor(Door.getDoorList().get(Integer.valueOf(userInput) - 1));
			
			
		}
		catch (Exception e)
		{
			
			System.out.println("Invalid input. Please input a number from 1 to " + Door.getDoorList().size() + ".");
			pickUserDoor(true);
			
		}
		
	}
	
	
	/**
	 * Reveals the door one of the wrong doors.
	 */
	private static void openWrongDoor()
	{
	
		ArrayList<Door> validDoors = new ArrayList<Door>();
		for (Door d : Door.getDoorList())
		{
			
			if (!(d == Door.getPickedDoor() || d == Door.getPrizeDoor() || d.isOpen()))
			{
				
				validDoors.add(d);
				
			}
			
		}
		
		//Picks a random door from the door list.
		Door randomDoor = validDoors.get((int)(Math.random() * validDoors.size()));
		
		//Opens the random door and reveals to the player that the random door is the wrong door.
		randomDoor.setOpen(true);
		System.out.println("Door " + randomDoor.getDoorNumber() + " is the WRONG door.");
		
	}
	
	
	/**
	 * Allows the user to switch the picked door.
	 */
	private static void switchDoors(boolean hasFailedImmediately, boolean hasFailedLater)
	{
		
		if (!hasFailedLater)
		{
			
			if(!hasFailedImmediately)
			{
				
				//Asks the user whether to switch doors or not.
				System.out.println("Would you like to pick a new door? (Allowed inputs: yes, no)");
				
			}
			userInput = myReader.nextLine().toLowerCase();
			
			//If the user inputs anything other than yes or no, the user is repeatedly prompted to input something valid until they do.
			if (!userInput.equals("yes") && !userInput.equals("no"))
			{
			
				System.out.println("Invalid input. Please input either yes or no.");
				switchDoors(true, false);
			
			}
			
		}
		else
		{
			
			userInput = "yes";
			
		}
		
		//Runs the following code if the user wants to switch.
		if (userInput.equals("yes"))
		{
			
			System.out.println("Please choose a new door:");
			userInput = myReader.nextLine();
			
			boolean isDoor = false;
			
			while (!isDoor)
			{
				
				for (Door d : Door.getDoorList())
				{
				
					if (userInput.equals(d.getDoorNumber() + ""))
					{
					
						isDoor = true;
						break;
					
					}	
				
				}
				if (!isDoor)
				{
					
					System.out.println("Invalid input. Please input a number from 1 to " + Door.getDoorList().size() + ".");
					userInput = myReader.nextLine();
					
				}
				
			}
			if (isDoor && !userInput.equals(Door.getPickedDoor().getDoorNumber() + "") && !Door.getDoorList().get(Integer.valueOf(userInput) - 1).isOpen())
			{
				
				Door.setPickedDoor(Door.getDoorList().get(Integer.valueOf(userInput) - 1));
				
			}
			else if (userInput.equals(Door.getPickedDoor().getDoorNumber() + ""))
			{
				
				System.out.println("This door was the one you previously picked. Do you want to stay on this door? (Allowed inputs: yes, no)");
				userInput = myReader.nextLine().toLowerCase();
				
				while (!userInput.equals("yes") && !userInput.equals("no"))
				{
					
					System.out.println("Invalid input. Please input either yes or no.");
					userInput = myReader.nextLine();
					
				}
				
				if (userInput.equals("no"))
				{
					
					switchDoors(false, true);
					
				}
				
			}
			else if (Door.getDoorList().get(Integer.valueOf(userInput) - 1).isOpen())
			{
				
				System.out.print("This door has been opened already. ");
				switchDoors(false, true);
				
			}
			
			
		}
		
		if (extraDoorReveals > 0)
		{
				
			extraDoorReveals--;
			openWrongDoor();
			switchDoors(false, false);
			
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
			
			System.out.println("You Won");
			System.out.print("The winning door was Door " + Door.getPrizeDoor().getDoorNumber());
			
		}
		else
		{
			
			System.out.println("You Lost");
			System.out.print("The winning door was Door " + Door.getPrizeDoor().getDoorNumber());
			
		}
			
		
	}
	
}
