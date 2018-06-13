/*
Original Problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=11084
Problem Statement for TwoWaysSorting
Problem Statement
        Sasha has a String[] stringList. No two elements of stringList have the same length.
So far, Sasha has learned two ways of sorting strings:

He can sort strings lexicographically. For example, "car" < "carriage" < "cats" < "doggies". (See Notes for a definition of the lexicographic order.)
He can also sort strings according to their lengths in ascending order. For example, "car" < "cats" < "doggies" < "carriage".
Sasha now wonders whether stringList is sorted in either of these two ways. Return "lexicographically" (quotes for clarity) if stringList is sorted lexicographically but not according to the string lengths. Return "lengths" if stringList is sorted according to the string lengths but not lexicographically. Return "both" if it is sorted in both ways. Otherwise, return "none".

Definition        
Class:  TwoWaysSorting
Method: sortingMethod
Parameters: String[]
Returns:    String
Method signature:   String sortingMethod(String[] stringList)
(be sure your method is public)
     
Notes
-   String A is lexicographically smaller than string B if A contains a character with a smaller ASCII value in the first position where they differ. In case one of the strings ends before they have a different character, the shorter one is considered smaller.
 
Constraints
-   stringList will contain between 1 and 50 elements, inclusive.
-   Each element of stringList will contain between 1 and 50 characters, inclusive.
-   Each character of each element of stringList will be a lowercase English letter ('a'-'z').
-   Every two elements of stringList will have different lengths.
 
Examples
0)  {"a", "aa", "bbb"}
Returns: "both"
These strings are sorted both lexicographically and according to their lengths.

1)  {"c", "bb", "aaa"}
Returns: "lengths"
The lengths of these strings are in ascending order. However, they are not sorted lexicographically as, for instance, "aaa" is lexicographically smaller than "c".

2)  {"etdfgfh", "aio"}
Returns: "none"
Here the first string is longer than the second one, so they are not sorted according to length. (Note that we require the lengths to be in ascending order.) Similarly, they are not sorted lexicographically: "aio" should come before "etdfgfh".

3)  {"aaa", "z"}
Returns: "lexicographically"
The input strings are sorted lexicographically only.

4)  {"z"}
Returns: "both"

5)  {"abcdef", "bcdef", "cdef", "def", "ef", "f", "topcoder"}
Returns: "lexicographically"
*/

public class TwoWaysSorting {
    static String sortingMethod(String[] strList) {
        String sortWays = "both";
        boolean isSortByLength = true;
        boolean isSortLexico = true;

        //check if string list is sorted by length or not
        for(int i=0; i<strList.length-1; i++) {
            if(strList[i].length()>strList[i+1].length()) {
                isSortByLength=false;
                break;
            }
        }//sort by length condition ends...

        //check for lexicographical sorting
        for(int i=0; i<strList.length-1; i++) {
            if(strList[i].compareTo(strList[i+1])>0) {
                isSortLexico=false;
                break;
            }
        }

        if(isSortByLength) {
            sortWays = (isSortLexico) ? "both" : "lengths";
        }

        if(isSortLexico&!isSortByLength) {
            sortWays="lexicographically";
        }

        if(!isSortLexico & !isSortByLength) {
            sortWays="none";
        }
        return sortWays;
    }

    public static void main(String[] args) {
        
        String[] list1 = {"a","aa","bbb"};
        String[] list2 = {"c","bb","aaa"};
        String[] list3 = {"aaa","z"};
        String[] list4 = {"abcdef", "bcdef", "cdef", "def", "ef", "f", "topcoder"};
        String[] list5 = {"z"};
        String[] list6 = {"etdfgfh","aio"};

        System.out.println(sortingMethod(list1));
        System.out.println(sortingMethod(list2));
        System.out.println(sortingMethod(list3));
        System.out.println(sortingMethod(list4));
        System.out.println(sortingMethod(list5));
        System.out.println(sortingMethod(list6));
    }
}
