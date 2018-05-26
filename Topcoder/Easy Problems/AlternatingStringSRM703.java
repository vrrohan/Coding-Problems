/*
problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=14460
Problem Statement
        A string of zeros and ones is called an alternating string if no two adjacent characters are the same. 
        Examples of alternating strings: "1", "10101", "0101010101". 

You are given a String s. Each character of s is a '0' or a '1'. Please find the longest contiguous substring of s that is an alternating string. Return the length of that substring.
 
Definition
        
Class:  AlternatingString
Method: maxLength
Parameters: String
Returns:    int
Method signature:   int maxLength(String s)
(be sure your method is public)
    
 
Constraints
-   s will contain between 1 and 50 characters, inclusive.
-   Each character in s will be '0' or '1'.
 
Examples
0)  "111101111"
Returns: 3
Among all substrings, there are 5 different alternating strings: "1", "0", "10", "01", "101". The one with maximal length is "101" and the length is 3.

1)  "1010101"
Returns: 7
The string s itself is an alternating string.

2)  "000011110000"
Returns: 2
Note that a substring must be contiguous. The longest alternating substrings of this s are "01" and "10". The string "010" is not a substring of this s.

3)  "1011011110101010010101"
Returns: 8

4)  "0"
Returns: 1
*/

import java.util.*;
public class AlternatingStrings {
    static int maxLength(String str) {
        int len=1;
        int seqLen=1;
        if(str.length()==1) {
            return 1;
        } 
        else {
            for(int i=0; i<str.length()-1; i++) {
                if(!String.valueOf(str.charAt(i)).equals(String.valueOf(str.charAt(i+1)))) {
                    seqLen++;
                    //check everytime if length > previous sub-sequence length
                    if(len<=seqLen) {len=seqLen;}
                }
                else {
                    if(len<=seqLen) {
                        len=seqLen;
                    }
                    //if sub-sequence of 01 not present, initialize sub-sequence length to 1
                    seqLen=1;
                }
            }//end of for loop
        }//end of else
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter string of 0's & 1's : ");
        String zeroOne = sc.nextLine();

        System.out.println("\nstring of 01's are : " + zeroOne);
        System.out.println("maximum substring length of 01's are : " + maxLength(zeroOne));
    }
}
