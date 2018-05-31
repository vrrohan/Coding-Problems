/*
Original Problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=12387
Problem Statement
        You are taking a course in analysis of algorithms and now you are learning about efficient multiplication of large integers. 
        This week, your professor wanted to give you a homework: given a list of integers, determine the product of all elements in the list. 

However, later your professor decided that the homework is too difficult and gave you an easier version instead. In this version, you are only required to determine the sign of the product. The professor also gave you some hints: 
Any integer multiplied by zero is always zero.
The product of two positive integers is always a positive integer.
The product of a positive integer and a negative integer is always a negative integer.
The product of two negative integers is always a positive integer.

More formally, you are given a int[] numbers. Let P be the product of all elements of numbers. If P is positive, return "POSITIVE"; if P is negative, return "NEGATIVE"; else return "ZERO".
 
Definition        
Class:  EasyHomework
Method: determineSign
Parameters: int[]
Returns:    String
Method signature:   String determineSign(int[] A)
(be sure your method is public)
    
Notes
-   It is possible that the product of all elements of numbers is not representable in 32-bit or 64-bit signed integer data type.
 
Constraints
-   numbers will contain between 1 and 50 elements, inclusive.
-   Each element of numbers will be between -1,000,000,000 and 1,000,000,000, inclusive.
 
Examples
0)  {5, 7, 2}
Returns: "POSITIVE"
The product is 70, which is a positive integer.

1)  {-5, 7, 2}
Returns: "NEGATIVE"
This time the product is -70, which is a negative integer.

2)  {5, 7, 2, 0}
Returns: "ZERO"
The product is 0.

3)  {3, -14, 159, -26}
Returns: "POSITIVE"

4)  {-1000000000}
Returns: "NEGATIVE"

5)  {123, -456, 789, -101112, 131415, 161718, 192021, 222324, 252627, 282930, 313233, 343536, 373839, 404142, 434445, 464748, 495051, 525354, 555657}
Returns: "POSITIVE"
The product is 137646845657507645199797549975668224555202443025319758098026743549006534800854109919487361024000, which is a positive integer. Note that this number does not fit even into a 64-bit signed integer data type!
*/

import java.math.BigInteger;
public class EasyHomework {
    static String determineSign(int[] num) {
        String isSign="";
        //using BigInteger class to multiply to get product greater than range of long
        //Note that some numbers does not fit even into a 64-bit signed integer data type!
        BigInteger bigInt = new BigInteger("1");
        for(int i=0; i<num.length; i++) {
            bigInt=bigInt.multiply(BigInteger.valueOf(num[i]));
        }
        System.out.println("product is : " + bigInt.toString());
        //compareTo(BigInteger b) returns -1,0,+1
        if(bigInt.compareTo(BigInteger.valueOf(0))>0) {
            isSign="POSITIVE";
        }
        else if(bigInt.compareTo(BigInteger.valueOf(0))==0) {
            isSign="ZERO";
        }
        else if(bigInt.compareTo(BigInteger.valueOf(0))<0) {
            isSign="NEGATIVE";
        }
        return isSign;
    }

    public static void main(String[] args) {
        int[] arr1 = {5,7,2};
        int[] arr2 = {-5,7,2};
        int[] arr3 = {5,7,2,0};
        int[] arr4 = {3,-14,159,-26};
        int[] arr5 = {-1000000000};
        int[] arr6 = {123, -456, 789, -101112, 131415, 161718, 192021, 222324, 252627, 282930, 
                313233, 343536, 373839, 404142, 434445, 464748, 495051, 525354, 555657};

        System.out.println(determineSign(arr1));
        System.out.println(determineSign(arr2));
        System.out.println(determineSign(arr3));
        System.out.println(determineSign(arr4));
        System.out.println(determineSign(arr5));
        System.out.println(determineSign(arr6));
    }
}
