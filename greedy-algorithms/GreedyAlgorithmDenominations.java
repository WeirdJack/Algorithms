import java.util.Scanner;
import java.lang.Math;

class GreedyAlgorithmDenominations{

	public static void main(String[] args){

	int count = 0;

	System.out.print("Enter Amount: ");
	Scanner scan = new Scanner(System.in);
	int amount = scan.nextInt();

	System.out.print("Enter the value of K: ");
	int k = scan.nextInt();

	System.out.print("Enter the value of C: ");
	int c = scan.nextInt();

	int denom = 0;

		while(k >= 0){

			denom = (int)Math.pow(c, k);
			

			if(denom <= amount && amount != 0) {

				System.out.println("Value of denom: " + denom);

				count = amount / denom;
			
			System.out.println("The amount has " + count + " times the change of " + denom);

			amount = amount % denom;
			}

			k--;

		}
	}
}