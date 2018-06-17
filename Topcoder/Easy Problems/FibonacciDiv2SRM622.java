/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=13159
Problem Statement
        The Fibonacci sequence is defined as follows:
F[0] = 0
F[1] = 1
for each i >= 2: F[i] = F[i-1] + F[i-2]
Thus, the Fibonacci sequence starts as follows: 0, 1, 1, 2, 3, 5, 8, 13, ... The elements of the Fibonacci sequence are called Fibonacci numbers. 
You're given an int N. You want to change N into a Fibonacci number. This change will consist of zero or more steps. In each step, you can either increment or decrement the number you currently have. That is, in each step you can change your current number X either to X+1 or to X-1. 
Return the smallest number of steps needed to change N into a Fibonacci number.
 
Definition        
Class:  FibonacciDiv2
Method: find
Parameters: int
Returns:    int
Method signature:   int find(int N)
(be sure your method is public)
    
Constraints
-   N will be between 1 and 1,000,000, inclusive.
 
Examples
0)  1
Returns: 0
The number 1 is already a Fibonacci number. No changes are necessary.

1)  13
Returns: 0
The number 13 is also a Fibonacci number.

2)  15
Returns: 2
The best way to change 15 into a Fibonacci number is to decrement it twice in a row (15 -> 14 -> 13).

3)  19
Returns: 2
You can increase it by 2 to get 21.

4)  1000000
Returns: 167960
This is the biggest possible number that you can get as input.
*/

import java.util.*;
public class FibonacciDiv2 {
    static int find(int N) {
        int minSteps = 0;
        int f1=2, f2=3;
        int sum=0;
        //base case, if 0,1,2,3 number itself is a fibonacci
        if(N==0|N==1|N==2|N==3) {
            minSteps=0;
        }
        else {
            //this loop will go till closest finobacci near to N
            while(sum<=N) {
                sum=f1+f2;  f1=f2;  f2=sum;
            }
            //check for closest fibonacci, if number itself is a fibonacci it returns same number else it will return difference of closest fibonacci number
            minSteps=(N-f1<f2-N)?(N-f1):(f2-N);
        }
        return minSteps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();

        if(find(num)==0) {
            System.out.println("number " + num + " itself is a fibonacci number. 0 steps needed.");
        }
        else {
            System.out.println("number " + num + " is not a fibonacci number. " + find(num) + " steps needed to change it into fibonacci");
        }
    }
}
