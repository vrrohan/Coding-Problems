/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=11823
Problem Statement
        King Dengklek is the perfect king of Kingdom of Ducks, where slimes and ducks live together in peace and harmony. 
After several years of waiting, King Dengklek and the queen finally had a baby. Now he is looking for a name for the newborn baby. According to the private rule of Kingdom of Ducks, the name of each member of the royal family must be such that: 

It must consist of exactly eight letters. All letters must be lowercase ('a'-'z').
It must have exactly two vowels and six consonants. (Vowels are the letters 'a', 'e', 'i', 'o', and 'u'; the rest are consonants.)
The two vowels must be equal.

For example, "dengklek" is a valid name because it consists of exactly eight letters: six consonants and two identical vowels, 'e'. 
You are given a String name. Please help the kingdom determine whether name is valid. Return "YES" if it is a valid name for King Dengklek's newborn baby, or "NO" otherwise.
 
Definition        
Class:  KingXNewBaby
Method: isValid
Parameters: String
Returns:    String
Method signature:   String isValid(String name)
(be sure your method is public)
    
Constraints
-   name will contain between 1 and 50 characters, inclusive.
-   Each character of name will be one of 'a'-'z'.
 
Examples
0)  "dengklek"
Returns: "YES"

1)  "gofushar"
Returns: "NO"
It has more than two vowels.

2)  "dolphinigle"
Returns: "NO"
It has more than eight letters.

3)  "mystictc"
Returns: "NO"
It has only one vowel.

4)  "rngringo"
Returns: "NO"
It has exactly two vowels, but they are not equal.

5)  "misof"
Returns: "NO"
It has less than eight letters.

6)  "metelsky"
Returns: "YES"
*/

import java.util.*;
public class KingXNewBaby {
    static String isValid(String name) {
        String isNameValid="No";
        int vowelsCount=0;
        int consonantsCount=0;
        char ch='\u0000';

        if(name.length()==8) {
            for(int i=0; i<name.length(); i++) {
                //check for vowels
                if(name.charAt(i)=='a'|name.charAt(i)=='e'|name.charAt(i)=='i'|name.charAt(i)=='o'|name.charAt(i)=='u') {
                    if(ch=='\u0000') {
                        ch=name.charAt(i);  
                        vowelsCount++;
                    }
                    else if(ch==name.charAt(i)) {vowelsCount++;}
                }//if ends...

                //check for consonants
                else {consonantsCount++;}
            }
        }
        isNameValid=(vowelsCount==2&consonantsCount==6)?"YES":"NO";
        return isNameValid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of child : ");
        String name = sc.next();
        System.out.println("\nIs child name valid ? " + isValid(name));
    }
}
