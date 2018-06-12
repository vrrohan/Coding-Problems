/*
Original Problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=12334
Problem Statement
        Fox Ciel has a new favorite string operation that works as follows: She takes two copies of some string X, and inserts one copy somewhere into the other copy of the same string. (She can also insert it at the beginning or, equivalently, at the end.) This operation is called expansion of the string X. 
        For example, if X = "Ciel", she can expand it to "CielCiel", "CCieliel", "CiCielel", or "CieCiell". 

You are given two Strings: S and T. 
Return "Yes" (quotes for clarity) if T can be obtained by expanding S exactly once. Otherwise, return "No".
 
Definition       
Class:  FoxAndHandleEasy
Method: isPossible
Parameters: String, String
Returns:    String
Method signature:   String isPossible(String S, String T)
(be sure your method is public)
    
Constraints
-   S will contain between 1 and 50 characters, inclusive.
-   T will contain between 1 and 50 characters, inclusive.
-   Both S and T will contain uppercase and lowercase letters only ('A'-'Z' and 'a'-'z').
 
Examples
0)  "Ciel"
"CieCiell"
Returns: "Yes"
She can insert "Ciel" between "Cie" and "l".

1)  "Ciel"
"FoxCiel"
Returns: "No"
Each string obtained by expanding S="Ciel" has exactly 8 letters.

2)  "FoxCiel"
"FoxFoxCielCiel"
Returns: "Yes"

3)  "FoxCiel"
"FoxCielCielFox"
Returns: "No"

4)  "Ha"
"HaHaHaHa"
Returns: "No"

5)  "TheHandleCanBeVeryLong"
"TheHandleCanBeVeryLong"
Returns: "No"

6)  "Long"
"LongLong"
Returns: "Yes"
*/

public class FoxAndHandleEasy {
    static String isPossible(String S,String T) {
        String status = "No";
        //We check only if T string is double of length of String S
        //For other cases, it will always be "No"
        if(2*S.length()==T.length()) {
            //Check for concatenate condition i.e. if string S is = Hey ==> S+S=HeyHey, which is equal to T
            if((S+S).equals(T)) {
                status = "Yes";
            }
            else {
                for(int i=0; i<S.length(); i++) {
                    //start adding S to every index position of String S & then compare it with String T.
                    //Example - S=Hey, T=HeHeyy ==> HHeyey(No), HeHeyy(Yes)
                    String str = S.substring(0,i+1)+S+S.substring(i+1);
                    if(str.equals(T)) {
                        status="Yes";   break;
                    }
                }//for loop ends...
            }//else ends...
        }//if condition ends...
        return status;
    }

    public static void main(String[] args) {
        System.out.println("Can obtain string1 (Ciel,CieCiell) : " + isPossible("Ciel","CieCiell"));
        System.out.println("Can obtain string2 (Ciel,FoxCiel) : " + isPossible("Ciel","FoxCiel"));
        System.out.println("Can obtain string3 (FoxCiel,FoxFoxCielCiel) : " + isPossible("FoxCiel","FoxFoxCielCiel"));
        System.out.println("Can obtain string3 (FoxCiel,FoxCielCielFox) : " + isPossible("FoxCiel","FoxCielCielFox"));
        System.out.println("Can obtain string3 (Ha,HaHaHaHa) : " + isPossible("Ha","HaHaHaHa"));
        System.out.println("Can obtain string3 (TheHandleCanBeVeryLong,TheHandleCanBeVeryLong) : " + isPossible("TheHandleCanBeVeryLong","TheHandleCanBeVeryLong"));
        System.out.println("Can obtain string3 (Long,LongLong) : " + isPossible("Long","LongLong"));
        System.out.println("Can obtain string3 (SimpleBells,SimpleBeSimpleBellslls) : " + isPossible("SimpleBells","SimpleBeSimpleBellslls"));
        System.out.println("Can obtain string3 (FortuneSays,Fort) : " + isPossible("FortuneSays","Fort"));
        System.out.println("Can obtain string3 (BruteForce,BruteForBruteForcce) : " + isPossible("BruteForce","BruteForBruteForcce"));
    }
}
