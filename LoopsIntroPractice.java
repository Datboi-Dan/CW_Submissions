public class LoopsIntroPractice
{
	
	
	public static void main(String[] args)
	{
		
		System.out.println(countLetters("aaaaa", 'a'));
		System.out.println(getFactorial(5));
		System.out.println(getIfRepeats("abcde"));
		System.out.println(getIfRepeats("abcce"));
		
	}
	
	
	/**
	 * 1. Create a method countLetters() that is passed a String and a char and returns how many times that passed char shows up in the passed String. 
	 * Examples:
	 * countLetters( "abqcdqefghqqijk" , q ) -----returns----> 4
	 * countLetters ( "aaabaabaab" , b ) ----returns---> 3
	 * @return How many times the passed char shows up in the passed string.
	 */
	public static int countLetters(String input, char repeatedChar)
	{
		
		//Declares a count variable.
		int count = 0;
		
		//Iterates through the input.
		for (int i = 0; i < input.length(); i++)
		{
			
			//Adds one to the count if the current character is the character passed.
			if (input.charAt(i) == repeatedChar)
			{
				
				count++;
				
			}
			
		}
		
		//Returns count at the end.
		return count;
		
	}
	
	
	/**
	 * 2. Create a method getFactorial() that is passed an int and returns the factorial of that int (a factorial is a number multiplied by each number before it. 
	 * For example, 5! = 5 x 4 x 3 x 2 x 1)
	 * Examples:
	 * getFactorial ( 5 ) ----returns---> 120
	 * @param base - The number to be factorialed.
	 * @return The factorial of the base.
	 */
	public static int getFactorial(int base)
	{
		
		//Declares a factorial variable.
		int factorial;
		
		//Sets the factorial variable to one initially, then multiplies it by the base and lowers the base by one. Repeats until the base equals 0.
		for (factorial = 1; base != 0; base--)
		{
			
			factorial *= base;
			
		}
		
		//Returns the factorial at the end.
		return factorial;
		
	}
	
	
	/**
	 * 3. Create a method getIfRepeats() that will return true if the passed String has two of the same letter next to each other, and prints false if not.
	 * Examples:
	 * printIfRepeats ( "abcde" ) ---returns---> false
	 * printIfRepeats ( "abcce" ) ---returns---> true
	 * @return
	 */
	public static boolean getIfRepeats(String input)
	{
		
		//Declarious a char variable set equal to the first letter in the input.
		char previousLetter = input.charAt(0);
		
		//Iterates through the input starting from the second letter.
		for (int i = 1; i < input.length(); i++)
		{
			
			//Returns true if the character in the current iteration matches the character before it, and sets previousLetter to the current character otherwise.
			if (input.charAt(i) == previousLetter)
			{
				
				return true;
				
			}
			else
			{
				
				previousLetter = input.charAt(i);
				
			}
			
		}
		
		//Returns false if there were no repeating letters.
		return false;
		
	}

}
