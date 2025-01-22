/**
	 * Hi Mr. Trauger!
	 * This method is my submission to Altering Array Problem.
	 * MILCS	
	 * @param nums - The int array to be copied and subtracted by five.
	 * @return An array with elements equal to the elements in numbers, except decremented by 5.
	 */
	public static int[] subract5FromAll4(int[] nums)
	{
		
		//Make a copy of nums.
		int[] thisIsACopyOfNums = new int[nums.length];
		
		//Create a for loop that loops for the amount of items in nums.
		for (int i = 0; i < nums.length; i++)
		{
			
			//Adds the element in nums at index i, but subtracted by 5.
			thisIsACopyOfNums[i] = nums[i] - 5;
			
		}
		
		//Returns the copy.
		return thisIsACopyOfNums;
		
	}
