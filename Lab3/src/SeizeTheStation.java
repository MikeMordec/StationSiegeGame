import java.util.Random;
import java.util.Scanner;

public class SeizeTheStation {
	public static void main(String args[]) {
		// declare a Scanner class object and Random class object
		Scanner scan = new Scanner(System.in);
		Random randomGen = new Random();
		// variable to decrease distance to target
		int randAddDist = 0;
		// variable to track remaining distance to target
		int randDistToMove = 0;
		// variable to use to supplement player / game interaction
		int randInteract = 0;
		// variable to define player obstacle
		char interact = '\0';
		// variable to allow player to proceed to target
		char again = '\0';
		// variable to set initial distance to goal
		int goal = 300;
		// variable to set initial player health
		int health = 100;
		// define a loop for at most twenty actions
		int count = 0;
		int speed = 1;
		while (health > 0 && goal > 0) {
			count++;
			// signal the intention of the player
			System.out.println("\n-----------------------------------");
			System.out.println("Count:" + count);
			System.out.println("Goal:" +  goal);
			System.out.println("Health:" + health);
			System.out.println("Speed:" + speed);
			System.out.println("\nAre you ready to proceed? ( Y or N )");
			
			again = scan.next().charAt(0);
			if (again != 'Y' && again != 'y')
				break;
			// define an obstacle
			interact = (char) (randomGen.nextInt(26) + 'a');
			if (interact >= 'a' && interact <= 'm') {
				// random number sets distance to move toward the objective
				randDistToMove = 1 + randomGen.nextInt(20)*speed;
				System.out.println("move forward " + randDistToMove + "ft");
				goal -= randDistToMove;
			} else {
				System.out.println("circumvent the next obstacle");
				health -= 10;
			}
			if(health <= 0) {
				System.out.println("You died!");
			}
			if(goal <= 0) {
				System.out.println("You captured the station");
			}
			if(count > 5)
			{
				speed = 2;
			}
				
		}
		System.out.println("Done!");
	}
}