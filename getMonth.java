/*
 * Returns the month that the user wants depending the number passed.
 * The number should correspond to the nth month, such as n = 1 referring to the 1st month, December.
*/
public static String getMonth(int n)
	{
		//Concatenates the first 6 months with the last 6 months.
		String months = "January February March April May June "
				+ "July August September October November December ";

    //Repeats the following code 12 times.
		for (int i = 1; i <= 12; i++)
		{
			// Declares a int called sL, which detects first index of a space. 
			int sL = months.indexOf(' ');

      //Returns the month if the passed variable n matches i, which corresponds to the month.
			if (n == i)
			{
        //Returns the month requested. 
				return months.substring(0, sL);
			}
      //
			else
			{
        //Removes the a month at the beginning of the list.
				months = months.substring(sL + 1);
			}
		}
		//If nothing was returned, that means their number didn't correspond to a month (was < 1 or > 12).
    //Ergo, I would return "Invalid input. Please input a number from 1 - 12 that corresponds to a month.
		return " /* What String would you put here? */ ";
		
	}
