/*
Original Problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=13378
Problem Statement for DoubleLetter
Problem Statement
        You are given a String S. You can modify this string by repeating the following process:
Find the leftmost occurrence of two consecutive letters in S that are the same.
If you found a pair of identical letters in the first step, delete those two letters from S.
For example, if S="aabccb", you can proceed as follows:
Find and erase "aa", producing the string "bccb".
Find and erase "cc", producing the string "bb".
Find and erase "bb", producing the empty string.
For S="axxyybac" you can do at most two steps, erasing "xx" first and "yy" next. Once you obtain the string "abac", you are done. Note that you cannot erase the two "a"s because they are not consecutive. 
You want to change S into an empty string by repeating the operation described above. Return "Possible" if you can do that, and "Impossible" otherwise.
 
Definition        
Class:  DoubleLetter
Method: ableToSolve
Parameters: String
Returns:    String
Method signature:   String ableToSolve(String S)
(be sure your method is public)
    
Constraints
-   S will contain between 1 and 50 characters.
-   Each character in S will be a lowercase English letter ('a'-'z').
 
Examples
0)  "aabccb"
Returns: "Possible"

1)  "aabccbb"
Returns: "Impossible"
The process will terminate with a single 'b'.

2)  "abcddcba"
Returns: "Possible"
"abcddcba" -> "abccba" -> "abba" -> "aa" -> "".

3)  "abab"
Returns: "Impossible"
No two successive letters are the same, so we can't do any operation.

4)  "aaaaaaaaaa"
Returns: "Possible"

5)  "aababbabbaba"
Returns: "Impossible"

6)  "zzxzxxzxxzzx"
Returns: "Possible"
*/

import java.util.*;
public class DoubleLetter{
    static String ableToSolve(String str) {
        String status = "Impossible";
        boolean b = true;
        //we need to check till string length is reduced to 1 or 0
        while(str.length()>1&b) {
            for(int i=0; i<str.length()-1; i++) {
                //if 2 consecutive characters are similar then remove it using substring
                if(str.charAt(i)==str.charAt(i+1)) {
                    str = str.substring(0,i) + str.substring(i+2,str.length());
                    break;
                }
                else {
                    //this condition checks if there are no consecutive similar characters. i.e. all characters are different. Hence, set b to false & break at that point.
                    if(i==str.length()-2) {
                        b = false;
                        break;
                    }//if ends...
                }//else ends...
            }//end of for loop...
        }//end of while loop...

        //to check if string length is 0 or not. If string str still has some length it means string cannnot be reduced to empty string. Hence, "Impossible"
        if(b&str.length()==0) {
            status = "Possible";
        }
        else {
            status = "Impossible";
        }
        return status;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string to check if it is possible to change into empty string or not : ");
        String str = sc.nextLine();

        System.out.println("\nAnswer is : " + ableToSolve(str) + "\n-------------------------------------------");

        System.out.println("String 1 is : aabccb ==> " + ableToSolve("aabccb"));
        System.out.println("String 2 is : aabccbb ==> " + ableToSolve("aabccbb"));
        System.out.println("String 3 is : abab ==> " + ableToSolve("abab"));
        System.out.println("String 4 is : abcddcba ==> " + ableToSolve("abcddcba"));
        System.out.println("String 5 is : aaaaaaaaaa ==> " + ableToSolve("aaaaaaaaaa"));
        System.out.println("String 6 is : aababbabbaba ==> " + ableToSolve("aababbabbaba"));
        System.out.println("String 7 is : zzxzxxzxxzzx ==> " + ableToSolve("zzxzxxzxxzzx"));
        System.out.println("String 8 is : \"\" ==> " + ableToSolve(""));
        System.out.println("String 9 is : abcdefghijklmnop ==> " + ableToSolve("abcdefghijklmnop"));
        System.out.println("String 10 is : aabcdeffedcbmmmmkloolk ==> " + ableToSolve("aabcdeffedcbmmmmkloolk"));
        System.out.println("String 11 is : a ==> " + ableToSolve("a"));
        System.out.println("String 12 is : ab ==> " + ableToSolve("ab"));

    }
}
