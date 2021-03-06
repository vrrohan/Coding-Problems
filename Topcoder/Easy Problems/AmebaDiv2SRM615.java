/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=13089
Problem Statement
        Monte-Carlo is an amoeba. Amoebas can feed on gel: whenever an amoeba encounters a piece of gel that is exactly as big as the amoeba, the amoeba will consume the gel and thus double its size. 
Initially, the size of Monte-Carlo was A. During its lifetime, Monte-Carlo encountered several gels and consumed the ones it could. 
You are given a int[] X and the int A. The elements of X are the sizes of gels Monte-Carlo encountered, in chronological order. Compute and return the final size of Monte-Carlo.
 
Definition        
Class:  AmebaDiv2
Method: simulate
Parameters: int[], int
Returns:    int
Method signature:   int simulate(int[] X, int A)
(be sure your method is public)
    
Constraints
-   X will contain between 1 and 200 integers, inclusive.
-   Each element of X will be between 1 and 1,000,000,000, inclusive.
-   A will be between 1 and 1,000,000,000, inclusive.
 
Examples
0)  {2,1,3,1,2}
1
Returns: 4
Gel #0 is bigger than Monte-Carlo, nothing happens.
Monte-Carlo consumes gel #1. Its size is now 1+1 = 2.
Gel #2 is bigger than Monte-Carlo, nothing happens.
Gel #3 is smaller than Monte-Carlo, nothing happens.
Monte-Carlo consumes gel #4. Its size is now 2+2 = 4.

1)  {1,4,9,16,25,36,49}
10
Returns: 10
The size of Monte-Carlo doesn't change.

2)  {1,2,4,8,16,32,64,128,256,1024,2048}
1
Returns: 512

3)  {817,832,817,832,126,817,63,63,126,817,832,287,823,817,574}
63
Returns: 252
*/

public class AmebaDiv2 {
    static int simulate(int[] X, int A) {
        int finalAmebaSize = A;
        for(int i=0; i<X.length; i++) {
            finalAmebaSize = (X[i]==finalAmebaSize) ? finalAmebaSize+X[i] : finalAmebaSize;
        }
        return finalAmebaSize;
    }

    public static void main(String[] args) {
        int[] arr = {817,832,817,832,126,817,63,63,126,817,832,287,823,817,574};
        int[] arr2 = {1,2,4,8,16,32,64,128,256,1024,2048};
        int[] arr3 = {1,4,9,16,25,36,49};
        int[] arr4 = {2,1,3,1,2};
        System.out.println("Final Ameba size is : " + simulate(arr,63));
        System.out.println("Final Ameba size is : " + simulate(arr2,1));
        System.out.println("Final Ameba size is : " + simulate(arr3,10));
        System.out.println("Final Ameba size is : " + simulate(arr4,1));    
    }
}
