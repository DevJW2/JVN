//Victor Teoh
//APCS2 pd3
//HW #06: Step 1: Split, Step 2: ?, Step 3: Sorted!
//2017-2-10    
/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  To sort a given array we return it back if it is length 1 
  else we split the array into two arrays and populate them with about a half of
  the given array each then we sort those arrays and merge them giving the
  sorted array we wanted
  To merge we add the lowest number of the two arrays until either one is
  completely interated through to the array to be returned and add the remnants of the other array
  to the array to be returned and return it
  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {int[] retarr = new int[a.length + b.length];int aindex = 0; int bindex = 0;int i = 0;
	while(aindex < a.length && bindex < b.length){
	    if (a[aindex] < b[bindex]){
		retarr[i] = a[aindex];
		aindex += 1;
	    }
	    else {
		retarr[i] = b[bindex];
		bindex += 1;
	    }
	    i += 1;
	}
	if(aindex == a.length){
	    while(i < retarr.length){
		retarr[i] = b[bindex];
		i += 1;
		bindex += 1;
	    }
	}
	else{
	    while(i < retarr.length){
		retarr[i] = a[aindex];
		i += 1;
		aindex += 1;
	    }    
	}	
	return retarr;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	if( arr.length <= 1){
	    return arr;
	}
	int ctr = 0; int[] a = new int[arr.length/2]; int[] b = new int[arr.length - arr.length/2];
	//"split" it in half, its fine if arr is an odd length
	for(int i = 0; i < arr.length/2; i++){
	    a[i] = arr[i];
	}
	for(int i = arr.length/2;  i<arr.length; i++){
	    b[ctr] = arr[i];
	    ctr += 1;
	}
	//	a = sort(a);
	//	b = sort(b);
	arr = merge(sort(a),sort(b));
	return arr;
	   
	
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	//~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );
	
	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	
	//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }//end main()

}//end class MergeSort

