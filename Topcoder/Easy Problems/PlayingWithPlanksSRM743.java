import java.util.Scanner;
/*
Problem Statement link :- https://community.topcoder.com/stat?c=problem_statement&pm=14664
Problem Statement :-
You are given a plank of length plankLength. You want to cut the plank into exactly pieces pieces such that the length of each piece is a (positive) integer and all the lengths are distinct.
If it is possible to cut the plank in the described way, return "possible". Otherwise return "impossible".

Definition

Class:	PlayingWithPlanks
Method:	canItBeDone
Parameters:	int, int
Returns:	String
Method signature:	String canItBeDone(int plankLength, int pieces)
(be sure your method is public)

Notes
-	Note that the return value is case-sensitive.

Constraints
-	plankLength will be between 1 and 1,000,000, inclusive.
-	pieces will be between 1 and 1,000, inclusive.

Examples
0)9
3
Returns: "possible"
One possibility is to cut the plank into pieces of lengths 1, 3 and 5.

1)12
1
Returns: "possible"

2)9
4
Returns: "impossible"
It can be shown that there is no way to cut a plank of length 9 into 4 pieces of different integer lengths.

3)10
4
Returns: "possible"

4)750932
901
Returns: "possible"

5)54
10
Returns: "impossible"
*/

public class PlayingWithPlanksSRM743 {

	public static String canItBeDone(int plankLength, int pieces) {
		long num = (pieces + 1) * pieces / 2;
		String plankStatus = (num <= plankLength) ? "possible" : "impossible";
		return plankStatus;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter Plank Length : ");
			int plankLen = sc.nextInt();
			System.out.print("\nEnter number of pieces to cut : ");
			int numOfPieces = sc.nextInt();
			System.out.println("\nPlank of length " + plankLen + " can be cut into " + numOfPieces + " pieces is := "
					+ canItBeDone(plankLen, numOfPieces));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
