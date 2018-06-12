/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=13230
Problem Statement
        You are given a int[] array. At any moment, you may choose a nonempty contiguous subsequence of array. Whenever you do so, you will gain power equal to the sum of all elements in the chosen subsequence.
You chose each possible contiguous subsequence exactly once, each time gaining some power. Compute and return the total amount of power you gained.

Definition        
Class:  SumOfPower
Method: findSum
Parameters: int[]
Returns:    int
Method signature:   int findSum(int[] array)
(be sure your method is public)
     
Constraints
-   array will contain between 1 and 50 elements, inclusive.
-   Each element in array will be between 1 and 100, inclusive.
 
Examples
0)  {1,2}
Returns: 6
We have the following three contiguous subsequences:
{1} => 1
{2} => 2
{1,2} => 3
Thus, the sum of all possible powers is 1+2+3=6.

1)  {1,1,1}
Returns: 10
A 3-element sequence has 6 possible nonempty contiguous subsequences. For the sequence {1,1,1} these are the subsequences: {1}, {1}, {1}, {1,1}, {1,1}, and {1,1,1}. Their sums are 1, 1, 1, 2, 2, and 3. If you choose each of them once, the total power you'll gain is 1+1+1+2+2+3 = 10.

2)  {3,14,15,92,65}
Returns: 1323

3)  {1,2,3,4,5,6,7,8,9,10}
Returns: 1210
*/

public class SumOfPower {

    static int findSum(int[] arr) {
        int maxSum = 0;
        int k=0;
        //this loop will run till arr.length times
        for(int i=0; i<arr.length; i++) {
            //j=0,1,2,3 ==> k=0 ==> m = j to j+k ==> 0,1,2,3
            //j=0,1,2 ==> k=1 ==> m= j to j+k ==> m = 01,12,23
            //j=0,1 ==> k=2 ==> m=j to j+k ==> m = 012, 123. This loop will create sub-sequence patterns like 1st 0,1,2,3 then 0,1,2 then 0,1 then 0
            for(int j=0; j<=arr.length-1-k; j++) {
                int num=j+k;
                //Here loop will run from j to j+k
                for(int m=j; m<=num; m++) {
                    maxSum+=arr[m];
                }
            }
            k++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] arr2 = {1,2,3};
        int[] arr3 = {1,1,1};
        int[] arr4 = {3,14,15,92,65};
        int[] arr5 = {5,7,3,11,19,14,15};       
        System.out.println("total sum of all sub-sequences is : " + findSum(arr));
        System.out.println("total sum of all sub-sequences is : " + findSum(arr2));
        System.out.println("total sum of all sub-sequences is : " + findSum(arr3));
        System.out.println("total sum of all sub-sequences is : " + findSum(arr4));
        System.out.println("total sum of all sub-sequences is : " + findSum(arr5));
    }
}
