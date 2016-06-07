Extra Credit Project: A Battle of Sorts

Jeffrey Tamashiro
ICS311 - Suthers
12/8/2013
------------------------------------------------------------------------

Program Contents:
	(4) Java Source files: InsertionSort.java, HeapSort.java, MergeSort.java, QuickSort.java
	(1) Testing File with main method: TestSorts.java
	(3) Accompanying Documents: README.txt, TESTINGDOCS.txt, JavaDocs HTML files
	
Sort classes:
	The 4 sort classes commonly have a single public method called 'sort' which takes a String
	array and sorts it, returning void.  They can be called statically provided the files
	are in the same directory or otherwise imported.  For example: "QuickSort.sort(yourArray);"
	In which case yourArray will be sorted in place, meaning its previous ordering will be lost.
	
Test Sorts:
	This program contains a main method and is run with exactly 1 command line argument nameing a 
	file to be passed to the program.  The program reads the file each line stored in an array.
	It then proceeds to sort individual copies of the array with the 4 different sort classes.
	Then it prints a report detailing the times each sort took in nano seconds.
	
Basic Methodology:
	I followed the idea of Collections.sort as something that would be accessed statically and called
	on something in place.  This allowed me to concentrated on implementing the algorithm precisley,
	I just had to take an array and sort it. Although I wrote the code myself, I followed Cormen's text 
	very closely, even borrowing the same variables in many cases so I wouldn't get confused.  Except
	for the merge part of Merge Sort, I had to get a little more clever about two arrays.
	Doing it this way did give me several limitations so I am including things I would like to change
	below.

Further Implementations:
	-Sort any array of any comparable object, not just Strings
	-Return value indicating success or failure
	-More meaningful comments!, sorry I know this is inexcusable but I just didn't have time
	-Some kind of relationship or hierarchy that ties the different sorts together.  
		(I planned to do an interface early on but since I was using them calling 
		them statically, it didn't really make sense.)
	-Better variable names p, q, r	
	
And yes, the title is a play on words.