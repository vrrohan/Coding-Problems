/*
Problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=14389
Problem Statement
        When dealing with long names and phrases, we sometimes use the initial letters of words to form its acronym. 
        For example, we use "JFK" instead of "John Fitzgerald Kennedy", "lgtm" instead of "looks good to me", and so on. 

You are given a String name. This String contains a phrase: one or more words separated by single spaces. Please compute and return the acronym of this phrase. (As above, the acronym should consist of the first letter of each word, in order.)
 
Definition -
Class:  Initials
Method: getInitials
Parameters: String
Returns:    String
Method signature:   String getInitials(String name)
(be sure your method is public)
    
 
Constraints -
-   name will contain between 1 and 50 characters, inclusive.
-   Each character in s will be a space or a lowercase English letter ('a' - 'z').
-   The first and last character in s will not be a space.
-   No two continuous spaces can appear in s.
 
Examples
0)  "john fitzgerald kennedy"
Returns: "jfk"
There are three words: "john", "fitzgerald" and "kennedy". Their first letters are 'j', 'f' and 'k'. The correct return value is their concatenation: the string "jfk". Note that all letters in our problem are in lowercase.

1)  "single"
Returns: "s"
There is only one word: "single". Its acronym has a single letter.

2)  "looks good to me"
Returns: "lgtm"

3)  "single round match"
Returns: "srm"

4)  "a aa aaa aa a bbb bb b bb bbb"
Returns: "aaaaabbbbb"
*/

import java.util.*;
public class Initials {
    
    static String getInitials(String phrase) {
        //first split the given phrase on basis of space between 2 words. s+ , if more than one space is there between 2 words
        String[] firstInitials = phrase.split("\\s+");
        String acronym = "";
        //concatenate empty string to first initials of every word from above string[]
        for(String s:firstInitials) {
            acronym+=s.charAt(0);
        }
        return acronym; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter phrase to get its acronym : ");
        String phrase = sc.nextLine();

        System.out.println("\nphrase is : " + phrase);
        System.out.println("acronym for phrase is : " + getInitials(phrase));
    }
}
