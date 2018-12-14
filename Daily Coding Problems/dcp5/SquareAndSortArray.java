package DailyCodingProblem5;

import java.util.stream.IntStream;

/*
This problem was asked by Google.
Given a sorted list of integers, square the elements and give the output in sorted order.
For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].
 */

public class SquareAndSortArray {

	static int[] getSquaredAndSorted(int[] tempArray) {
		//first square each array elements
		//Using IntStream, we can use map() to map & square each array elements & finally convert this array back to int[] array
		int[] squaredSortedArray = IntStream.of(tempArray).map(k -> k*k).toArray();
		
		//Now, to sort that array, call sort() on IntStream object again
		squaredSortedArray = IntStream.of(squaredSortedArray).sorted().toArray();
		return squaredSortedArray;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] finalSquaredAndSorted = getSquaredAndSorted(new int[] {-9, -2, 0, 2, 3});
		IntStream.of(finalSquaredAndSorted).forEach(x -> System.out.print(x + " "));
	}

}
