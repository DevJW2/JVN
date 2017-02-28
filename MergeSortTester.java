
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

  Batch size: <10>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  n=1000    time: 
  ...
  n=1000000   time: 187.10117 ms

  Batch size: <# of times each dataset size was run>
  n=1       time: 1.3 x 10^-4 milliseconds
  n=10      time: 0.0011 milliseconds
  n=100     time: 0.014 milliseconds
  n=1000    time: 0.15 milliseconds
  ...
  n=<huge>  time: > 94 milliseconds


HYPOTHESIS:
Classification for MergeSort as nlog(n):

The recursive MergeSort algorithm can be broken down into
levels, each level representing a new series of recursive calls

(level) [1 2 3 4]
(level) [1 2] [3 4]
(level) [1] [2] [3] [4]

The recursive calling will repeatedly call sort() on lists of half-size
until a size of one is reached. Thus the number of levels is log base 2
of n, much like the action in binary search, in which each pass acted on
half the size before it.

ex:
A list of 100 elements will require ~eight levels, with each level handling
lists of following size:
100, 50, 25, 13, 7, 4, 2, 1

Once the recursive calling has reached size 1 lists, it will be time to
return and slowly reconstitute the sorted list step-by-step. At each level, merge() must be called on pairs of pre-sorted lists. Merge() itself is linear based on the size of its two paramater lists. The number of times it is called will be halved each time a recursive call returns.
ex:
For a list of 100 elements
at 1 element list level, it will be called 50 times
at 2 element list level, it will be called 25 times
However, the number of elements merge() is handling doubles. In the end, the calls halve each level, but the n doubles. The result is that each recursive level is a linear function of n.

Because there are log(n) recursive levels each operating at linear n time, the overall efficiency is n * log(n).


  ANALYSIS:
  Running the program, I calculated the mean of 10 runs of arrays that are in the size of 1, 10, 100, 1000, etc. Generating these
  numbers, You can find that the results is as predicted and that the 1 array list size takes around 1.3 * 10^-4 milliseconds to run. While 
  the 10 million list size takes around 99 milliseconds. While the the smaller array list sizes have means that are close to each other, the 10 million array
  list size one, can alternate from 50 milliseconds to 130 milliseconds. 
  ======================================*/
import java.lang.*;

public class MergeSortTester 
{

    /******************************
     * execution time analysis 
     * generating multiple arrays with different size lists, calculating the time for each in nanotime, converting it into 
milliseconds before then calculating the average of multiple runs. For example, with an array size of 10, calculating the 
average time mergeSort goes through, converting it from nanotime to milliseconds, then do the same procedure multile times, and
calculating the average of these runs. 
     ******************************/
    


	/*
	
	//	int[] arr = new int[1000000];
	int[] arr1a = new int[9000];
	int[] arr1b = new int[8000];
	int[] arr1c = new int[7000];
	int[] arr1d = new int[6000];
	int[] arr1e = new int[5000];
	int[] arr1f = new int[4000];
	int[] arr1g = new int[3000];
	int[] arr1h = new int[2000];
	int[] arr1i = new int[1000];
	int[] arr1 = new int[500];
	int[] arr2 = new int[100];
	int[] arr3 = new int[10];
	int[] arr4 = new int[1];
	//	for(int i = 0; i < arr.length; i++){
	//    arr[i] = (int)(Math.random() * (arr.length - 1)) + 1;
	//    }
	for(int i = 0; i < arr1.length; i++){
	    arr1a[i] = (int)(Math.random() * (arr1a.length - 1)) + 1;
	}
	for(int i = 0; i < arr1.length; i++){
	    arr1b[i] = (int)(Math.random() * (arr1b.length - 1)) + 1;
	}
	for(int i = 0; i < arr1.length; i++){
	    arr1c[i] = (int)(Math.random() * (arr1c.length - 1)) + 1;
	}
	for(int i = 0; i < arr1.length; i++){
	    arr1d[i] = (int)(Math.random() * (arr1d.length - 1)) + 1;
	}
	for(int i = 0; i < arr1.length; i++){
	    arr1e[i] = (int)(Math.random() * (arr1e.length - 1)) + 1;
	}
	for(int i = 0; i < arr1.length; i++){
	    arr1f[i] = (int)(Math.random() * (arr1f.length - 1)) + 1;
	}
	for(int i = 0; i < arr1.length; i++){
	    arr1g[i] = (int)(Math.random() * (arr1g.length - 1)) + 1;
	}
	for(int i = 0; i < arr1.length; i++){
	    arr1h[i] = (int)(Math.random() * (arr1h.length - 1)) + 1;
	}
	for(int i = 0; i < arr1.length; i++){
	    arr1i[i] = (int)(Math.random() * (arr1i.length - 1)) + 1;
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
	int sum1a = 0;
	int sum1b = 0;
	int sum1c = 0;
	int sum1d = 0;
	int sum1e = 0;
	int sum1f = 0;
	int sum1g = 0;
	int sum1h = 0;
	int sum1i = 0;
	int sum1 = 0;
	int sum2 = 0;
	int sum3 = 0;
	int sum4 = 0;
	for(int i = 0; i < 10; i++){
	   //     long startTime = System.nanoTime();
	   // test.sort(arr);
	   // long endTime = System.nanoTime();
	   // sum += (endTime - startTime);
	    
	    long startTime1a = System.nanoTime();
	    test.sort(arr1a);
	    long endTime1a = System.nanoTime();
	    sum1a += (endTime1a - startTime1a);
	    
	    long startTime1b = System.nanoTime();
	    test.sort(arr1b);
	    long endTime1b = System.nanoTime();
	    sum1b += (endTime1b - startTime1b);

	    long startTime1c = System.nanoTime();
	    test.sort(arr1c);
	    long endTime1c = System.nanoTime();
	    sum1c += (endTime1c - startTime1c);

	    long startTime1d = System.nanoTime();
	    test.sort(arr1d);
	    long endTime1d = System.nanoTime();
	    sum1d += (endTime1d - startTime1d);
	    
	    long startTime1e = System.nanoTime();
	    test.sort(arr1e);
	    long endTime1e = System.nanoTime();
	    sum1e += (endTime1e - startTime1e);
	    
	    long startTime1f = System.nanoTime();
	    test.sort(arr1f);
	    long endTime1f = System.nanoTime();
	    sum1f += (endTime1f - startTime1f);
	    
	    long startTime1g = System.nanoTime();
	    test.sort(arr1g);
	    long endTime1g = System.nanoTime();
	    sum1g += (endTime1g - startTime1g);

	    long startTime1h = System.nanoTime();
	    test.sort(arr1h);
	    long endTime1h = System.nanoTime();
	    sum1h += (endTime1h - startTime1h);

	    long startTime1i = System.nanoTime();
	    test.sort(arr1i);
	    long endTime1i = System.nanoTime();
	    sum1i += (endTime1i - startTime1i);

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
	//	System.out.println("Size: 10 million");
	//	System.out.println("Mean Time: " + (sum/10) / 1000000f); 
	System.out.println("Size: 9000"); 
	System.out.println("Mean Time: " + (sum1a/10) / 1000000f);
	System.out.println("Size: 8000"); 
	System.out.println("Mean Time: " + (sum1b/10) / 1000000f);
	System.out.println("Size: 7000"); 
	System.out.println("Mean Time: " + (sum1c/10) / 1000000f);
	System.out.println("Size: 6000"); 
	System.out.println("Mean Time: " + (sum1d/10) / 1000000f);
	System.out.println("Size: 5000"); 
	System.out.println("Mean Time: " + (sum1e/10) / 1000000f);
	System.out.println("Size: 4000"); 
	System.out.println("Mean Time: " + (sum1f/10) / 1000000f);
	System.out.println("Size: 3000"); 
	System.out.println("Mean Time: " + (sum1g/10) / 1000000f);
	System.out.println("Size: 2000"); 
	System.out.println("Mean Time: " + (sum1h/10) / 1000000f);
	System.out.println("Size: 1000"); 
	System.out.println("Mean Time: " + (sum1i/10) / 1000000f);
	System.out.println("Size: 500"); 
	System.out.println("Size: 10 million");
	System.out.println("Mean Time: " + (sum/10) / 1000000f);
	System.out.println("Size: 1000");
	System.out.println("Mean Time: " + (sum1/10) / 1000000f);
	System.out.println("Size: 100");
	System.out.println("Mean Time: " + (sum2/10) / 1000000f);
	System.out.println("Size: 10");
	System.out.println("Mean Time: " + (sum3/10) / 1000000f);
	System.out.println("Size: 1");
	System.out.println("Mean Time: " + (sum4/10) / 1000000f);
	*/

    
    public static int[] populateArr(int[] arr, int length){
	for(int i = 0; i < length; i++){
	    arr[i] = (int)(Math.random() * (length - 1)) + 1; 
	}
	return arr;
    }

    public static double calculateTime(int len){  
	int[] arr = new int[len];
	populateArr(arr, len);
	long startTime = System.nanoTime();
	MergeSort.sort(arr);
	long endTime = System.nanoTime();
	long duration = endTime - startTime;

	return duration/1000000f;
    }

    public static double calculateTimeA(int len){
	double sum = 0;
	for (int i = 0; i < 20; i++){
	    sum += calculateTime(len);
	}
	return sum/20;
    }
    public static void main( String[] args ) 
    {
	for (int i = 1; i <= 10000000; i*=10){
	    System.out.println(i + "," + calculateTimeA(i)); }
	for (int i = 1; i <= 1000; i+=10){
	   System.out.println(i + "," + calculateTimeA(i)); }
    }//end main

}//end class
