import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
/** This class is used to generate tests for various Java implemented sorts.
 * @author Jeffrey Tamashiro
 * @version 1.0 - December 08, 2013
 */
public class TestSorts{
	public static void main(String args[]){
		
		File fileIn = null;
		Scanner scan = null;
		int size = 0; //counter for first pass
		int j = 0; //counter for second pass
		String names[];
		String line = "------------------------------------------------------------------------------------------------";
		
// checks for invalid input
		if(args.length < 1){
			System.out.println("Usage command filename");
			return;
		}		
		try {
			fileIn = new File(args[0]);
			scan = new Scanner(fileIn);			
		} catch(IOException e){
				System.out.println(e);
				return;
			}
			
// first pass to count number of lines						
		while(scan.hasNextLine()){
			scan.nextLine();
			size++;
		}
		scan.close();
		
		names = new String[size];  //allocate array with size
		
		try{ scan = new Scanner(fileIn); } catch(IOException e){ return; } // this should never happen

// second pass to read into array				
		while(scan.hasNextLine()){
			names[j] = scan.nextLine();
			j++;
		}
		
// check that lines were read in correctly		
		if(size != j){
			System.out.println("Reading error");
			return;
		}
		scan.close();
		
// Testing Starting 
		System.out.println(line);		
		System.out.println("Sort Test: " + names.length + " keys");
		String format = "%-16s %15d ns | First Key: %-20s| Last Key: %-20s\n";
		
		System.gc();	
		testInsertionSort(names, format);
		System.gc();	
		testHeapSort(names, format);		
		System.gc();			
		testMergeSort(names, format);
		System.gc();	
		testQuickSort(names, format);

	} //end of main
	/**
	* Insertion Sort Testing method
	* @param names String array
	* @param format String format
	*/
	public static void testInsertionSort(String[] names, String format){
		String[] testArray = Arrays.copyOf(names, names.length);
		
		long start = System.nanoTime();
		InsertionSort.sort(testArray);
		long stop = System.nanoTime();
		
		long diff = stop - start;
		
		System.out.printf(format, "Insertion Sort:", diff, testArray[0], testArray[testArray.length - 1]);

		testArray = null;
	}
	/**
	* Heap Sort Testing method
	* @param names String array
	* @param format String format
	*/	
	public static void testHeapSort(String[] names, String format){
		String[] testArray = Arrays.copyOf(names, names.length);
		
		long start = System.nanoTime();
		HeapSort.sort(testArray);
		long stop = System.nanoTime();
		
		long diff = stop - start;
		
		System.out.printf(format, "Heap Sort:", diff, testArray[0], testArray[testArray.length - 1]);

		testArray = null;
	}
	/**
	* Merge Sort Testing method
	* @param names String array
	* @param format String format
	*/	
	public static void testMergeSort(String[] names, String format){
		String[] testArray = Arrays.copyOf(names, names.length);
		
		long start = System.nanoTime();
		MergeSort.sort(testArray);
		long stop = System.nanoTime();
		
		long diff = stop - start;
		
		System.out.printf(format, "Merge Sort:", diff, testArray[0], testArray[testArray.length - 1]);

		testArray = null;
	}
	/**
	* Quick Sort Testing method
	* @param names String array
	* @param format String format
	*/	
	public static void testQuickSort(String[] names, String format){
		String[] testArray = Arrays.copyOf(names, names.length);
		
		long start = System.nanoTime();
		QuickSort.sort(testArray);
		long stop = System.nanoTime();
		
		long diff = stop - start;
		
		System.out.printf(format, "Quick Sort:", diff, testArray[0], testArray[testArray.length - 1]);

		testArray = null;
	}
	/**
	* Prints out the array contents parsed with commas
	* @param names String array
	*/
	public static void printNames(String[] names){
		System.out.print("{");
		for(String s : names){
			System.out.print(s + ", ");
		}
		System.out.print("}\n");
	}
}