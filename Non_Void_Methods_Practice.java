//This code is a submission to the classwork assignment: Nonvoid Methods Intro Practice
public class Non_Void_Methods_Practice {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stateName());
		System.out.println(stateEyeColor());
		System.out.println(stateHairStyle());
		System.out.println(stateBestFriend());
		System.out.println(stateFavoriteFood());
		System.out.println(printCircleStats(1));
		System.out.println(sum(1, 1));
		System.out.println(difference(1, 1));
		System.out.println(product(1, 1));
		System.out.println(quotient(1, 1));
		System.out.println(remainder(1, 1));
		
	}

	/**
	 * This method returns name.
	 */
	public static String stateName() {
		String name = "Daniel Vincent Bertubin";
		return name;
	}
	
	/**
	 * This method returns my eye color.
	 */
	public static String stateEyeColor() {
		String eyecolor = "Dark Brown";
		return eyecolor;
	}
	
	/**
	 * This method returns my hairstyle.
	 */
	public static String stateHairStyle() {
		String hairstyle = "Sidecomb";
		return hairstyle;
	}
	
	/**
	 * This method returns my best friend's name.
	 */
	public static String stateBestFriend() {
		String bestfriend = "Jesus";
		return bestfriend;
	}
	
	/**
	 * This method returns my favorite food.
	 */
	public static String stateFavoriteFood() {
		String fav_food = "Ramen";
		return fav_food;
	}
	
	/**
	 * This method returns the statistics of a circle based on the number passed to it, which is treated as the circle's radius.
	 */
	public static String printCircleStats(double radius) {
		final double pi = 3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067;
		double diameter = 2*radius;
		double circumference = 2*pi*radius;
		double area = pi*(radius*radius);
		String statement1 = "The radius of this circle is " + radius + ". ";
		String statement2 = "Thus, its diameter is " + diameter + ", its circumference is " + circumference + ", and it's area is " + area + ".";
		return statement1 + "\n" + statement2;
	}
	
	/**
	 * Calculates and returns the sum of two numbers
	 */
	public static int sum(int x, int y) {
		int z = x + y;
		return z;	
	}
	
	/**
	 * Calculates and returns the difference of two numbers
	 */
	public static int difference(int x, int y) {
		int z = x - y;
		return z;	
	}
	
	/**
	 * Calculates and returns the product of two numbers
	 */
	public static int product(int x, int y) {
		int z = x * y;
		return z;		
	}
	
	/**
	 * Calculates and returns the quotient of two numbers
	 */
	public static double quotient(int x, int y) {
		int z = x / y;
		return z;	
	}
	
	/**
	 * Calculates and returns the remainder of two numbers
	 */
	public static int remainder(int x, int y) {
		int z = x % y;
		return z;	
	}
	
}
