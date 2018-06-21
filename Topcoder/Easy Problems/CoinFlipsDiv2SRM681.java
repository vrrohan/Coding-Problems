/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=14138
Problem Statement
        You have n coins, labeled 0 through n-1. Each of the coins shows either heads or tails. You are given the states of all coins in the String state with n characters. For each i, state[i] is 'H' if coin i shows heads, or 'T' if it shows tails.
The coins are laid out in a row, ordered from coin 0 to coin n-1. A coin is called interesting if it differs from at least one of its neighbors. 
(For example, a coin that shows heads is interesting if at least one of its neighbors shows tails.) Return the number of interesting coins.
 
Definition        
Class:  CoinFlipsDiv2
Method: countCoins
Parameters: String
Returns:    int
Method signature:   int countCoins(String state)
(be sure your method is public)
     
Notes
-   The value of n is not given explicitly. Instead, you can determine it as the number of characters in state.
 
Constraints
-   state will have between 1 and 50 elements, inclusive.
-   Each character of state will be either 'H' or 'T'.
 
Examples
0)  "HT"
Returns: 2
Coin 0 is interesting because it shows heads and its only neighbor shows tails. Similarly, coin 1 is interesting because it shows tails and its only neighbor shows heads. Thus, the answer is 2.

1)  "T"
Returns: 0
In this test case there is a single coin. It has no neighbors, and therefore it has no different neighbors. This means that the coin is not interesting.

2)  "HHH"
Returns: 0
None of these coins are interesting, because each of them is only adjacent to coins that show the same side.

3)  "HHTHHH"
Returns: 3
Here, the three interesting coins are coins 1, 2, and 3. (Remember that the indices are 0-based.)

4)  "HHHTTTHHHTTTHTHTH"
Returns: 12
*/

import java.util.*;
public class CoinFlipsDiv2 {
    static int countCoins(String state) {
        int interestingCoins=0;

        //if only either H or T is present
        if(state.length()==1) {
            interestingCoins=0;
        }
        else {
            for(int i=0; i<state.length(); i++) {
                //for 1st coin state
                if(i==0) {
                    if(state.charAt(i)=='H'&state.charAt(i+1)=='T') {
                        interestingCoins++;
                    }
                    else if(state.charAt(i)=='T'&state.charAt(i+1)=='H') {
                        interestingCoins++;   
                    }    
                }
                //for last coin state
                else if(i==state.length()-1) {
                    if(state.charAt(i)=='H'&state.charAt(i-1)=='T') {
                        interestingCoins++;
                    }
                    else if(state.charAt(i)=='T'&state.charAt(i-1)=='H') {
                        interestingCoins++;   
                    }
                }
                else {
                    if(state.charAt(i)=='H'&state.charAt(i+1)=='T'|state.charAt(i)=='H'&state.charAt(i-1)=='T') {
                        interestingCoins++;
                    }
                    else if(state.charAt(i)=='T'&state.charAt(i+1)=='H'|state.charAt(i)=='T'&state.charAt(i-1)=='H') {
                        interestingCoins++;
                    }
                    //System.out.println("i=" + i + " , char at i =" + state.charAt(i) + " ,char at -i= " + state.charAt(i-1) + " ,char at +i=" + state.charAt(i+1));
                }
            }//for loop ends...
        }//else ends...
        return interestingCoins;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter all coin states : ");
        String coinFlips = sc.nextLine();
        System.out.println("\nNumber of interesting coins are : " + countCoins(coinFlips));
    }
}
