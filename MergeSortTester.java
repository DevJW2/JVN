//Jeffrey Weng, Noah Tang, Victor Teoh
//APCS2 pd3
//HW07 -- What Does the Data Say?
//2017-02-13

/*======================================
  class MergeSortTester

  ALGORITHM:
  Mergesort Algorithm sorts a list by splitting it into sublists, by halving the array, until it reaches a length of 1, where we can then assume it's sorted. We then merge all the sorted smaller lists in ascending order until the array is the length of the original.

  BIG-OH CLASSIFICATION OF ALGORITHM:
  nlog(n)
  At each level 
  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  n=1000    time: 
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
	int[] arr = new int[10000000];
	int[] arr1 = new int[1000];
	int[] arr2 = new int[100];
	int[] arr3 = new int[10];
	int[] arr4 = new int[1];
	for(int i = 0; i < arr.length; i++){
	    arr[i] = (int)(Math.random() * (arr.length - 1)) + 1;
	}
	for(int i = 0; i < arr1.length; i++){
	    arr1[i] = (int)(Math.random() * (arr1.length - 1)) + 1;
	}
	for(int i = 0; i < arr2.length; i++){
	    arr2[i] = (int)(Math.random() * (arr2.length - 1)) + 1;
	}
	for(int i = 0; i < arr3.length; i++){
	    arr3[i] = (int)(Math.random() * (arr3.length - 1)) + 1;
	}
	for(int i = 0; i < arr4.length; i++){
	    arr4[i] = (int)(Math.random() * (arr4.length - 1)) + 1;
	}
	int sum = 0;
	int sum1 = 0;
	int sum2 = 0;
	int sum3 = 0;
	int sum4 = 0;
	for(int i = 0; i < 10; i++){
	    long startTime = System.nanoTime();
	    test.sort(arr);
	    long endTime = System.nanoTime();
	    sum += (endTime - startTime);
	    
	    long startTime1 = System.nanoTime();
	    test.sort(arr1);
	    long endTime1 = System.nanoTime();
	    sum1 += (endTime1 - startTime1);

	    long startTime2 = System.nanoTime();
	    test.sort(arr2);
	    long endTime2 = System.nanoTime();
	    sum2 += (endTime2 - startTime2);

	    long startTime3 = System.nanoTime();
	    test.sort(arr3);
	    long endTime3 = System.nanoTime();
	    sum3 += (endTime3 - startTime3);

	    long startTime4 = System.nanoTime();
	    test.sort(arr4);
	    long endTime4 = System.nanoTime();
	    sum4 += (endTime4 - startTime4);
	}
	System.out.println("Size: 10 million");
	System.out.println("Mean Time: " + (sum/10));
	System.out.println("Size: 1000");
	System.out.println("Mean Time: " + (sum1/10));
	System.out.println("Size: 100");
	System.out.println("Mean Time: " + (sum2/10));
	System.out.println("Size: 10");
	System.out.println("Mean Time: " + (sum3/10));
	System.out.println("Size: 1");
	System.out.println("Mean Time: " + (sum4/10));
    }//end main

}//end class
