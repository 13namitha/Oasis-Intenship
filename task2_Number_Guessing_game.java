import java.util.Random;
import java.util.Scanner;
public class task2_Number_Guessing_game {
	private static final int MIN_RANGE=1;
	private static final int MAX_RANGE=50;
	
	public static void main(String[] args) {
		Random rand=new Random();
		Scanner scan=new Scanner(System.in);
		int number = rand.nextInt(MAX_RANGE)+MIN_RANGE;
		while(true) {
		//System.out.println("Random Number: "+ number);  //To print the random number
		System.out.println( "'Number Guessing Game!!'");
		System.out.println( "Enter gussing number between 1 to 50");
	    
	    
	    int PlayerGuess = scan.nextInt();
	    
	    if(PlayerGuess== number) {
	    	System.out.println("You got it right!! ");
	    	break;
	    }
	    	
	    else if(number > PlayerGuess) {
	    		System.out.println("Nope!! The number is larger... Guess again!!");
	    		
	    	}
	    else {
	    	System.out.println("Nope!! The number is smaller than your guess... Try Again....");
	    	
	    }
		}
	    
	    
		
	}
}
