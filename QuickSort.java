/**
 * QuickSort.java
 * Extra Credit Project - A Battle of Sorts?
 * ICS 311 - Suthers
 * This class can be called statically to execute a quick sort on a String array
 * @author Jeffrey Tamashiro
 */
public class QuickSort{
    /**
     * Static method that sorts the given array in place
     * @param array String array
     */
	public static void sort(String [] array){
		int size = array.length;
		
		quickSort(array, 0, size - 1);
	
	}
    /**
     * Partitions a conceptual array by choosing a pivot randomly
	 * and goes through each element moving them either to the left or to the
	 * right of the pivot.
     * @param p left bound on conceptual piece of array
     * @param r right bound on conceptual piece of array
     * @return int pivot index, basically says everything to the left of me stays on the left,
	 * everything to the right stays right, and I'm in the perfect spot.
     */
	private static int partition(String[] arr, int p, int r){
		int rand = randInt(p, r);
		swap(arr, rand, r);
		
		String x = arr[r];
		int i = p - 1;
		for(int j = p; j < r; j++){
			if(x.compareTo(arr[j]) >= 0){
				swap(arr, ++i, j);
			}
		}
		swap(arr, i + 1, r);
		return i + 1;
	}
    /**
     * Recursive method that calls on itself by selecting a pivot and partitioning
	 * elements between it.
     * @param arr String array to be quick sorted
     * @param p left bound on conceptual piece of array
     * @param r right bound on conceptual piece of array
     */
	private static void quickSort(String[] arr, int p, int r){
		int q;
		if(p < r){
			q = partition(arr, p, r);
			quickSort(arr, p, q - 1);
			quickSort(arr, q + 1, r);
		}
	
	}
    /**
     * Generates a random integer between two integers inclusive
	 * uses java's Math.random method
     * @param x lower bound inclusive
     * @param y upper bound inclusive
     * @return int randomly generated integer
     */
	private static int randInt(int x, int y){
		int seed = (int)(Math.random() * (y - x + 1)); //+1 makes it inclusive
		return x + seed;
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