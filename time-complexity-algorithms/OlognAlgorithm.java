import java.util.Scanner;

class OlognAlgorithm {

    public static void main(String args[]) 
    { 
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Array Size: ");
        int size = input.nextInt();
    
        int arr[] = new int[size];

        for(int i = 0; i<size; i++){

            System.out.print("Enter value for a["+ i + "] : ");
            arr[i] = input.nextInt();
        }

        DAA_Program3 search = new DAA_Program3();

        int index = search.searchArrayIndex(arr, 0, arr.length - 1);

        if(index==-1){

            System.out.println("Index Not Found in the given array");
        }

        System.out.println("Required Index: " + index);         
    }

    int searchArrayIndex(int arr[], int startIndex, int endIndex) 
    { 
        if(endIndex >= startIndex) 
        {    
            
            int currentIndex = (startIndex + endIndex)/2;   
            if(currentIndex == arr[currentIndex]) 
                return currentIndex;
            if(currentIndex > arr[currentIndex]) 
                return searchArrayIndex(arr, (currentIndex + 1), endIndex); 
            else
                return searchArrayIndex(arr, startIndex, (currentIndex -1)); 
        } 
        
        /* Return -1 if there is an index i such that arr[i] == i */
        return -1; 
    }  
}