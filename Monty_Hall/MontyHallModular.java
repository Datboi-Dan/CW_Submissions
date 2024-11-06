import java.util.Scanner;

/**
 * This class is an upgraded version of the Monty Hall project.
 * MILCS
 * @author - Daniel B)
 */
public class MontyHallModular
{
	
	//Class Attributes
	
	//Instantiates a scanner object that will read what the user inputs into the console.
	static Scanner myReader = new Scanner(System.in);
	
	//Instantiates a string that will later on be set to what the user inputs into the console.
	static String userInput;
	
	//Declares an int that represents the number of extra reveals of wrong doors that the user will get after the intial reveal.
	static int extraDoorReveals;

	
	public static void main(String[] args) 
	{
		
		//Generates a number of doors, then sets a random door as the prize door. Also sets the number of extra door reveals. 
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
	 * Generates a number of doors, then sets a random door as the prize door. Also sets the number of extra door reveals.
	 */
	private static void startGame(boolean hasFailedGeneration, boolean hasFailedSetDoorReveals)
	{
		
		//This only runs the first time the method is called.
		if (!hasFailedGeneration && !hasFailedSetDoorReveals) 
		{
			
			//Prompts the user to input how many doors they would like to play with.	
			System.out.println("How many doors would you like to play with? (Allowed inputs: Any number from 3 to 20)");
		
		}
		
		//Try-catch is obligatory as parseInt is used, which throws NumberFormatException if the input cannot be converted to an int.
		try 
		{
			
			//Skips if the user has failed to set the number of extra door reveals. (You can only fail to set extra door reveals if doors have already been generated.)
			if (!hasFailedSetDoorReveals) 
			{
				
				//Takes in user's input which will be passed into the generateDoors method to generate a number of doors.
				userInput = myReader.nextLine();
				
				//Will keep prompting the user input a number between 3 and 20 (inclusive) if their number is out of bounds.
				while (!(Integer.parseInt(userInput) >= 3 && Integer.parseInt(userInput) <= 20))
				{
				
					System.out.println("Invalid input. Please input a number from 3 to 20.");
					userInput = myReader.nextLine();
				
				}
				
				//Passes userInput into generateDoors to generate the number of doors the user wants.
				Door.generateDoors(Integer.parseInt(userInput));
				
				//Sets a the prize door as a random door from the door list.
				Door.setPrizeDoor(Door.getDoorList().get((int)(Math.random() * Door.getDoorList().size())));
				
			}
			
			//Prompts the user to set extra door reveals. (Automatically sets extra door reveals to 0 if only three doors were generated.)
			if (Door.getDoorList().size() != 3)
			{
				
				//Skips if the user has failed to set door reveals before.
				if (!hasFailedSetDoorReveals)
				{
					
					//Prompts the user to choose how many times they want a door to be revealed.
					System.out.println("How many times do you want a door to be revealed? (Allowed inputs: 1 to " + (Door.getDoorList().size() - 2) + ")");
				
				}
				//Takes in an input from the user to set the number of extra door reveals.
				userInput = myReader.nextLine();
			
				//Will keep prompting the user to input a number between one and the number of generated doors minus two if their input is out of bounds.
				while (!(Integer.parseInt(userInput) >= 1 && Integer.parseInt(userInput) <= Door.getDoorList().size() - 2))
				{
			
					System.out.println("Invalid input. Please input a number from 1 to " + (Door.getDoorList().size() - 2) + ".");
					userInput = myReader.nextLine();
			
				}
				
				//Sets the number of extra door reveals to the user's input.
				extraDoorReveals = Integer.parseInt(userInput) - 1;
				
			}
			else if (Door.getDoorList().size() == 3)
			{
				
				extraDoorReveals = 0;
				
			}
			
		
		}
		catch (Exception e)
		{
			
			//Skips if block if the door list has been successfully generated. Otherwise it assumes the user has failed to set the extra door reveals.
			if (Door.getDoorList().size() == 0)
			{
				
				System.out.println("Invalid input. Please input a number from 3 to 20.");
				
				//Runs the startGame method again with the hasFailedGeneration boolean set to true.
				startGame(true, false);
			
			}
			else
			{
				
				System.out.println("Invalid input. Please input a number from 1 to " + (Door.getDoorList().size() - 2) + ".");
				
				//Runs the startGame method again with the hasFailedSetDoorReveals boolean set to true.
				startGame(false, true);
				
			}
			
		}
		
	}
	
	
	/**
	 * Allows the user to pick a door.
	 */
	private static void pickUserDoor(boolean hasFailed)
	{
		
		//Skips if the user has failed to input a valid number.
		if (!hasFailed)
		{
			
			//Prompts the user to pick a door.
			System.out.println("Please pick a door. (Allowed inputs: Any number from 1 to " +  Door.getDoorList().size() + ")");
			
		}
		userInput = myReader.nextLine();
		
		//If the user inputs anything other than 1, 2, or 3, the user is repeatedly prompted to input something valid until they do.
		try
		{
			
			//Sets a special door in the Door clas called pickedDoor to the door from the door list with an index of userInput minus one.
			Door.setPickedDoor(Door.getDoorList().get(Integer.parseInt(userInput) - 1));
			
			
		}
		catch (Exception e)
		{
			
			System.out.println("Invalid input. Please input a number from 1 to " + Door.getDoorList().size() + ".");
			pickUserDoor(true);
			
		}
		
	}
	
	
	/**
	 * Reveals one of the wrong doors.
	 */
	private static void openWrongDoor()
	{
	
		//Picks a random door from a list of closed doors in the Door class.
		Door randomDoor = Door.getClosedDoors().get((int)(Math.random() * Door.getClosedDoors().size()));
		
		//Keeps randomizing until randomDoor is not the picked door or the prize door.
		while (randomDoor == Door.getPickedDoor() || randomDoor == Door.getPrizeDoor())
		{
			
			randomDoor = Door.getClosedDoors().get((int)(Math.random() * Door.getClosedDoors().size()));
			
		}
		
		//Opens the random door and reveals to the player that the random door is the wrong door.
		randomDoor.setOpen(true);
		System.out.println("Door " + randomDoor.getDoorNumber() + " is a WRONG door. (Reveals left: " + extraDoorReveals +")");
		
	}
	
	
	/**
	 * Allows the user to switch the picked door.
	 */
	private static void switchDoors(boolean hasFailedImmediately, boolean hasFailedLater)
	{
		
		//Skips if the user has done this part already and has failed later on in the switchDoors method.
		if (!hasFailedLater)
		{
			
			//Skips initial prompt if the user failed switchDoors immediately.
			if(!hasFailedImmediately)
			{
				
				//Asks the user whether to switch doors or not.
				System.out.println("Would you like to pick a new door? (Allowed inputs: yes, no)");
				System.out.println("You can also choose to skip all remaining door reveals. (Input: skip)");
				
			}
			userInput = myReader.nextLine().toLowerCase();
			
			//If the user inputs anything other than yes or no, the user is repeatedly prompted to input something valid until they do.
			if (!userInput.equals("yes") && !userInput.equals("no") && !userInput.equals("skip"))
			{
			
				System.out.println("Invalid input. Please input either yes, no, or skip.");
				
				//Runs the switchDoors method with has Failed immediately set to true.
				switchDoors(true, false);
			
			}
			
		}
		else
		{
			
			if (!userInput.equals("skip"))
			{
				
				userInput = "yes";
				
			}
			
		}
		
		//Runs the following code if the user wants to switch.
		if (userInput.equals("yes"))
		{
			
			//Prompts the reader to choose a new door.
			System.out.print("Please choose a new door. (Closed doors: ");
			
			//Iterates through the the list of closed doors.
			for (Door d : Door.getClosedDoors())
			{
				
				//Adds a comma at the end of each door number, unless it is the last door, in which it will end with a closed parenthesis.
				if (Door.getClosedDoors().indexOf(d) == Door.getClosedDoors().size() - 1)
				{
					
					System.out.println(d.getDoorNumber() + ")");
					
				}
				else
				{
					
					System.out.print(d.getDoorNumber() + ", ");
					
				}
				
			}
			userInput = myReader.nextLine();
			
			//Declares a boolean value isDoor and initializes it as false. Represents if the user's input corresponds to a door or not.
			boolean isDoor = false;
			
			//Will keep running while the user's input does not correspond to a door in the door list.
			while (!isDoor)
			{
				
				
				//Iterates through the door list.
				for (Door d : Door.getDoorList())
				{
				
					//Sets isDoor to true if the user's input corresponds to the current door.
					if (userInput.equals(d.getDoorNumber() + "") || userInput.equals("skip"))
					{
					
						isDoor = true;
						break;
					
					}	
				
				}
				
				//Will keep prompting the user to input a valid door number until their input corresponds to a door number.
				if (!isDoor)
				{
					
					System.out.println("Invalid input. Please input a number from 1 to " + Door.getDoorList().size() + ", or input skip.");
					userInput = myReader.nextLine();
					
				}
				
			}
			
			//Runs if the user's input corresponds to an existing door and is not picked or opened already.
			if (isDoor && !(userInput.equals(Door.getPickedDoor().getDoorNumber() + "") || Door.getDoorList().get(Integer.parseInt(userInput) - 1).isOpen()))
			{
				
				//Sets the picked door as the door corresponding to the users input.
				Door.setPickedDoor(Door.getDoorList().get(Integer.parseInt(userInput) - 1));
				
			}
			//Runs if the user's input corresponds to the door that they had previously picked.
			else if (userInput.equals(Door.getPickedDoor().getDoorNumber() + ""))
			{
				
				//Informs the user that this is the door that they have previously picked. Gives them to option to stay if their previous input was a mistake.
				System.out.println("This door was the one you previously picked. Do you want to stay on this door? (Allowed inputs: yes, no)");
				System.out.println("You can also choose to skip all remaining door reveals. (Input: skip)");
				userInput = myReader.nextLine().toLowerCase();
				
				//Will keep prompting the user to input either yes or no until their input is either yes or no.
				while (!(userInput.equals("yes") || userInput.equals("no") || userInput.equals("skip")))
				{
					
					System.out.println("Invalid input. Please input either yes, no, or skip.");
					userInput = myReader.nextLine();
					
				}
				
				//Will run the switchDoors method again with hasFailedLater set to true if the user still wants to switch.
				if (userInput.equals("no"))
				{
					
					switchDoors(false, true);
					
				}
				
			}
			//Runs if the door that they have picked is open already.
			else if (Door.getDoorList().get(Integer.parseInt(userInput) - 1).isOpen())
			{
				
				System.out.print("This door has been opened already. ");
				
				//Runs the switchDoors method again with hasFailedLater set to true.
				switchDoors(false, true);
				
			}
			
		}
		else if (userInput.equals("skip"))
		{
			
			extraDoorReveals = 0;
			
		}
		
		//Will open another wrong door and run switchDoors again as long as there are still extra door reveals.
		if (extraDoorReveals > 0)
		{
				

			//Subtracts an extra door reveal.
			extraDoorReveals--;
			
			//Opens another wrong door.
			openWrongDoor();
			
			//Allows the user to switch doors again.
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
