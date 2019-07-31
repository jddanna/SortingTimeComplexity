/**
 * 
 * @author Joseph D'Anna
 * @version 7/23/19
 * 
 * Sorting algorithms taken from GeeksforGeeks and manipulated for this solution
 * https://www.geeksforgeeks.org/quick-sort/
 */
public class Sorter {
	
	private Record[] unsorted;
	private final int lengthRec = 10000;
	
	public Sorter() {
		unsorted = makeRecords();
	}
	
	/**
	 * Main Method
	 * Sort
	 */
	public void sort() {
		
		System.out.println("Starting...");
		System.out.println("We have " + lengthRec + " Records to sort\n");
		
		String fastestSort = "none";
		long lowestTime = Long.MAX_VALUE;
		
		Record[] temp = deepCopy(unsorted);
		
		long timeElapsed = bubbleSort(temp);
		if (timeElapsed < lowestTime) {
			lowestTime = timeElapsed;
			fastestSort = "Bubble";
		}
		System.out.println("Bubble sort:\n" + timeElapsed + " ms");
		
		
		
		temp = deepCopy(unsorted);
		timeElapsed = insertionSort(temp);
		if (timeElapsed < lowestTime) {
			lowestTime = timeElapsed;
			fastestSort = "Insertion";
		}
		System.out.println("Insertion sort:\n" + timeElapsed + " ms");
		
		
		
		temp = deepCopy(unsorted);
		timeElapsed = selectionSort(temp);
		if (timeElapsed < lowestTime) {
			lowestTime = timeElapsed;
			fastestSort = "Selection";
		}
		System.out.println("Selection sort:\n" + timeElapsed + " ms");
		
		
		
		temp = deepCopy(unsorted);
		timeElapsed = shellSort(temp);
		if (timeElapsed < lowestTime) {
			lowestTime = timeElapsed;
			fastestSort = "Shell";
		}
		System.out.println("Shell sort:\n" + timeElapsed + " ms");
		
		
		
		temp = deepCopy(unsorted);
		timeElapsed = heapSort(temp);
		if (timeElapsed < lowestTime) {
			lowestTime = timeElapsed;
			fastestSort = "Heap";
		}
		System.out.println("Heap sort:\n" + timeElapsed + " ms");
		
		
		
		temp = deepCopy(unsorted);
		timeElapsed = quickSort(temp);
		if (timeElapsed < lowestTime) {
			lowestTime = timeElapsed;
			fastestSort = "Quick";
		}
		System.out.println("Quick sort:\n" + timeElapsed + " ms");
		
		
		System.out.println("\nThe Fastest sorting algorithm was:\n" + fastestSort + " Sort (" + lowestTime + " ms)");
		
	}
	
	public Record[] makeRecords(){
		Record[] records = new Record[lengthRec];
		
		for (int i = 0; i < lengthRec;i++) {
			records[i] = new Record();
		}
		
		return records;
	}
	
	/**
	 * 
	 * @param originalRecs
	 * @return a deep copy of the same Records array
	 */
	public Record[] deepCopy(Record[] originalRecs) {
		
		Record[] records = new Record[lengthRec];
		
		for (int i = 0; i < lengthRec;i++) {
			records[i] = new Record(originalRecs[i].getKey(),originalRecs[i].getValue());
		}
		
		return records;
	}
	
	/**
	 * bubble sort
	 * @param arr
	 * @return
	 */
	public long bubbleSort(Record[] arr) 
    { 
		long startTime = System.currentTimeMillis();
		
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) 
                { 
                    // swap arr[j+1] and arr[i] 
                    Record temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
            }
        }
        
        long endTime = System.currentTimeMillis();
        
        return endTime - startTime;
    }
	
	/**
	 * insertion sort
	 * @param arr
	 * @return
	 */
	public long insertionSort(Record arr[]) 
    { 
		long startTime = System.currentTimeMillis();
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            Record key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j].compareTo(key) > 0) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
	
	
	/**
	 * selection sort
	 * @param arr
	 * @return
	 */
	 public long selectionSort(Record[] arr) 
	    { 	 
		 	long startTime = System.currentTimeMillis();
		 	
	        int n = arr.length; 
	  
	        // One by one move boundary of unsorted subarray 
	        for (int i = 0; i < n-1; i++) 
	        { 
	            // Find the minimum element in unsorted array 
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++) 
	                if (arr[j].compareTo(arr[min_idx]) < 0)
	                    min_idx = j; 
	  
	            // Swap the found minimum element with the first 
	            // element 
	            Record temp = arr[min_idx]; 
	            arr[min_idx] = arr[i]; 
	            arr[i] = temp; 
	        } 
	        
	        long endTime = System.currentTimeMillis();
	        return endTime - startTime;
	    } 
	 
	 /**
	  * shellsort
	  * @param arr
	  * @return
	  */
	 public long shellSort(Record[] arr) 
	    { 
		 	long startTime = System.currentTimeMillis();
		 	
	        int n = arr.length; 
	  
	        // Start with a big gap, then reduce the gap 
	        for (int gap = n/2; gap > 0; gap /= 2) 
	        { 
	            // Do a gapped insertion sort for this gap size. 
	            // The first gap elements a[0..gap-1] are already 
	            // in gapped order keep adding one more element 
	            // until the entire array is gap sorted 
	            for (int i = gap; i < n; i += 1) 
	            { 
	                // add a[i] to the elements that have been gap 
	                // sorted save a[i] in temp and make a hole at 
	                // position i 
	                Record temp = arr[i]; 
	  
	                // shift earlier gap-sorted elements up until 
	                // the correct location for a[i] is found 
	                int j; 
	                for (j = i; j >= gap && arr[j-gap].compareTo(temp) > 0; j -= gap) 
	                    arr[j] = arr[j - gap]; 
	  
	                // put temp (the original a[i]) in its correct 
	                // location 
	                arr[j] = temp; 
	            } 
	        } 
	        long endTime = System.currentTimeMillis();
	        return endTime - startTime; 
	    } 
	 
	 /**
	  * heapsort
	  * @param arr
	  */
	 public long heapSort(Record[] arr) 
	    { 
		 long startTime = System.currentTimeMillis();
	        int n = arr.length; 
	  
	        // Build heap (rearrange array) 
	        for (int i = n / 2 - 1; i >= 0; i--) 
	            heapify(arr, n, i); 
	  
	        // One by one extract an element from heap 
	        for (int i=n-1; i>=0; i--) 
	        { 
	            // Move current root to end 
	            Record temp = arr[0]; 
	            arr[0] = arr[i]; 
	            arr[i] = temp; 
	  
	            // call max heapify on the reduced heap 
	            heapify(arr, i, 0); 
	        } 
	        
	        long endTime = System.currentTimeMillis();
	        return endTime - startTime; 
	    } 
	  
	 /**
	  * 
	  * @param arr
	  * @param n
	  * @param i
	  * heapify an array
	  */
	    // To heapify a subtree rooted with node i which is 
	    // an index in arr[]. n is size of heap 
	    private void heapify(Record[] arr, int n, int i) 
	    { 
	        int largest = i; // Initialize largest as root 
	        int l = 2*i + 1; // left = 2*i + 1 
	        int r = 2*i + 2; // right = 2*i + 2 
	  
	        // If left child is larger than root 
	        if (l < n && arr[l].compareTo(arr[largest]) > 0) 
	            largest = l; 
	  
	        // If right child is larger than largest so far 
	        if (r < n && arr[r].compareTo(arr[largest]) > 0) 
	            largest = r; 
	  
	        // If largest is not root 
	        if (largest != i) 
	        { 
	            Record swap = arr[i]; 
	            arr[i] = arr[largest]; 
	            arr[largest] = swap; 
	  
	            // Recursively heapify the affected sub-tree 
	            heapify(arr, n, largest); 
	        } 
	    }
	    
	    /**
	     * merge sort
	     * @param arr
	     * @param l
	     * @param m
	     * @param r
	     */
	    private void merge(Record[] arr, int l, int m, int r) 
	    { 
	        // Find sizes of two subarrays to be merged 
	        int n1 = m - l + 1; 
	        int n2 = r - m; 
	  
	        /* Create temp arrays */
	        Record[] L = new Record[n1]; 
	        Record[] R = new Record[n2]; 
	  
	        /*Copy data to temp arrays*/
	        for (int i=0; i<n1; ++i) 
	            L[i] = arr[l + i]; 
	        for (int j=0; j<n2; ++j) 
	            R[j] = arr[m + 1+ j]; 
	  
	  
	        /* Merge the temp arrays */
	  
	        // Initial indexes of first and second subarrays 
	        int i = 0, j = 0; 
	  
	        // Initial index of merged subarry array 
	        int k = l; 
	        while (i < n1 && j < n2) 
	        { 
	            if (L[i].compareTo(R[j]) <= 0) 
	            { 
	                arr[k] = L[i]; 
	                i++; 
	            } 
	            else
	            { 
	                arr[k] = R[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of L[] if any */
	        while (i < n1) 
	        { 
	            arr[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of R[] if any */
	        while (j < n2) 
	        { 
	            arr[k] = R[j]; 
	            j++; 
	            k++; 
	        } 
	    } 
	  
	    // Main function that sorts arr[l..r] using 
	    // merge() 
	    private void mergeSortHelper(Record[] arr, int l, int r) 
	    { 
	    	
	        if (l < r) 
	        { 
	            // Find the middle point 
	            int m = (l+r)/2; 
	  
	            // Sort first and second halves 
	            mergeSortHelper(arr, l, m); 
	            mergeSortHelper(arr , m+1, r); 
	  
	            // Merge the sorted halves 
	            merge(arr, l, m, r); 
	        } 

	    } 
	    
	    public long mergeSort(Record[] arr) {
	    	long startTime = System.currentTimeMillis();
	    	
	    	mergeSortHelper(arr,0,arr.length - 1);
	    	
	    	long endTime = System.currentTimeMillis();
	        return endTime - startTime; 
	    }
	    
	    
	    private int partition(Record[] arr, int low, int high) 
	    { 
	        Record pivot = arr[high];  
	        int i = (low-1); // index of smaller element 
	        for (int j=low; j<high; j++) 
	        { 
	            // If current element is smaller than or 
	            // equal to pivot 
	            if (arr[j].compareTo(pivot) <= 0) 
	            { 
	                i++; 
	  
	                // swap arr[i] and arr[j] 
	                Record temp = arr[i]; 
	                arr[i] = arr[j]; 
	                arr[j] = temp; 
	            } 
	        } 
	  
	        // swap arr[i+1] and arr[high] (or pivot) 
	        Record temp = arr[i+1]; 
	        arr[i+1] = arr[high]; 
	        arr[high] = temp; 
	  
	        return i+1; 
	    } 
	  
	  
	    /* The main function that implements QuickSort() 
	      arr[] --> Array to be sorted, 
	      low  --> Starting index, 
	      high  --> Ending index */
	    private void quickSortHelper(Record[] arr, int low, int high) 
	    { 
	        if (low < high) 
	        { 
	            /* pi is partitioning index, arr[pi] is  
	              now at right place */
	            int pi = partition(arr, low, high); 
	  
	            // Recursively sort elements before 
	            // partition and after partition 
	            quickSortHelper(arr, low, pi-1); 
	            quickSortHelper(arr, pi+1, high); 
	        } 
	    }
	    
	    /**
	     * quick sort method
	     * @param arr
	     * @return
	     */
	    public long quickSort(Record[] arr) {
	    	long startTime = System.currentTimeMillis();
	    	quickSortHelper(arr, 0, arr.length - 1);
	    	long endTime = System.currentTimeMillis();
	        return endTime - startTime; 
	    }
	    
	
}
