/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=12643
Problem Statement
        Fox Ciel is planning to register on TopFox. Her family name is familyName and her given name is givenName. 
She will choose a TopFox handle according to the following rule. Let s be a non-empty prefix of her family name and let t be a non-empty prefix of her given name. Now Fox Ciel may choose the concatenation of s and t as her handle. 
For example, suppose Fox Ciel's family name is "fox" and her given name is "ciel". She may choose the handle "foxciel", "fc", or "foxc". She may not choose "ox", "ciel", or "jiro". 
You are told Fox Ciel's family name and given name. Return the number of possible handles Fox Ciel may choose.
 
Definition        
Class:  TopFox
Method: possibleHandles
Parameters: String, String
Returns:    int
Method signature:   int possibleHandles(String familyName, String givenName)
(be sure your method is public)
    
Constraints
-   familyName will contain between 2 and 10 characters, inclusive.
-   Each character in familyName will be a lowercase English letter, i.e., 'a'-'z'.
-   givenName will contain between 2 and 10 characters, inclusive.
-   Each character in givenName will be a lowercase English letter, i.e., 'a'-'z'.
 
Examples
0)  "ab"
"cd"
Returns: 4
There are 4 possible handles: "a" + "c" = "ac", "a" + "cd" = "acd", "ab" + "c" = "abc" and "ab" + "cd" = "abcd".

1)  "abb"
"bbc"
Returns: 7
There are 7 possible handles: "ab", "abb", "abbc", "abbb", "abbbc", "abbbb", "abbbbc".

2)  "fox"
"ciel"
Returns: 12

3)  "abbbb"
"bbbbbbbc"
Returns: 16

4)  "abxy"
"xyxyxc"
Returns: 21

5)  "ababababab"
"bababababa"
Returns: 68
*/

import java.util.*;
public class TopFox {
    static int possibleHandles(String familyName,String givenName) {
        HashSet<String> handleNames = new HashSet<String>();
        for(int i=0; i<familyName.length(); i++) {
            String familyPrefix = familyName.substring(0,i+1);
            for(int j=0; j<givenName.length(); j++) {
                String givenPrefix="";
                givenPrefix=familyPrefix+givenName.substring(0,j+1);
                handleNames.add(givenPrefix);
            }
        }
        return handleNames.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter family name : ");
        String famName = sc.next();
        System.out.print("\nEnter given name : ");
        String givName = sc.next();
        System.out.println("\nnumber of possible handles are : " + possibleHandles(famName,givName));
    }
}
