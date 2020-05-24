import java.util.Scanner;
import java.lang.Math;

class Knapsack {

	static void knapsack01(){

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the capacity of the knapsack: ");
		int capacity = scan.nextInt();

		System.out.print("Enter the total number of elements: ");
		int num_of_elements = scan.nextInt();

		int[] weights = new int[num_of_elements];
		int[] values = new int[num_of_elements];

		for(int i = 0; i < num_of_elements; i++){

			System.out.print("Enter the weight of " + i +" index element: ");
			weights[i] = scan.nextInt();
		}

		for(int i = 0; i < num_of_elements; i++){

			System.out.print("Enter the value of " + i +" index element: ");
			values[i] = scan.nextInt();
		}

		int[][] knapsack = new int[num_of_elements][capacity + 1];

		for(int j = 0; j < capacity + 1; j++){

			for(int i = 0; i < num_of_elements; i++){

				if(i == 0){

					if(j - weights[i] < 0){

						knapsack[i][j] = 0;
					System.out.println("knapsack[" + i + "][" + j + "] = " + knapsack[i][j]);
					} else if(j - weights[i] == 0){

						knapsack[i][j] = Math.max(knapsack[i][j], knapsack[i][0] + values[i]);
					System.out.println("knapsack[" + i + "][" + j + "] = " + knapsack[i][j]);
					} else{

						knapsack[i][j] = Math.max(knapsack[i][j], /*knapsack[i][j - weights[i]] results into -ve array so assigned zero value here*/0 + values[i]);
					System.out.println("knapsack[" + i + "][" + j + "] = " + knapsack[i][j]);
					}	

				}

				if(i != 0){

					if(j - weights[i] < 0){

						knapsack[i][j] = knapsack[i - 1][j];
					System.out.println("knapsack[" + i + "][" + j + "] = " + knapsack[i][j]);
					} else if(j - weights[i] == 0){

						knapsack[i][j] = Math.max(knapsack[i - 1][j], knapsack[i][0] + values[i]);
					System.out.println("knapsack[" + i + "][" + j + "] = " + knapsack[i][j]);
					} else{

						knapsack[i][j] = Math.max(knapsack[i - 1][j], knapsack[i - 1][j - weights[i]] + values[i]);
					System.out.println("knapsack[" + i + "][" + j + "] = " + knapsack[i][j]);
					}
				}

			}
		}
	}
	
	public static void main(String[] args){

		knapsack01();

	}
}