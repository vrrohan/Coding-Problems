
/*
Problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=14783
Problem Statement
        
Definition: a string is beautiful if it has two consecutive equal characters. 
Examples of beautiful strings are "KEEP", "ZZZZZ" and "TTORR", while the following are not beautiful: "A", "GH" and "ABCABCBX".

You are given the String S and you are going to remove exactly one character from S. Is it possible that the new string will be beautiful? If yes, return "Possible". Otherwise, return "Impossible".

Note that the return value is case-sensitive.
 
Definition
        
Class:  MakeTwoConsecutive
Method: solve
Parameters: String
Returns:    String
Method signature:   String solve(String S)
(be sure your method is public)
    
 
Constraints
-   S will contain between 1 and 50 characters, inclusive.
-   Each character in S will be an uppercase English letter: 'A' - 'Z'.
 
Examples
0)  "VIKING"
Returns: "Possible"
You can remove 'K' to obtain the string "VIING". This string is beautiful because it has two consecutive 'I'.

1)  "BCAB"
Returns: "Impossible"
You can only get one of the following strings: "CAB", "BAB", "BCB" and "BCA". None of these are beautiful, so the answer is "Impossible".

2)  "XX"
Returns: "Impossible"
After removing one character you will get the string "X" that isn't beautiful. Please note that you have to remove exactly one character.

3)  "A"
Returns: "Impossible"
After removing one character you will get the empty string "". It isn't beautiful.

4)  "AABB"
Returns: "Possible"
You can get either "ABB" or "ABB". Both these strings are beautiful.

5)  "QWERTYY"
Returns: "Possible"
There are a few beautiful strings you can get. Some of them are "WERTYY" and "QWETYY".

6)  "ITHINKYOUAREAHUMAN"
Returns: "Impossible"

7)  "BOB"
Returns: "Possible"
*/

public class BeautifulStrings {
    
    static boolean getPossibleString(String str) {
        boolean b = false;
        if(str.length()==1|str.length()==2) {
            b = false;
        }
        else {
            if(str.charAt(0)==str.charAt(1)|str.charAt(str.length()-1)==str.charAt(str.length()-2)) {
                b=true;
            }
            else {
                for(int i=0; i<str.length()-2; i++) {
                    if(str.charAt(i)==str.charAt(i+2)) {
                        b= true;
                        break;
                    }
                }
            }//inner else ends...
        }//else ends...
        return b;
    }

    public static void main(String[] args) {
        String str = args[0];
        boolean b = getPossibleString(str);

        if(b) {
            System.out.println("possible string");
        }
        else {
            System.out.println("not possible string");
        }

    }
}

