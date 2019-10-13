package de.zeeman.pattys_studies;

import java.util.Arrays;

public class PancakeSort {

    /* Reverses arr[0..i] */
    static void flip(int arr[], int i) 
    { 
    	// Generating snapshot of array before the flip
    	// to output below
    	String beforeFlip = Arrays.toString(arr);
        int temp, start = 0; 
        while (start < i) 
        { 
            temp = arr[start]; 
            arr[start] = arr[i]; 
            arr[i] = temp; 
            start++; 
            i--; 
        } 

        System.out.println(String.format("Flipped Array: %s -> %s", beforeFlip, Arrays.toString(arr)));
    } 
  
    // Returns index of the  
    // maximum element in  
    // arr[0..n-1]  
    static int findMax(int arr[], int n) 
    { 
        int mi, i; 
        for (mi = 0, i = 0; i < n; ++i) 
            if (arr[i] > arr[mi]) 
                mi = i; 
        return mi; 
    } 
  
    // The main function that 
    // sorts given array using  
    // flip operations 
    static int pancakeSort(int arr[], int n) 
    { 
    	int flips = 0;
        // Start from the complete 
        // array and one by one 
        // reduce current size by one 
        for (int curr_size = n; curr_size > 1; --curr_size) 
        { 
            // Find index of the 
            // maximum element in 
            // arr[0..curr_size-1] 
            int mi = findMax(arr, curr_size); 
  
            // Optimization 1:
            // Move the maximum element 
            // to end of current array 
            // if it's not already at  
            // the end 
            if (mi != curr_size-1) 
            { 
                // To move at the end, 
                // first move maximum 
                // number to beginning 
            	// Optimization 2:
            	// unless it is already at index position 0
            	// (so we can skip the first flip):
            	if (mi != 0) {
	                flip(arr, mi); 
	                flips++;
            	}
  
                // Now move the maximum  
                // number to end by 
                // reversing current array 
                flip(arr, curr_size-1); 
                flips++;
            } 
        } 
        return flips; 
    } 
  
    /* Driver function to check for above functions*/
    public static void main (String[] args) 
    { 
        int arr[] = {8,6,4,2,1,3,5,7}; 
        int n = arr.length; 
          
        int flips = pancakeSort(arr, n); 
          
        System.out.println("Sorted Array: "); 
        System.out.println(Arrays.toString(arr));
        System.out.println(String.format("Flips: %d", flips));
    } 
	
}
