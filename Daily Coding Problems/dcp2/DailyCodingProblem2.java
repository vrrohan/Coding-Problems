package DailyCodingProblem2;

/*
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division? 
 */

public class DailyCodingProblem2 {

	public static int[] returnMultiplesArray(int[] arr) {
		int[] newArray = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int mul = 1;
			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					continue;
				} else {
					mul = mul * arr[j];
					newArray[i] = mul;
				}
			}
		}
		return newArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] newArray = returnMultiplesArray(new int[] { 1, 2, 3, 4, 5 });
		System.out.print("New Array is : ");
		for (int k : newArray) {
			System.out.print(k + " ");
		}
	}

}
