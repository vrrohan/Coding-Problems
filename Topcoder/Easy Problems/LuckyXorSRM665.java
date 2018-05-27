/*
Original problem statement - https://community.topcoder.com/stat?c=problem_statement&pm=13960
Problem Statement
        A lucky number is a positive integer consisting of only the digits 4 and 7.
Given an int a, return an int b strictly greater than a, such that a XOR b is a lucky number. (See Notes for the definition of XOR.) 
The number b should be in the range 1 to 100, inclusive. If such a number does not exist, return -1. If there are multiple such b, you may return any of them.
 
Definition - 
Class:  LuckyXor
Method: construct
Parameters: int
Returns:    int
Method signature:   int construct(int a)
(be sure your method is public)
     
Notes
-   XOR is the bitwise exclusive-or operation. To compute the value of P XOR Q, we first write P and Q in binary. Then, each bit of the result is computed by applying XOR to the corresponding bits of the two numbers, using the rules 0 XOR 0 = 0, 0 XOR 1 = 1, 1 XOR 0 = 1, and 1 XOR 1 = 0.
-   For example, let's compute 21 XOR 6. In binary these two numbers are 10101 and 00110, hence their XOR is 10011 in binary, which is 19 in decimal.
-   You can read more about the XOR operation here: https://en.wikipedia.org/wiki/Exclusive_or
 
Constraints
-   a is between 1 and 100, inclusive.
 
Examples
0)  4
Returns: 40
4 XOR 40 = 44, 44 is a lucky number.

1)  19
Returns: 20
19 XOR 20 = 7

2)  88
Returns: 92
88 XOR 92 = 4

3)  36
Returns: -1
*/

import java.util.*;
public class LuckyXor {    
    static int construct(int num) {
        int luckyNumB = -1;
        for(int i=num+1; i<=100; i++) {
            int luckyNum = i^num;
            //convert xor value into string to check if it contains either from 4 or 7
            String strNum = String.valueOf(luckyNum);
            if((!strNum.contains(String.valueOf(0)))&(!strNum.contains(String.valueOf(1)))&
               (!strNum.contains(String.valueOf(2)))&(!strNum.contains(String.valueOf(3)))&
               (!strNum.contains(String.valueOf(5)))&(!strNum.contains(String.valueOf(6)))&
               (!strNum.contains(String.valueOf(8)))&(!strNum.contains(String.valueOf(9)))) {
                luckyNumB = i;
                break;
            }
        }//end of for loop...
        return luckyNumB;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number a to get number b -> a*b forms lucky number : ");
        int num = sc.nextInt();
        int isLuckyNumber = construct(num);
        if(isLuckyNumber==-1) {
            System.out.println("there is no number b which forms lucky number : " + isLuckyNumber);
        }
        else {
            System.out.println("number b which forms lucky number is : " + isLuckyNumber);
        }
    }
}
