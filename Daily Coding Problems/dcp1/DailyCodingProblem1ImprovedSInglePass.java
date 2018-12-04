import java.util.ArrayList;
import java.util.Scanner;

public class DailyCodingProblem1ImprovedSInglePass {

	// this method will return boolean value if two pairs has sum equal to k, in
	// a single pass
	// Improved version - with search time O(n)
	// space complexity = O(n), time complexity = O(n)
	public static boolean getSumEqualToKInSinglePass(int[] arr, int k) {
		boolean isSum17 = false;

		ArrayList<Integer> listElements = new ArrayList<Integer>();

		for (int i : arr) {
			listElements.add(i);
		}

		for (int i = 0; i < listElements.size() - 1; i++) {
			if (listElements.subList(i + 1, listElements.size()).contains(k - listElements.get(i))) {
				isSum17 = true;
				break;
			}
		}

		return isSum17;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter number to find its sum of pairs : ");
			int K = sc.nextInt();
			System.out.println("Is array contains sum of " + K + " : "
					+ getSumEqualToKInSinglePass(new int[] { 1, 3, 4, 11, -3, 6, 8, 10 }, K));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
