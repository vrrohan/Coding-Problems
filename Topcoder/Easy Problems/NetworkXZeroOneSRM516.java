/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=11524
Problem Statement
        Toastman has sent Fox Ciel a message consisting entirely of lowercase 'o' and 'x' letters. 
        This message has the interesting property that for any even-length contiguous substring of this message, the number of 'o's will equal the number of 'x's. 
Unfortunately due to the nature of the network, some of the letters in the message can become corrupted. You are given a String message, each character of which is 'o', 'x', or '?'. 'o' or 'x' denotes that the letter in the message is not corrupted and is equal to the corresponding letter. 
A '?' denotes that the letter at that position is corrupted and might have been either 'o' or 'x'. 

Your job is to replace each of the '?' characters in the input by either 'o' or 'x' such that the resulting message has the interesting property described above, and return that corrected message. 
It is guaranteed that there will be exactly one such message for the given input.
 
Definition        
Class:  NetworkXZeroOne
Method: reconstruct
Parameters: String
Returns:    String
Method signature:   String reconstruct(String message)
(be sure your method is public)
    
Constraints
-   message will contain between 2 and 50 characters, inclusive.
-   Each character in message will be lowercase 'o', lowercase 'x', or '?'.
-   There will be exactly one possible corrected message which has the interesting property described in the problem statement.
 
Examples
0)  "x?x?"
Returns: "xoxo"
Consider the entire message, which is a contiguous substring of the input message of length 4, which is even. It has two 'x's, so it follows that the other two '?' characters must be both 'o'.

1)  "?xo?"
Returns: "oxox"
Consider the first two characters of message. Since it's a contiguous substring of the input message and has a length of 2, which is even, and since it already contains one 'x', the first '?' must be 'o'. Then, by considering the entire message as a contiguous substring of length 4, the last character must be 'x'.

2)  "xo"
Returns: "xo"
Sometimes the message is not corrupted.

3) "o??x??o"
Returns: "oxoxoxo"

4)  "???????x"
Returns: "oxoxoxox"
*/

import java.util.*;
public class NetworkXZeroOne {
    static String reconstruct(String message) {
        String reconstMessage="";
        int indexOfChar=0;
        for(int i=0; i<message.length(); i++) {
            if(message.charAt(i)=='o'|message.charAt(i)=='x') {
                indexOfChar=i;    break;
            }
        }

        for(int i=0; i<message.length(); i++) {
            if((message.charAt(i)=='?')&(i%2==0)) {
                if((message.charAt(indexOfChar)=='x') & (indexOfChar%2==0)) {
                    reconstMessage+="x";
                }
                else if((message.charAt(indexOfChar)=='o') & (indexOfChar%2==0)){
                    reconstMessage+="o";
                }
                else if((message.charAt(indexOfChar)=='x') & (indexOfChar%2==1)) {
                    reconstMessage+="o";
                }
                else {
                    reconstMessage+="x";
                }
            }
            else if((message.charAt(i)=='?')&(i%2==1)) {
                if((message.charAt(indexOfChar)=='o') & (indexOfChar%2==0)) {
                    reconstMessage+="x";
                }
                else if((message.charAt(indexOfChar)=='x') & (indexOfChar%2==0)) {
                    reconstMessage+="o";
                }
                else if((message.charAt(indexOfChar)=='o') & (indexOfChar%2==1)) {
                    reconstMessage+="o";
                }
                else {
                    reconstMessage+="x";
                }
            }
            else if((message.charAt(i)=='x')) {
                reconstMessage+="x";
            }
            else {
                reconstMessage+="o";
            }
        }//for loop ends...
        return reconstMessage;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter corrupted message : ");
        String message = sc.nextLine();

        System.out.println("original message is after reconstruction is : " + reconstruct(message));

    }
}
