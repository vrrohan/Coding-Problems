/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=12863
Problem Statement
        Fox Ciel received a string as a birthday present. However, the string was too long for her, so she decided to make it shorter by erasing some characters. 
The erasing process will look as follows:
Find the smallest i such that the i-th character and the (i+1)-th character of the string are same.
If there is no such i, end the process.
Remove the i-th and the (i+1)-th character of the string, and repeat from 1.
For example, if she receives "cieeilll", she will change the string as follows: "cieeilll" -> "ciilll" -> "clll" -> "cl". You are given a String s. Return the string she will get after she erases characters as described above.
 
Definition        
Class:  ErasingCharacters
Method: simulate
Parameters: String
Returns:    String
Method signature:   String simulate(String s)
(be sure your method is public)
     
Constraints
-   s will contain between 1 and 50 characters, inclusive.
-   Each character in s will be a lowercase letter ('a'-'z').
 
Examples
0)  "cieeilll"
Returns: "cl"
This is the example from the statement.

1)  "topcoder"
Returns: "topcoder"
She won't erase any characters at all.

2)  "abcdefghijklmnopqrstuvwxyyxwvutsrqponmlkjihgfedcba"
Returns: ""

3)  "bacaabaccbaaccabbcabbacabcbba"
Returns: "bacbaca"

4)  "eel"
Returns: "l"
*/

import java.util.*;
public class ErasingCharacters {
    static String simulate(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean b=true;
        while(b|sb.length()==0) {
            int isDeleted=0;
            for(int i=0; i<sb.length()-1; i++) {
                if(sb.charAt(i)==sb.charAt(i+1)) {
                   // System.out.println(sb.charAt(i));
                    sb=sb.deleteCharAt(i);
                 //   System.out.println(sb.charAt(i));
                    sb=sb.deleteCharAt(i);
                    isDeleted++;
                }
               // System.out.println("string after if is : " + sb);
            }//for loop ends...
            if(isDeleted==0|sb.length()==0) {
                b=false;
                break;
            }
        }//while ends...
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String inpString = sc.nextLine();

        System.out.println("\nString after erasing algorithm : " + simulate(inpString));    
    }
}
