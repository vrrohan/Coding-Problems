/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=12950
Problem Statement
Alien Fred wants to destroy the Earth, but he forgot the password that activates the planet destroyer.
You are given a String S. Fred remembers that the correct password can be obtained from S by erasing exactly one character.
Return the number of different passwords Fred needs to try.

Definition        
Class:  AlienAndPassword
Method: getNumber
Parameters: String
Returns:    int
Method signature:   int getNumber(String S)
(be sure your method is public)
    
Constraints
-   S will contain between 1 and 50 characters, inclusive.
-   Each character in S will be an uppercase English letter ('A'-'Z').
 
Examples
0)  "A"
Returns: 1
In this case, the only password Fred needs to try is an empty string.

1)  "ABA"
Returns: 3
The following three passwords are possible in this case: "BA", "AA", "AB".

2)  "AABACCCCABAA"
Returns: 7

3)  "AGAAGAHHHHFTQLLAPUURQQRRRUFJJSBSZVJZZZ"
Returns: 26

4)  "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"
Returns: 1
Regardless of which character we erase, we will always obtain the same string. Thus there is only one possible password: the string that consists of 49 'Z's.
*/

import java.util.*;
public class AlienAndPassword {
    static int getNumber(String s) {
        int differDistinctPassword=0;
        ArrayList<String> distinctPasswords = new ArrayList<String>();
        for(int i=0; i<s.length(); i++) {
            if(!distinctPasswords.contains(s.substring(0,i)+s.substring(i+1,s.length()))) {
                distinctPasswords.add(s.substring(0,i)+s.substring(i+1,s.length()));
            }
        }
        differDistinctPassword=distinctPasswords.size();
        return differDistinctPassword;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password string : ");
        String pass = sc.nextLine();
        System.out.println("\nNumber of different passwords fred need to try are : " + getNumber(pass));
    }
}
