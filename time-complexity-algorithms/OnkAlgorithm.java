import java.util.Scanner;
import java.lang.Math;

class OnkAlgorithm{

	static int makeChange(int amount, int[] denom_array, int num_of_denom){

		int count = 0;

		if(amount == 0){

			return 0;
		}

		for(int i = 0; i < num_of_denom; i++){

			int current_denom = denom_array[i];

			if(current_denom < amount){

				amount = amount % current_denom;

				count = amount / current_denom;

				return count + makeChange(amount, denom_array, num_of_denom);
			}
		}

		System.out.println("Count: " + count);
		return count;
	}

	public static void main(String[] args){

	System.out.print("Enter Amount: ");
	Scanner scan = new Scanner(System.in);
	int amount = scan.nextInt();

	System.out.print("Enter the value of K: ");
	int k = scan.nextInt();

	System.out.print("Enter the value of C: ");
	int c = scan.nextInt();

	int[] denom_array = new int[k];
	int i = 0;

		while(i < k){

			denom_array[i] = (int)Math.pow(c, i);
			i++;

		}

		System.out.println(makeChange(amount, denom_array, k));
	}
}