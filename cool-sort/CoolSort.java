import java.util.*;

class CoolSort{

	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Array Size: ");
		int size = input.nextInt();
		int arr[] = new int[size];
		int subArr[] = new int[size];
		int k = 0, array_counter = 0, sub_array_counter = 0;

		for(int i = 0; i < size; i++){

			System.out.println("Enter value for a[" + i + "] : ");
			arr[i] = input.nextInt();
		}

		System.out.println("Enter Gaps Array Size: ");
		int gapsArraySize = input.nextInt();
		int gaps[] = new int[gapsArraySize];

		for(int i = 0; i<gapsArraySize; i++){
			
			System.out.println("Enter value for gaps[" + i + "] : ");
			gaps[i] = input.nextInt();

		}

		for(int p = 0; p<gaps.length; p++){

			
			for(int i = 0; i<arr.length; i++){
				int microSubArr[] = new int[size];
				int s = 0;
				for(int j=k; k<arr.length; k=k+gaps[p]){

						subArr[i] = arr[k];
						array_counter++;
						microSubArr[s] = arr[k];
						s++;
						
				}
				
				coolsort(arr, microSubArr, gaps[p], i);
				k = i + 1;
				
				if(array_counter >= arr.length){break;}
			}
			array_counter = 0;
			k=0;
		}

	
		for(int i =arr.length - 1; i >= 0; i--){

			
			System.out.println("After coolsort " + arr[i]);
		}
	}

	static void coolsort(int arr[], int subarr[], int steps, int index){

		for (int i = 1; i < subarr.length; ++i) { 
            int key = subarr[i]; 
            int j = i - 1; 

            while (j >= 0 && subarr[j] > key) {
            	
                subarr[j + 1] = subarr[j]; 
                j = j - 1; 
                 
            } 
            subarr[j + 1] = key; 
        }

        int x = 0;

        while(index < arr.length){

            arr[index] = subarr[arr.length - x - 1];
        		index = index + steps;
        		x++;
        }

        }
	}
