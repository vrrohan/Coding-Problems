/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=13487
Problem Statement
        We call a pair of Strings (s, t) "wood" if t is contained in s as a subsequence. (See Notes for a formal definition.)
Given Strings s and t, return the String "Yep, it's wood." (quotes for clarity) if the pair (s, t) is wood and "Nope." otherwise.
 
Definition
Class:  IdentifyingWood
Method: check
Parameters: String, String
Returns:    String
Method signature:   String check(String s, String t)
(be sure your method is public)
    
Notes
-   String t is contained in string s as a subsequence if we can obtain t by removing zero or more (not necessarily consecutive) characters from s.
 
Constraints
-   s and t will consist only of lowercase English letters.
-   s and t will each be between 1 and 10 characters long, inclusive.
 
Examples
0)      
"absdefgh"
"asdf"
Returns: "Yep, it's wood."

1)          
"oxoxoxox"
"ooxxoo"
Returns: "Nope."

2)          
"oxoxoxox"
"xxx"
Returns: "Yep, it's wood."

3)          
"qwerty"
"qwerty"
Returns: "Yep, it's wood."

4)          
"string"
"longstring"
Returns: "Nope."
*/

import java.util.*;
public class IdentifyingWoods {
    static String check(String s, String t) {
        String woodPair="Yep, it's wood.";
        String str="";
        int k=0;
        for(int i=0; i<t.length(); i++) {
            while(k<s.length()) {
                if(t.charAt(i)!=s.charAt(k)) {
                    k++;
                }
                else {
                    k++;
                    str+=String.valueOf(t.charAt(i));
                    break;
                }
            }//while ends...
        }//for loop ends...
        woodPair=(str.compareTo(t)==0)?"Yep, it's wood.":"Nope.";
        return woodPair;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string s : ");
        String s = sc.next();
        System.out.print("\nEnter string t : ");
        String t = sc.next();

        System.out.println("Is pair " + s + " and " + t + " wood : " + check(s,t));
    }
}
