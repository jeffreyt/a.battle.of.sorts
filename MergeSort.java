/**
 * MergeSort.java
 * Extra Credit Project - A Battle of Sorts?
 * ICS 311 - Suthers
 * This class can be called statically to execute a merge sort on a String array
 * @author Jeffrey Tamashiro
 */
public class MergeSort{
    /**
     * Static method that sorts the given array in place
     * @param array String array
     */
	public static void sort(String [] array){
		
		int size = array.length;
		
		String[] aux = new String[size];
		
		mergeSort(array, aux, 0, size - 1);
	}
    /**
     * This part of the sort splits the array in half recursively down and calls merge to 
	 * join everything back together up.  Entire arrays are passed, but parameters create
	 * boundaries for conceptual array, local to specific method call.
     * @param arr String array to be sorted
	 * @param aux String array, necessary to store data temporarily during sort
     * @param l leftmost index of conceptual array
     * @param r rightmost index of conceptual array
     */
	private static void mergeSort(String [] arr, String [] aux, int l, int r){
		
		int m = (l + r) / 2;
		
		if(l < r){
			mergeSort(arr, aux, l, m);
			mergeSort(arr, aux, m + 1, r);
			merge(arr, aux, l, m, r);
		}
	}
    /**
	 * This part of the array takes the two arrays and 3 indexes which create two
	 * adjacent conceptual arrays which are considered to be sorted.  The two arrays
	 * are then sorted in the auxiliary array before being copied back into the original.
     * @param arr String array to be sorted
	 * @param aux String array, necessary to store data temporarily during sort
     * @param leftBound leftmost index of conceptual array #1
	 * @param midBound rightmost index of conceptual array #1
     * @param rightBound rightmost index of conceptual array #2
     */	
	private static void merge(String[] arr, String[] aux, int leftBound, int midBound, int rightBound){
		
		int leftIndex = leftBound;
		int rightIndex = midBound + 1;
		
		for(int i = leftBound; i <= rightBound; i++){
			if(rightIndex > rightBound){ //check first b/c out of bounds error risk is highest
				aux[i] = arr[leftIndex];
				leftIndex++;
			}
			else if(leftIndex > midBound){
				aux[i] = arr[rightIndex];
				rightIndex++;
			}
			else if((arr[leftIndex]).compareTo(arr[rightIndex]) < 0){
				aux[i] = arr[leftIndex];
				leftIndex++;			
			}
			else{
				aux[i] = arr[rightIndex];
				rightIndex++;			
			}
		}
		for(int i = leftBound; i <= rightBound; i++){ //copy everything back
			arr[i] = aux[i];
		}
	}

}