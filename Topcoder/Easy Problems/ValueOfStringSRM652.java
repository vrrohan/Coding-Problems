/*
Original problem statement link- https://community.topcoder.com/stat?c=problem_statement&pm=13678
Problem Statement        
You are given a String s consisting of lower case letters. We assign the letters 'a' to 'z' values of 1 to 26, respectively. 
We will denote the value assigned to the letter X by val[X]. For example, val['a'] = 1 and val['e'] = 5.
We define the value of the string s as follows. For each letter s[i], let k[i] be the number of letters in s that are less than or equal to s[i], including s[i] itself. 
Then, the value of s is defined to be the sum of k[i] * val[s[i]] for all valid i.

Given the string, compute and return the value of the string.
 
Definition        
Class:  ValueOfString
Method: findValue
Parameters: String
Returns:    int
Method signature:   int findValue(String s)
(be sure your method is public)
    
Constraints
-   s will contain between 1 and 50 characters, inclusive.
-   s will consist of lowercase letters ('a'-'z').
 
Examples
0)  "babca"
Returns: 35
The value of this string is 2*4 + 1*2 + 2*4 + 3*5 + 1*2 = 35.
We can get the value as follows. The first character is a 'b' which has value 2, and has 4 characters that are less than or equal to it in the string (i.e. the first, second, third and fifth character of the string). 
Thus, this first character contributes 2*4 to the sum. We can derive a similar expression for each of the other characters.

1)  "zz"
Returns: 104

2)  "y"
Returns: 25

3)  "aaabbc"
Returns: 47

4)  "topcoder"
Returns: 558

5)  "thequickbrownfoxjumpsoverthelazydog"
Returns: 11187

6)  "zyxwvutsrqponmlkjihgfedcba"
Returns: 6201
*/

import java.util.*;
public class ValueOfString {
    static int findValue(String s) {
        int strValue=0;
        for(int i=0; i<s.length(); i++) {
            //System.out.println("char = " + s.charAt(i) + " ,ascii = "+ (s.codePointAt(i)%97+1));
            int charValue = s.codePointAt(i)%97+1;
            int cp=0;
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j)<=s.charAt(i)) {
                    cp++;
                }
            }
            strValue+=cp*charValue;
        }
        return strValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter string value : ");
        String str = sc.nextLine();
        System.out.println("Total string value is : " + findValue(str));
    }
}
