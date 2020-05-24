import java.util.Scanner;

class GreedyAlgorithmCoins{

	public static void main(String[] args){

	int dnm[] = {25, 10, 5, 1};
	int count = 0;

	System.out.print("Enter Amount: ");
	Scanner scan = new Scanner(System.in);
	int amount = scan.nextInt();

		for(int i : dnm){

			if(i <= amount && amount != 0) {

				count = amount / i;
			
			System.out.println("The amount has " + count + " times the change of " + i);

			amount = amount % i;
			}

		}
	}
}