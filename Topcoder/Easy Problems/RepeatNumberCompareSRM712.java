/*
Original problem statement - https://community.topcoder.com/stat?c=problem_statement&pm=14566
Problem Statement
        For any two positive integers x and k we can make a new number denoted repeat(x, k) by concatenating k copies of x written in decimal. 
        For example, repeat(1234,3) = 123412341234 and repeat(70,4) = 70707070. 

You are given the ints x1, k1, x2, and k2. Let v1 = repeat(x1, k1) and v2 = repeat(x2, k2). Please compare the numbers v1 and v2 and return a String that describes the result of the comparison. In particular:
Return "Less" if v1 is less than v2.
Return "Greater" if v1 is greater than v2.
Return "Equal" if v1 and v2 are equal.
 
Definition
        
Class:  RepeatNumberCompare
Method: compare
Parameters: int, int, int, int
Returns:    String
Method signature:   String compare(int x1, int k1, int x2, int k2)
(be sure your method is public)
    
Notes
-   The return value is case-sensitive.
 
Constraints
-   x1 will be between 1 and 1,000,000,000, inclusive.
-   k1 will be between 1 and 50, inclusive.
-   x2 will be between 1 and 1,000,000,000, inclusive.
-   k2 will be between 1 and 50, inclusive.
 
Examples
0)  1234
3
70
4
Returns: "Greater"
v1 = 123412341234 and v2 = 70707070, so we have v1 > v2.

1)  1010
3
101010
2
Returns: "Equal"
This time we have v1 = v2 = 101010101010.

2)  1234
10
456
20
Returns: "Less"
v1 has 40 digits and v2 has 60 digits, so v1 < v2.

3)  5
9
555555555
1
Returns: "Equal"

4)  5
9
555555554
1
Returns: "Greater"

5)  5
9
555555556
1
Returns: "Less"

6)  1000000000
50
1000000000
50
Returns: "Equal"
*/

import java.math.BigInteger;

public class RepeatNumberCompare {
    static String compare(int x1, int k1, int x2, int k2) {
        String isNumber = "Equal";
        String strX1 = "";
        String strX2 = "";
        for(int i=1; i<=k1; i++) {
            strX1+=String.valueOf(x1);
        }
        for(int i=1; i<=k2; i++) {
            strX2+=String.valueOf(x2);
        }

        System.out.println("number 1 is : " + strX1);
        System.out.println("number 2 is : " + strX2);

        if((x1==x2)&(k1==k2)) {
            return isNumber;
        }
        else {
            BigInteger num1 = new BigInteger(strX1);
            BigInteger num2 = new BigInteger(strX2);
            if(num1.compareTo(num2)>0) { isNumber="Greater"; }
            else if(num1.compareTo(num2)<0) { isNumber="Less"; }
            else if(num1.compareTo(num2)==0) { isNumber="Equal"; }
        }
        return isNumber;
    }

    public static void main(String[] args) {
            System.out.println(compare(1234,3,70,4) + "\n-----------------------------------------------------------");
            System.out.println(compare(1010,3,101010,2) + "\n-----------------------------------------------------------");
            System.out.println(compare(1234,10,456,20) + "\n-----------------------------------------------------------");
            System.out.println(compare(5,9,555555555,1) + "\n-----------------------------------------------------------");
            System.out.println(compare(5,9,555555554,1) + "\n-----------------------------------------------------------");
            System.out.println(compare(5,9,555555556,1) + "\n-----------------------------------------------------------");
            System.out.println(compare(1000000000,50,1000000000,50) + "\n-----------------------------------------------------------");
    }
}
