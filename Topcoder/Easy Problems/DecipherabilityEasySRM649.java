/*
Original problem statement - https://community.topcoder.com/stat?c=problem_statement&pm=13658
Problem Statement
        You had a non-empty string s but you lost it. Cat Snuke found the string and removed one character from the string. 
        Later, Snuke gave you the string t. Can this be the string created from your string s?
You are given the Strings s and t. Return "Possible" (quotes for clarity) if t can be obtained from s by erasing exactly one character. Otherwise, return "Impossible". 
Note that the return value is case-sensitive.
 
Definition        
Class:  DecipherabilityEasy
Method: check
Parameters: String, String
Returns:    String
Method signature:   String check(String s, String t)
(be sure your method is public)
    
Constraints
-   The number of characters in s will be between 1 and 50, inclusive.
-   Every character in s will be a lowercase letter ('a'-'z').
-   The number of characters in t will be between 1 and 50, inclusive.
-   Every character in t will be a lowercase letter ('a'-'z').
 
Examples
0) "sunuke"
"snuke"
Returns: "Possible"
If Cat Snuke erase the first 'u' from s, it will equal to t.

1) "snuke"
"skue"
Returns: "Impossible"
Swapping characters is not allowed.

2) "snuke"
"snuke"
Returns: "Impossible"
Erasing nothing is not allowed.

3) "snukent"
"snuke"
Returns: "Impossible"
Cat Snuke can erase exactly one character.

4) "aaaaa"
"aaaa"
Returns: "Possible"

5) "aaaaa"
"aaa"
Returns: "Impossible"

6) "topcoder"
"tpcoder"
Returns: "Possible"

7) "singleroundmatch"
"singeroundmatc"
Returns: "Impossible"
*/

import java.util.*;
public class DecipherabilityEasy {
    static String check(String s, String t) {
        String stringObtained="Impossible";
        for(int i=0; i<s.length(); i++) {
            StringBuffer sb = new StringBuffer(s);
            sb = sb.deleteCharAt(i);
            if(sb.toString().compareTo(t)==0) {
                stringObtained="Possible";
                break;
            }//if ends...
        }//for loop ends...
        return stringObtained;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string s : ");
        String s = sc.next();
        System.out.print("Enter string t : ");
        String t = sc.next();

        System.out.println("String " + t + " obtained after deleting exactly one character from " + s + " is : " + check(s,t));
    }
}
