/*
Problem statement - https://www.hackerrank.com/contests/projecteuler/challenges/euler014

The following iterative sequence is defined for the set of positive integers:
n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?
NOTE: Once the chain starts the terms are allowed to go above one million.
*/

import java.util.*;
public class LongestCollatz {
    static int longestCollatzChainLength(int num) {
        int prevChainLength=1;
        int currentChainLength=0;
        int n=-1;
        for(int i=num; i>=2; i--) {
            currentChainLength=1;
            int elem=i;
            while(elem!=1) {
                //check if number is even
                if(elem%2==0) {
                    elem=elem/2;
                    currentChainLength++;
                }
                //check if number is odd
                else {
                    elem=3*elem+1;
                    currentChainLength++;
                }
            }
            //check if current chain is greater than previous chain
            if(currentChainLength>prevChainLength) {
                prevChainLength=currentChainLength;
                n=i;
            }    
        }//for loop ends...
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to find its largest collatz chain : ");
        int numb = sc.nextInt();
        System.out.println("number with maximum chain length is : " + longestCollatzChainLength(numb));
    }
}
