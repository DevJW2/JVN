//Jeffrey Weng, Noah Tang, Victor Teoh
//APCS2 pd3
//HW07 -- What Does the Data Say?
//2017-02-13

/*======================================
  class MergeSortTester

  ALGORITHM:
  Mergesort Algorithm sorts a list by splitting it into sublists, by halving the array, until it reaches a length of 1, where we can then assume it's sorted. We then merge all the sorted smaller lists in ascending order until the array is the length of the original.

  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/
import java.lang.*;

public class MergeSortTester 
{

    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/
    public static void main( String[] args ) 
    {
	MergeSort test = new MergeSort();
	int[] arr = new int[10];
	for(int i = 0; i < arr.length; i++){
	    arr[i] = (int)(Math.random() * (arr.length - 1)) + 1;
	}
	
	long startTime = System.currentTimeMillis();
	System.out.println(test.sort(arr));
	long endTime = System.currentTimeMillis();
	System.out.println("Total Time: " + (endTime - startTime));
    }//end main

}//end class
