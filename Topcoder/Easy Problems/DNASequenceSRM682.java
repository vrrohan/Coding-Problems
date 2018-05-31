/*
Original Problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=14164
Problem Statement
        For the purposes of this problem, a DNA sequence is a string consisting of the letters A, C, G, and T. 
You have been hired by researchers at TopBiologist to help them with some programming tasks. The researchers have found a sequence of uppercase letters, which is given to you in the String sequence. 
They have asked you to write a program which find the length of the longest DNA sequence that is a substring of sequence. 

A substring can be obtained from sequence by deleting some (possibly zero) characters from the beginning or end. For example, suppose sequence is the string "TOPBOATER". Then "TOP", "PBOA", "T", and "AT" are some examples of substrings of sequence. Of these examples, "T" and "AT" are DNA sequences. 
The answer to the problem would be 2 because "AT" is the longest such sequence and its length is 2. 

Please find and return the length of the longest DNA sequence that is a substring of sequence.
 
Definition        
Class:  DNASequence
Method: longestDNASequence
Parameters: String
Returns:    int
Method signature:   int longestDNASequence(String sequence)
(be sure your method is public)
     
Constraints
-   sequence will contain between 1 and 50 characters, inclusive.
-   Each character of sequence will be an upper-case English letter ('A'-'Z').
 
Examples
0)  "TOPBOATER"
Returns: 2
This is the example from the problem statement.

1)  "SUSHI"
Returns: 0
None of the substrings of "SUSHI" are DNA sequences, so the answer is 0.

2)  "GATTACA"
Returns: 7

3)  "GOODLUCK"
Returns: 1

4)  "VVZWKCSIQEGANULDLZESHUYHUQGRKUMFCGTATGOHMLKBIRCA"
Returns: 6
*/

import java.util.*;
public class DNASequence {
    static int longestDNASequence(String sequence) {
        int subSequenceLength = 0;
        int subSequenceCount = 0;
        boolean b = true;
        //this loop runs till string sequence length. Making running time complexity of O(n)
        for(int i=0; i<sequence.length(); i++) {
            //count only if any of these characters encountered - 'A', 'C', 'G' or 'T'
            if(sequence.charAt(i)=='A'|sequence.charAt(i)=='C'|sequence.charAt(i)=='G'|sequence.charAt(i)=='T') {
                subSequenceCount++;
                //compare everytime time we make a count & update the sub-sequence length
                if(subSequenceLength<=subSequenceCount) {
                    subSequenceLength=subSequenceCount;
                }
            }
            else {
                subSequenceCount=0;
            }
        }//end of for loop
        return subSequenceLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string sequence to get maximum DNA sequence length : ");
        String dnaSequence = sc.nextLine();

        System.out.println("\nMaximum DNA sub-sequence length is : " + longestDNASequence(dnaSequence.toUpperCase()));
    }
}
