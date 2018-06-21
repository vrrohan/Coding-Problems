/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=14075
Problem Statement        
In math, we sometimes define a partial order on some objects. In this problem we will take a look at one possible way how to define a partial order on sets of integers.
Consider two sets of integers: X and Y. These two sets can be related to each other in four possible ways:

X is equal to Y if each element of X is also an element of Y and vice versa.
X is less than Y if X is not equal to Y (see previous item) and each element of X is also an element of Y.
X is greater than Y if Y is less than X.
In all other cases X and Y are incomparable.

In other words: X is less than Y if and only if X is a proper subset of Y. Two sets are incomparable if neither is a subset of the other.
You are given two int[]s a and b. The elements of a form the set X. The elements of b form the set Y. Compare X to Y and return the correct one of the following four strings: "EQUAL", "LESS", "GREATER", or "INCOMPARABLE".
(The string "LESS" means that X is less than Y, the string "GREATER" means that X is greater than Y. Quotes are for clarity only. Note that the return value is case-sensitive.)
 
Definition        
Class:  SetPartialOrder
Method: compareSets
Parameters: int[], int[]
Returns:    String
Method signature:   String compareSets(int[] a, int[] b)
(be sure your method is public)
     
Constraints
-   Each of arrays a and b will have length between 1 and 50, inclusive.
-   Each element of arrays a and b will be between 1 and 100, inclusive.
-   In each of arrays a and b all elements are distinct.
 
Examples
0)  
{1, 2, 3, 5, 8}
{8, 5, 1, 3, 2}
Returns: "EQUAL"
The order of elements in a and b does not matter. The two sets X and Y are equal.

1)          
{2, 3, 5, 7}
{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
Returns: "LESS"
Each number that occurs in a does also occur in b.

2)          
{2, 4, 6, 8, 10, 12, 14, 16}
{2, 4, 8, 16}
Returns: "GREATER"

3)          
{42, 23, 17}
{15, 23, 31}
Returns: "INCOMPARABLE"
*/

public class SetPartialOrder {
    static String compareSets(int[] a, int[] b) {
        String setOrder = "INCOMPARABLE";

        //If both sets A & B are same length
        if(a.length==b.length) {
            for(int i=0; i<a.length; i++) {
                boolean isFound=true;
                for(int j=0; j<b.length; j++) {
                    if(a[i]==b[j]) {
                        isFound=false;
                    }
                }//end of inner for loop
                if(isFound) {
                    setOrder="INCOMPARABLE"; break;
                }
                else {
                    setOrder="EQUAL";
                }
            }//end of outer for loop
        }

        //If set A is greater
        if(a.length<b.length) {
            for(int i=0; i<a.length; i++) {
                boolean isFound=true;
                for(int j=0; j<b.length; j++) {
                    if(a[i]==b[j]) {
                        isFound=false;
                    }
                }//inner for loop ends...
                if(isFound) {
                    setOrder="INCOMPARABLE";    break;
                }
                else {
                    setOrder="LESS";
                }
            }//outer for loop ends...
        }

        //If set B is greater
        if(a.length>b.length) {
            for(int i=0; i<b.length; i++) {
                boolean isFound=true;
                for(int j=0; j<a.length; j++) {
                    if(b[i]==a[j]) {
                        isFound=false;
                    }
                }//inner for loop ends...
                if(isFound) {
                    setOrder="INCOMPARABLE";    break;
                }
                else {
                    setOrder="GREATER";
                }
            }//outer for loop ends...
        }
        return setOrder;
    }

    public static void main(String[] args) {
        int[] setA1 = {1, 2, 3, 5, 8};
        int[] setB1 = {8, 5, 1, 3, 2};

        int[] setA2 = {2, 3, 5, 7};
        int[] setB2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] setA3 = {2, 4, 6, 8, 10, 12, 14, 16};
        int[] setB3 = {2, 4, 8, 16};

        int[] setA4 = {42, 23, 17};
        int[] setB4 = {15, 23, 31};

        System.out.println("Sets A1 & B1 are : " + compareSets(setA1,setB1));
        System.out.println("Sets A2 & B2 are : " + compareSets(setA2,setB2));
        System.out.println("Sets A3 & B3 are : " + compareSets(setA3,setB3));
        System.out.println("Sets A4 & B4 are : " + compareSets(setA4,setB4));
    }
}
