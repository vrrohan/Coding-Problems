/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=12940
Problem Statement
        Hero is learning a new algorithm to encode a string. You are given a String s that consists of lowercase letters only. Your task is to simulate the algorithm described below on this string, so that Hero can see how it works. 
The algorithm starts with a given input string s and an empty output string t. The execution of the algorithm consists of multiple steps. In each step, s and t are modified as follows:
If the length of s is odd, the middle character of s is added to the end of t, and then deleted from s.
If the length of s is even, the two characters in the middle of s are compared. The smaller one of them (either one in case of a tie) is added to the end of t, and then deleted from s.
If after some step the string s is empty, the algorithm terminates. The output of the algorithm is the final string t. 

Return the String t that will be produced by the above algorithm for the given String s.
 
Definition        
Class:  MiddleCode
Method: encode
Parameters: String
Returns:    String
Method signature:   String encode(String s)
(be sure your method is public)
    
Notes
-   When comparing letters, the smaller one is the one earlier in the alphabet - i.e., the character with the smaller ASCII code.
 
Constraints
-   s will contain between 1 and 50 characters, inclusive.
-   Each character in s will be a lowercase letter ('a'-'z').
 
Examples
0)  "word"
Returns: "ordw"
In the first step, 'o' is smaller than 'r', thus 'o' is selected.
After the first step: s="wrd", t="o".
After the second step: s="wd", t="or".
In the third step, 'w' is greater than 'd', thus 'd' is selected.
After the third step: s="w", t="ord".
After the fourth step: s="", t="ordw", and the algorithm terminates.

1)  "aaaaa"
Returns: "aaaaa"

2)  "abacaba"
Returns: "caabbaa"

3)  "shjegr"
Returns: "ejghrs"

4)  "adafaaaadafawafwfasdaa"
Returns: "afawadafawafaafsadadaa"
*/

import java.util.*;
public class MiddleCode {
    static String encode(String s) {
        String encodedString="";
        //need to convert into string builder to modify string
        StringBuilder sb = new StringBuilder(s);
        //this loop will keep on running till input string length becomes 0
        while(sb.length()>0) {
            //for even length string
            if(sb.length()%2==0) {
                int k = sb.length()/2;
                //for even we get 2 chars, then if left character is smaller than right, remove left character from string & add it to end of encoded string
                if(sb.charAt(k-1)<=sb.charAt(k)) {
                    encodedString+=sb.charAt(k-1);
                    sb.deleteCharAt(k-1);
                }
                else {
                    encodedString+=sb.charAt(k);
                    sb.deleteCharAt(k);
                }
            }//even if condition ends...

            //for odd length string
            if(sb.length()%2!=0) {
                int k = sb.length()/2;
                encodedString+=sb.charAt(k);
                sb.deleteCharAt(k);
            }//odd if condition ends...
        }//while loop ends...
        return encodedString;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter string to encode : ");
        String inputString = sc.nextLine();
        System.out.println("Encoded string after applying algorithm :" + encode(inputString));
    }
}
