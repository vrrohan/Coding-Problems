/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=12858
Problem Statement
        It's winter time! Time to eat a lot of mandarins with your friends.
You have several bags with mandarins. You are given an int[] bags. For each i, the i-th element of bags represents the number of mandarins in the i-th bag. You are also given an int K. You want to choose exactly K bags and distribute them among you and your friends. To be as fair as possible, you want to minimize the difference between the chosen bag with most mandarins and the chosen bag with fewest mandarins. Return the smallest difference that can be achieved.

Definition        
Class:  WinterAndMandarins
Method: getNumber
Parameters: int[], int
Returns:    int
Method signature:   int getNumber(int[] bags, int K)
(be sure your method is public)
    
Constraints
-   bags will contain between 2 and 50 elements, inclusive.
-   Each element of bags will be between 1 and 1,000,000,000, inclusive.
-   K will be between 2 and N, inclusive, where N is the number of elements in bags.
 
Examples
0)  {10, 20, 30}
2
Returns: 10
There are three ways to choose two bags in this case: {10, 20}, {20, 30}, and {10, 30}. Both in the first case and in the second case the difference between the largest and the smallest number of mandarins is 10. In the third case the difference is 20. Thus, the smallest possible difference is 10.

1)  {4, 7, 4}
3
Returns: 3

2)  {4, 1, 2, 3}
3
Returns: 2

3)  {5, 4, 6, 1, 9, 4, 2, 7, 5, 6}
4
Returns: 1

4)  {47, 1000000000, 1, 74}
2
Returns: 27
*/

import java.util.*;
public class WinterAndMandarins {
    //this method takes int[] & returns sorted array using collections
    //first input array is copied into new arraylist, that arraylist is sorted using Collections.sort() & then converts back to int[]
    static int[] getSortedMandarinBags(int[] arr) {
        int[] sortedArray = new int[arr.length];
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++) {
            al.add(arr[i]);
        }
        Collections.sort(al);
        for(int i=0; i<al.size(); i++) {
            sortedArray[i]=al.get(i);
        }
        return sortedArray;
    }

    static int getNumber(int[] bags, int K) {
        int[] sortedMandarinBags = getSortedMandarinBags(bags);
        int minBagCost = sortedMandarinBags[0];
        int maxBagCost = sortedMandarinBags[0+K-1];
        int minimumMandarinCost = maxBagCost-minBagCost;

        for(int i=0; i<=sortedMandarinBags.length-K; i++) {
            for(int j=i; j<i+K; j++) {
                minBagCost = sortedMandarinBags[i];
                maxBagCost = sortedMandarinBags[i+K-1];
                if((maxBagCost-minBagCost)<=minimumMandarinCost) {
                    minimumMandarinCost=maxBagCost-minBagCost;
                }
            }//end of for loop...
        }//outer for loop...
        return minimumMandarinCost;
    }

    public static void main(String[] args) {
        int[] arr = {47,1000000000,1,74};
        int[] arr2 = {10,20,30};
        int[] arr3 = {4,7,4};
        int[] arr4 = {4,1,2,3};
        int[] arr5 = {5,4,6,1,9,4,2,7,5,6};   

        System.out.println("minimum mandarin cost is : " + getNumber(arr,2));
        System.out.println("minimum mandarin cost is : " + getNumber(arr2,2));
        System.out.println("minimum mandarin cost is : " + getNumber(arr3,3));
        System.out.println("minimum mandarin cost is : " + getNumber(arr4,3));
        System.out.println("minimum mandarin cost is : " + getNumber(arr5,4));
    }
}
