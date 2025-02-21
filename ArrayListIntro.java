import java.util.ArrayList;

public class ArrayListIntro
{

	public static void main(String[] args)
	{
		
		/**
		 * (For the following problems, you should be printing the whole ArrayList to make sure it worked)
		 * 1. Instantiate an empty ArrayList that could have any type in it.
		 * 2. Instantiate an empty ArrayList called intArrList that specifically stores ints. Repeat this for Strings.
		 * 3. Add 1, 2, and 3 to your intArrList one at a time so that its values are {1, 2, 3}. Then add elements to stringArrList so its values are {"Alice , "Bob" , "Charlie"}
		 * 4. Add 5 to your intArrList so that its values are now {1, 2, 5, 3}. Then add "Derek" to your stringArrList so its values are {"Alice" , "Derek" , "Bob" , "Charlie"}
		 * 5. Print out the second and last elements in both intArrList and stringArrList.
		 * 6. Change the first element in intArrList to 0, and change the first element in stringArrList to "Zero". Print out the first element in each array before and after the change. 
		 * 7. Delete the last element in both arrays. Print out what that removed element was. 
		 */
		
		//1. Instantiate an empty ArrayList that could have any type in it. (This bothers me.)
		ArrayList variableArrayList = new ArrayList();
		//Check
		System.out.println(variableArrayList);
		
		//2. Instantiate an empty ArrayList called intArrList that specifically stores ints. Repeat this for Strings.
		ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
		ArrayList<String> stringArrayList = new ArrayList<String>();
		
		//Check
		System.out.println(integerArrayList);
		System.out.println(stringArrayList);
		
		//3. Add 1, 2, and 3 to your intArrList one at a time so that its values are {1, 2, 3}. Then add elements to stringArrList so its values are {"Alice , "Bob" , "Charlie"}
		for(int i = 1; i <= 3; i++)
		{
			integerArrayList.add(i);
			
		}
		//Check
		System.out.println(integerArrayList);
		
		//We never get D :(
		stringArrayList.add("Alice");
		stringArrayList.add("Bob");
		stringArrayList.add("Charlie");
		//Check
		System.out.println(stringArrayList);
		
		//4. Add 5 to your intArrList so that its values are now {1, 2, 5, 3}. Then add "Derek" to your stringArrList so its values are {"Alice" , "Derek" , "Bob" , "Charlie"}
		integerArrayList.add(2, 5);
		//Check
		System.out.println(integerArrayList);
		
		stringArrayList.add(1, "Derek");
		//Check
		System.out.println(stringArrayList);
		
		//5. Print out the second and last elements in both intArrList and stringArrList.
		System.out.println(integerArrayList.get(1) + ", " + integerArrayList.get(integerArrayList.size() - 1));
		System.out.println(stringArrayList.get(2) + ", " + stringArrayList.get(stringArrayList.size() - 1));
		
		//6. Change the first element in intArrList to 0, and change the first element in stringArrList to "Zero". Print out the first element in each array before and after the change.
		System.out.println(integerArrayList.get(0));
		integerArrayList.set(0, 0);
		System.out.println(integerArrayList.get(0));
		
		System.out.println(stringArrayList.get(0));
		stringArrayList.set(0, "Zero");
		System.out.println(stringArrayList.get(0));
		
		//Check
		System.out.println(integerArrayList);
		System.out.println(stringArrayList);
		
		//7. Delete the last element in both arrays. Print out what that removed element was.
		System.out.println(integerArrayList.remove(integerArrayList.size() - 1));
		System.out.println(stringArrayList.remove(stringArrayList.size() - 1));
		
		//Check
		System.out.println(integerArrayList);
		System.out.println(stringArrayList);
		
	}
	
}
