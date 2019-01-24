package com.subex.ramasubramani;

public interface Sorting
{
	public int[] sort();
}

//Stable sort : Order of equal elements should not be changed after sorting is done
//Importance : Assume a list of students. They are enrolled randomly.So, initially they are sorted by IDs
//But later, I want to sort it by name. Assume two students with IDs 100 and 200 have same name.
//I expect student with id 100 to come first and 200 come next,but in a unstable sort this is not assured.
//because sorting is done only on name parameter now.
//we can do it both on name and id, but this is not correct, this will introduce additional comparison in our logic.
//So, sort by only one parameter, but make sure equal elements order not changed i.e. ensure the sort is stable

//Comparison is a costly operation, Why?
//Because of JUMP instruction is costly, no sequential flow
//Bubble Sort : 
//Every next two elements are compared and swapped in each iteration, Like a bubble in each iteration biggest element reaches the end
//Worst case : 9 7 5 3 1, Number of swapping 10,Number of swapping O(n^2), Number of comparisons 10 [5*4/2 -> O(n^2)], 
//Best case : 1 3 5 7 9, Number of comparisons O(n^2),Number of swapping 0.(no swapping at all)
//Best case comparison can be improved to O(N). Have a boolean variable in swap block, if during first iteration
//none of the elements are swapped -> The elements are in sorted order. 
//No need to go for further iterations (Check the boolean variable before second iteration)
//Average case : 1 5 3 9 7, Number of comparisons O(n^2), Number of swapping O(n^2) 
//Bubble sort is a stable sort.
           //Swapping   Comparison
//Best          0           O(n)  (need to introduce boolean here, if array is already sorted)
//Worst		  O(n^2)        O(n^2)
//Average	  O(n^2)        O(n^2)

//Selection Sort
//In each iteration one element is placed in its proper place.
//Worst case : 9 7 5 3 1,Number of swapping 4,Number of swapping O(n), Number of comparisons 10 , 5*4/2 O(n^2)
//Because in each iteration minimum index has been identified and for each outer loop iteration only one time swap happens
//So, selection sort is better than bubble sort because number of swapping is less in Selection sort
//Best case : 1 3 5 7 9, Number of comparisons O(n^2),Number of swapping 0.(no swapping at all)
//not a stable sort consider this case 7 5 4 5 9 --> order of 2 5's will be changed after sorting. 
//Average case : 1 5 3 9 7, Number of comparisons O(n^2), Number of swapping O(n)
//Selection sort is not stable if you swap for each inner iteration. If you follow minimum index approach
//selection sort is stable and swap only once for each outer iteration.
//8 8 4 2 1. In this case first occurrence of '8' is swapped with '1'. So, order of equal elements are changed
		   //Swapping   Comparison
//Best          0           O(n)  
//Worst		  O(n)        O(n^2)
//Average	  O(n)        O(n^2)

//Best case swapping is O(n) normally, but if you again have a comparison whether i, index are same, 
//if same don't swap. Then best case swapping is 0

//Insertion Sort
//Better than selection and bubble sorts
//In each iteration a portion of array becomes sorted.
//This sort is stable and this sorting better performance for array almost sorted.
//Worst case : 9 7 5 3 1, Number of swapping 10,Number of swapping O(n^2), Number of comparisons 10 5*4/2 O(n^2)
//Average case : 1 5 3 9 7, Number of comparisons O(n^2), Number of swapping O(n^2)
//Each time the front portion of array becomes sorted, Take K+1 th iteration, K+1 th element on an average will be compared with k
//elements in the worst case, and k/2 on an average, swapping also on an average k/2. So, better than selection and bubble
//In the case of almost sorted(irrespective of front portion or end portion sorted) array,
//k/2 further reduces and results excellent performance,
//Here also don't swap often, find the element where to insert and insert there directly.
		   //Swapping   Comparison
//Best          0           O(n)  
//Worst		  O(n^2)        O(n^2) (when elements are sorted in reverse, so in each case you have to traverse through the whole front array to insert).
//Average	  O(n^2)        O(n^2)

/*
 * Analysis of Quicksort
 * Best case: split in the middle — Thetta(n log n) 
Worst case: sorted array! — Thetta(n2) 
Average case: random arrays — Thetta(n log n)

Improvements:
better pivot selection: median of three partitioning 
switch to insertion sort on small subfiles
elimination of recursion
These combine to 20-25% improvement

Considered the method of choice for internal sorting of large files (n ≥ 10000)

 * 
 * 
 */


//Lecture //selection sort.
//Memory required is small
//Size of array (you’re using this anyway)
//Size of one variable (temp variable for swap)
//Selection sort is useful when you have limited memory available
//Inefficient otherwise when you have lots of extra memory
//Relatively efficient for small arrays

/*
In computer science, an online algorithm is one that can process its input piece-by-piece in a serial fashion,
 i.e., in the order that the input is fed to the algorithm, without having the entire input available from the start. 

In contrast, an offline algorithm is given the whole problem data from the beginning and is required 
to output an answer which solves the problem at hand. 
(For example, selection sort requires that the entire list be given before it can sort it, while insertion sort doesn't.)

offline - selection
online - insertion

in place - quick sort, 
out of place - merge sort

internal - selection sort
external - merge sort.

An offline algorithm requires all information BEFORE the algorithm starts. 
       Selection sort is offline because step 1 is Find the minimum value in the list. 
To do this, need to have the entire list available - otherwise, how is it possible to know what the minimum value is? 

Insertion sort, by contrast, is online because it does not need to know anything about what values 
it will sort and the information is requested WHILE the algorithm is running. Simply put, it can grab new values at every iteration.

In internal sorting all the data to sort is stored in memory at all times while sorting is in progress. 
In external sorting data is stored outside memory (like on disk) and only loaded into memory in small chunks. 
External sorting is usually applied in cases when data can't fit into memory entirely.
So in internal sorting you can do something like shell sort - 
just access whatever array elements you want at whatever moment you want.
You can't do that in external sorting - the array is not entirely in memory, 
so you can't just randomly access any element in memory and accessing it randomly 
on disk is usually extremely slow. The external sorting algorithm has to deal with 
loading and unloading chunks of data in optimal manner.


An in-place algorithm is an algorithm which transforms input using a  data structure with a small, constant amount of extra storage space. 
The input is usually overwritten by the output as the algorithm executes. 
An algorithm which is not in-place is sometimes called not-in-place or out-of-place .
An algorithm is sometimes, informally, called in-place as long as it overwrites its input with its output.
 In reality, this is not sufficient (as the case of quicksort demonstrates), nor is it necessary;
  the output space may be constant, or may not even be counted, for example if the output is to a stream.
 On the other hand, sometimes it may be more practical to count the output space in determining whether an algorithm is in-place.
 this makes it difficult to strictly define in-place algorithms. 

*/

/*
1 and 3 : Brute force means that you will go through all possible solutions extensively. For example, in a chess game, if you know you can win in two moves, the brute force will go through all possible combination of moves, without taking anything in consideration. So the little pawn in the back that cannot influence the outcome will still be considered.

2 : As you consider everything, the problem quickly goes out of control. Brute force through 15 moves in chess is impossible because of combinatorial explosion (too many situations to consider). However, more clever algorithms that take into account "knowledge about the problem" can go much further (20-30 moves ahead)

Edit : To clarify, brute force is simplest (dumbest?) way to explore the space of solutions. If you have a problem is set in a countable space (chess moves are countable, passwords are countable, continuous stuff is uncountable) brute force will explore this space considering all solutions equally. In the chess example, you want to checkmate your opponent. This is done via a sequence of moves, which is countable. Brute force will go through all sequence of moves, however unlikely they may be. The word unlikely is important, because it means that if you have knowledge about your problem (you know what is unlikely to be the solution, like sacrificing your queen), you can do much better than brute force.
*/

/*
Complexity of Quicksort
Worst-case: O(N2)
This happens when the pivot is the smallest (or the largest) element. 
Then one of the partitions is empty, and we repeat recursively the procedure for N-1 elements.

Best-case O(NlogN) The best case is when the pivot is the median of the array, and then the left and the right part will have same size.
There are logN partitions, and to obtain each partitions we do N comparisons (and not more than N/2 swaps). Hence the complexity is O(NlogN)
Average-case - O(NlogN)

Algorithm
STEP 1. Choosing the pivot
Choosing the pivot is an essential step. Depending on the pivot the algorithm may run very fast, or in quadric time.:
Some fixed element: e.g. the first, the last, the one in the middle 
This is a bad choice - the pivot may turn to be the smallest or the largest element, then one of the partitions will be empty.
Randomly chosen (by random generator ) - still a bad choice.
The median of the array (if the array has N numbers, the median is the [N/2] largest number. This is difficult to compute - increases the complexity.
The median-of-three choice: take the first, the last and the middle element. Choose the median of these three elements.

Example:
8, 3, 25, 6, 10, 17, 1, 2, 18, 5
The first element is 8, the middle - 10,
 the last - 5.The median of [8, 10, 5] is 8


STEP 2. Partitioning
Partitioning is illustrated on the above example.
1. The first action is to get the pivot out of the way - swap it with the last element 
5, 3, 25, 6, 10, 17, 1, 2, 18, 8
2. We want larger elements to go to the right and smaller elements to go to the left.
Two "fingers" are used to scan the elements from left to right and from right to left:

Advantages: 
One of the fastest algorithms on average.
Does not need additional memory (the sorting takes place in the array - this is called in-place processing). Compare with mergesort: mergesort needs additional memory for merging.
Disadvantages: The worst-case complexity is O(N2)
Applications:
Commercial applications use Quicksort - generally it runs fast, no additional memory, this compensates for the rare occasions when it runs with O(N2)



Comparison with mergesort: 
mergesort guarantees O(NlogN) time, however it requires additional memory with size N.
quicksort does not require additional memory, however the speed is not quaranteed
usually mergesort is not used for main memory sorting, only for external memory sorting.
So far, our best sorting algorithm has O(nlog n) performance:*/
