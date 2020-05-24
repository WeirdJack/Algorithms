import java.util.Scanner;

class SelectionSort {



  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    System.out.print("Enter Array Size: ");
    int size = input.nextInt();
    
    int arr[] = new int[size];

    for(int i = 0; i<size; i++){

      System.out.print("Enter value for arr["+ i + "]");
      arr[i] = input.nextInt();
    }

    DAA_Program sort = new DAA_Program();
    

    System.out.println("Selection Sort");
    System.out.print("\nUnsorted Array: ");

        for(int i = 0; i< arr.length; i++){

          System.out.print(arr[i] + " ");
        }
    sort.selectionSort(arr);
    System.out.print("\nSorted Array: ");

        for(int i = 0; i< arr.length; i++){

          System.out.print(arr[i] + " ");
        }
    System.out.print("Enter Number of Smallest Elements: ");
    int k = input.nextInt();
    
    int smallestArr[] = sort.findSmallestKElements(8, arr);
    System.out.print("\nSmallest Array: ");

        for(int i = 0; i< smallestArr.length; i++){

          System.out.print(smallestArr[i] + " ");
        }
    sort.findMedian(smallestArr);
    
  }

  int[] findSmallestKElements(int k, int arr[]){
    
    int smallestArr[] = new int[k];
    for (int i = 0; i < k; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min = i; 
            for (int j = i+1; j < arr.length; j++) 
                if (arr[j] < arr[min]) 
                    min = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min]; 
            arr[min] = arr[i]; 
            smallestArr[i] = temp; 
        }

    return smallestArr;
  }

  void findMedian(int smallestArr[]){

    float median = 0;

    if(smallestArr.length%2==0){

      median = (smallestArr[(smallestArr.length/2)-1] + smallestArr[smallestArr.length/2])/2;
    }else {
      median = smallestArr[smallestArr.length/2];
    }

    System.out.println("Median " + median);
  }

  void selectionSort(int arr[]){ 

  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < arr.length-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min = i; 
            for (int j = i+1; j < arr.length; j++) 
                if (arr[j] < arr[min]) 
                    min = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min]; 
            arr[min] = arr[i]; 
            arr[i] = temp; 
        }
    
  }
}
