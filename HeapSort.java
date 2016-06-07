/**
 * HeapSort.java
 * Extra Credit Project - A Battle of Sorts?
 * ICS 311 - Suthers
 * This class can be called statically to execute a heap sort on a String array
 * @author Jeffrey Tamashiro
 */
public class HeapSort{
	private static int size;
    /**
     * Static method that sorts the given array in place
     * @param array String array
     */
	public static void sort(String [] array){
		size = array.length - 1;
		buildMaxHeap(array);
		for(int i = size; i > 0; i--){
			swap(array, 0, i);
			size = size - 1;
			maxHeapify(array, 0);
		}
	}
    /**
     * Returns index of parent for given index in Heap
     * @param i index in heap to find parent for
     * @return int index of parent
     */
	private static int parent(int i){
		return (i - 1) / 2;
	}
    /**
     * Returns index of left child for given index in Heap
     * @param i index in heap to find left child for
     * @return int index of left child
     */	
	private static int left(int i){
		return (2 * i ) + 1;
	}
    /**
     * Returns index of right child for given index in Heap
     * @param i index in heap to find right child for
     * @return int index of right child
     */		
	private static int right(int i){
		return (2 * i) + 2;
	}
	/**
	 * Decides if an index should be moved or not
	 * @param array String array to be heapified
	 * @param i index of target element
	 */
	private static void maxHeapify(String[] array, int i){
		int l = left(i);
		int r = right(i);
		int largest;
		String temp;
		
		if(l <= size && array[l].compareTo(array[i]) > 0){
			largest = l;
		}
		else{
			largest = i;
		}
		if(r <= size && array[r].compareTo(array[largest]) > 0){
			largest = r;
		}
		if(largest != i){
			swap(array, i, largest);
			maxHeapify(array, largest);
		}
	}
    /**
     * Creates a heap out of the array by calling maxHeapify
	 * on half of it, this saves time
     * @param array String array to build Heap on
     */
	private static void buildMaxHeap(String[] array){
		for(int i = size / 2; i >= 0; i--){
			maxHeapify(array, i);
		}
	}
    /**
     * Swaps two elements based on their indexes
     * array String array where swapped elements are located
     * @param x swap with A[y]
     * @param y swap with A[x]
     */
	private static void swap(String[] array, int x, int y){
		String temp;
		
		temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}	
}