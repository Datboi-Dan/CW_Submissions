	/**
	 * This method is not static. What does this mean about how the method works? 
   * Answer: This means that the method is dependent on an object and its attributes, meaning you also need to call it with the object rather than the class.
   * 
   * After code tracing, also answer the following question: what does this method do?
	 * Code Tracing:
   * I decided that str = "MILCS"
   * I also decided c = 'a'
   * l = 5
   * i = 0
   * check = true (loop runs)
   * str.charAt(i) = 'M'
   * 'M' != 'c' (Nothing is returned)
   * i = 1 (Back to beginning of loop)
   * check = true (loop runs)
   * str.charAt(i) = 'I'
   * 'I' != 'c' (Nothing is returned)
   * i = 2 (Back to beginning of loop)
   * check = true (loop runs)
   * str.charAt(i) = 'L'
   * 'L' != 'c' (Nothing is returned)
   * i = 3 (Back to beginning of loop)
   * check = true (loop runs)
   * str.charAt(i) = 'C'
   * 'C' != 'c' (Nothing is returned)
   * i = 4 (Back to beginning of loop)
   * check = true (loop runs)
   * str.charAt(i) = 'S'
   * 'S' != 'c' (Nothing is returned)
   * i = 5 (Back to beginning of loop)
   * check = true (loop runs)
   * str.charAt(i) = null (Error created)
   * IndexOutOfBoundsException
   * 
   * After code tracing, I have determined that this medthod will check the object's str attribute for a passed character c.
   * If it doesn't find it, it generates an error (IndexOutOfBoundsException). This is likely unintended, as there is code to return -1 at the end.
   * This indicates that the maker intended to return -1 if c could not be found in str. It can be fixed by turning <= in the for loop condition to <.
   *
	 */
	public int doesSomething(char c)
	{
		/*
		 * This line below works even though str was not instantiated in the method. What conclusion can you draw from this fact?
		 * Answer: str is already an attribute of the object.
		 * 
		 * 
		 * 
		 * 
     */

		int l = str.length();
		
		/*
		 * Why might executing the loop below result in a syntax error?
		 * Answer: If it tries to run string.charAt(i), and i == l, it will create an IndexOutOfBounds Exception.
     * This is because it will try to look for a char at index i, but there is nothing there because l is the size of str.
		 * 
		 * 
		 */
		for (int i = 0; i <= l; i++)
		{
			
			/*
			 * What is this line checking for? What does it return if it is true?
			 * Answer: This line checks if the character at index i is equal to the passed character c.
       * If it is true, it will return that index.
       * Essentially this allows the user to check the str attribute held in the object has a certain character, which is passed in the method.
       * If it does hold the character, it returns the first index it occurs at.
			 * 
			 */
			if (str.charAt(i) == c)
			{
				return i;
			}
			
		}
		/*
		 * What is the purpose of this line below? Think about what needs to happen for it to be reached. 
		 * Answer:
     * Because this method has to return something, you need something to return if all the previous checks are false.
     * Thus, if all the characters in str are != c, the checks will all be false and return -1, telling the user the character could not be located in str.
		 * 
		 */
		return -1;
		
	}
