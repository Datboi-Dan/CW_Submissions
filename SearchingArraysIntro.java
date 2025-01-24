/**
 * Hi Mr. Trauger. This class is a submission to the Searching Arrays Intro assignment.
 * MILCS
 * @author Daniel B)
 */
class SearchingArraysIntro
{

  /**
	 * 1. Create a method checkFor4() that is passed an int array and returns true if that array has a 4 and false if that array has no 4's. 
	 * @param array - The array to be checked for the number 4.
	 * @return True if the array contains a 4, and false if it does not.
	 */
	public static boolean checkFor4(int[] array)
	{
		
		//Setting it equal to array cause I'm lazy.
		int[] copyArray = array;
		
		//Represents if the array has a 4.
		boolean has4 = false;
		
		//Traverse through the array.
		for (int i = 0; i < copyArray.length; i++)
		{
			
			//Set has4 to true if the current element at index i is 4.
			if (copyArray[i] == 4)
			{
				
				has4 = true;
				
			}
			
		}
		
		return has4;
			
	}

	
	/**
	 * 2. Create a method countFor4() that is passed an int array and returns how many times 4 shows up in the array. 
	 * @param array - The array to be counted for 4.
	 * @return The number of times that 4 appears in the array.
	 */
	public static int countFor4(int[] array)
	{
		
		//Setting it equal to array cause I'm lazy.
		int[] copyArray = array;
		
		//Represents the number of 4's in the array.
		int countOf4 = 0;
		
		//Traverse through the array.
		for (int i = 0; i < copyArray.length; i++)
		{
			
			//Increment countOf4 if the current element at index i is 4.
			if (copyArray[i] == 4)
			{
				
				countOf4++;
				
			}
			
		}
		
		return countOf4;
		
	}
	
	
	/**
	 * 3. Create a method checkForFour4() that is passed an int array and return true if the array has exactly four 4's in it. 
	 * @param array - The array to be checked for four 4's.
	 * @return - True if the array has exactly four 4's, and false if not.
	 */
	public static boolean checkForFour4(int[] array)
	{
		
		//Setting it equal to array cause I'm lazy.
		int[] copyArray = array;
		
		//Represents the number of 4's in the array.
		int countOf4 = 0;
		
		//Traverse through the array.
		for (int i = 0; i < copyArray.length; i++)
		{
			
			//Increment countOf4 if the current element at index i is 4.
			if (copyArray[i] == 4)
			{
				
				countOf4++;
				
			}
			
		}
		
		//Check if there are exactly four 4's in the array. If there are, returns true, or else returns false.
		if (countOf4 == 4)
			return true;
		else
			return false;
			
	}
  
}
