/*
 * This code takes the side length of a cube and prints out it's surface area and volume.
 */
public class Intro_Cube {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//First, we take the side length
		double side_length = 3.0;
		
		//Then we use it to calculate the surface area by multiplying it's square by 6
		double surface_area = 6*side_length*side_length;
		
		//Now we find it's volume by cubing the side length
		double volume = side_length*side_length*side_length;
		
		//Finally we print out a sentence explaining what the surface are and volume of the cube are.
		System.out.print("When the length of one side of a cube is " + (int)side_length + ", the surface area is " + (int)surface_area +" and the volume is " + (int)volume +".");
		
	}

}
