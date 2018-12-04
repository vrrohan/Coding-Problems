
/*
This problem was recently asked by Google.
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
Bonus: Can you do this in one pass?
 */

public class DailyCodingProblem1 {

	public static boolean isSumEqualToK(int[] arr, int k) {
		boolean isSum17 = false;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[i] + arr[j]) == k) {
					isSum17 = true;
					break;
				}
			} // inner for loop ends...
		} // outer for loop ends...

		return isSum17;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 15, 3, 7 };
		int[] arr2 = { 1, 14, 12, 6, 8 };

		System.out.println("Is array1 contains sum of 17 : " + isSumEqualToK(arr, 17));
		System.out.println("Is array1 contains sum of 77 : " + isSumEqualToK(arr, 77));
		System.out.println("Is array2 contains sum of 89 : " + isSumEqualToK(arr2, 89));
		System.out.println("Is array2 contains sum of 22 : " + isSumEqualToK(arr2, 22));
	}

}
