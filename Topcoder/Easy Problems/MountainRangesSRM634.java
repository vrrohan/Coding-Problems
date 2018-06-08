/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=13454
Problem Statement
Tom is in charge of a tourist agency. He has a lovely picture of the local mountain range. 
He would like to sell it to the tourists but first he needs to know how many peaks are visible in the picture.
The mountain range in the picture can be seen as a sequence of heights. You are given these heights as a int[] height. 
An element of height is called a peak if its value is strictly greater than each of the values of adjacent elements. Compute and return the number of peaks in the given mountain range.

 
Definition        
Class:  MountainRanges
Method: countPeaks
Parameters: int[]
Returns:    int
Method signature:   int countPeaks(int[] heights)
(be sure your method is public)
    
Constraints
-   heights will contain between 1 and 50 elements, inclusive.
-   Each element of heights will be between 1 and 100, inclusive.
 
Examples
0)  {5, 6, 2, 4}
Returns: 2
Element 1 (0-based index) is a peak. Its height is 6, which is strictly greater than each of its neighbors' heights (5 and 2). Element 3 is also a peak since its height is 4 and that is strictly greater than its neighbor's height (which is 2).

1)  {1, 1, 1, 1, 1, 1, 1}
Returns: 0
This is a very flat mountain with no peaks.

2)  {2, 1}
Returns: 1
Element 0 is a peak.

3)  {2,5,3,7,2,8,1,3,1}
Returns: 4
The peaks here are the elements with 0-based indices 1, 3, 5, and 7. Their heights are 5, 7, 8, and 3, respectively.

4)  {1}
Returns: 1
Element 0 is a peak. Even though it has no neighbors, the condition from the problem statement is still satisfied.

5)  {1,2,3,4,4,3,2,1}
Returns: 0
According to our definition there is no peak in this mountain range.
*/

public class MountainRanges {
    static int countPeaks(int[] heights) {
        int numOfPeaks = 0;
        //if picture contains only 1 mountain peaks, then it itself is a peak count
        if(heights.length==1) {
            numOfPeaks++;
        }
        else {
            for(int i=0; i<heights.length; i++) {
                //condition for 1st element, check if peak greater than its right mountain peak. Don't check for left peak else it will gove ArrayIndexOutOfBoundException
                if(i==0) {
                    if(heights[i]>heights[i+1]) {
                        numOfPeaks++;
                    }
                }
                //condition for last element, check if peak greater than its left mountain peak. Don't check for right peak else it will gove ArrayIndexOutOfBoundException
                if(i==heights.length-1) {
                    if(heights[heights.length-1]>heights[heights.length-2]) {
                        numOfPeaks++;
                    }
                }
                //condition for elements between 1st and last elements. i.e. check if current peak is greater than its neighbour mountain peaks
                if((i>0)&(i<heights.length-1)) {
                    if((heights[i]>heights[i+1])&(heights[i]>heights[i-1])) {
                        numOfPeaks++;    
                    }
                }
            }//for loop ends...    
        }//else ends...
        return numOfPeaks;
    }

    public static void main(String[] args) {
        int[] mountainRanges1 = {5,6,2,4};
        int[] mountainRanges2 = {1,1,1,1,1,1,1,1};
        int[] mountainRanges3 = {2,1};
        int[] mountainRanges4 = {2,5,3,7,2,8,1,3,1};
        int[] mountainRanges5 = {1};
        int[] mountainRanges6 = {1,2,3,4,4,3,2,1};

        System.out.println("maximum number of peaks for range 1 are : " + countPeaks(mountainRanges1));
        System.out.println("maximum number of peaks for range 2 are : " + countPeaks(mountainRanges2));
        System.out.println("maximum number of peaks for range 3 are : " + countPeaks(mountainRanges3));
        System.out.println("maximum number of peaks for range 4 are : " + countPeaks(mountainRanges4));
        System.out.println("maximum number of peaks for range 5 are : " + countPeaks(mountainRanges5));
        System.out.println("maximum number of peaks for range 6 are : " + countPeaks(mountainRanges6));
    }
}
