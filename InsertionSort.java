/**
 * InsertionSort.java
 * Extra Credit Project - A Battle of Sorts?
 * ICS 311 - Suthers
 * This class can be called statically to execute an insertion sort on a String array
 * @author Jeffrey Tamashiro
 */
public class InsertionSort {
    /**
     * Static method that sorts the given array in place
	 * The outer loop cycles through every index of the array
	 * The inner loop decides if the current value should stay
	 * or moves it back until it find the right place.
     * @param array String array to be sorted
     */
	public static void sort(String[] array){
		
		int len = array.length;
		int i,j;
		String key;
		
		for(j = 1; j < len; j++){
			key = array[j];
			i = j - 1;
			while(i >= 0 && key.compareTo(array[i]) < 0){
				array[i + 1] = array[i];
				i = i - 1;
			}
			array[i + 1] = key;
			if(j % 10000 == 0){
			}
		}
	}
}