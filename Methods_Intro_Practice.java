//This code is a submission to the classwork assignment: Methods Intro Practice

public class Methods_Intro_Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stateName();
		stateHairStyle();
		stateFavoriteFood();
		printCircleStats(1);
		printMathStuffs(1, 2);
	}
	
	/**
	 * This method prints out my name.
	 */
	public static void stateName() {
		String name = "Daniel Vincent Bertubin";
		System.out.println(name);
	}
	
	/**
	 * This method prints out my eye color.
	 */
	public static void stateEyeColor() {
		String eyecolor = "Dark Brown";
		System.out.println(eyecolor);
	}
	
	/**
	 * This method prints out my hairstyle.
	 */
	public static void stateHairStyle() {
		String hairstyle = "Sidecomb";
		System.out.println(hairstyle);
	}
	
	/**
	 * This method prints out my best friend's name.
	 */
	public static void stateBestFriend() {
		String bestfriend = "Jesus";
		System.out.println(bestfriend);
	}
	
	/**
	 * This method prints out my favorite food.
	 */
	public static void stateFavoriteFood() {
		String fav_food = "Ramen";
		System.out.println(fav_food);
	}
	
	/**
	 * This method prints out the statistics of a circle based on the number passed to it, which is treated as the circle's radius.
	 */
	public static void printCircleStats(double radius) {
		final double pi = 3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067;
		double diameter = 2*radius;
		double circumference = 2*pi*radius;
		double area = pi*(radius*radius);
		System.out.println("The radius of this circle is " + radius + ".");
		System.out.println("Thus, its diameter is " + diameter + ", its circumference is " + circumference + ", and it's area is " + area + ".");
	}
  
	/**
	 * This method takes two numbers and adds, subtracts, multiplies, and divides them. It then prints out the results.
	 */
	public static void printMathStuffs(int num1, int num2) {
		int sum = num1 + num2;
		int difference = num1 - num2;
		int product = num1 * num2;
		int quotient = num1 / num2;
		int remainder = num1 % num2;
		System.out.println(num1 + " + " + num2 + " = " + sum);
		System.out.println(num1 + " - " + num2 + " = " + difference);
		System.out.println(num1 + " * " + num2 + " = " + product);
		System.out.println(num1 + " / " + num2 + " = " + quotient);
		System.out.println("The remainder of " + num1 + " / " + num2 + " is " + remainder + ".");
	}
}
