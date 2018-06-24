/*
Original problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=11307
Problem Statement
        Rabbit Hanako has N boxes of carrots numbered 0 through N-1. The i-th box contains carrots[i] carrots. 
She decides to eat K carrots from these boxes. She will eat the carrots one at a time, each time choosing a carrot from the box with the greatest number of carrots. 
If there are multiple such boxes, she will choose the lowest numbered box among them. Return the number of the box from which she will eat her last carrot.
 
Definition
Class:  CarrotBoxesEasy
Method: theIndex
Parameters: int[], int
Returns:    int
Method signature:   int theIndex(int[] carrots, int K)
(be sure your method is public)
    
Constraints
-   carrots will contain between 1 and 50 elements, inclusive.
-   Each element of carrots will be between 1 and 100, inclusive.
-   K will be between 1 and the sum of all elements of carrots, inclusive.
 
Examples
0)  {5, 8}
3
Returns: 1
She will choose three carrots from box 1.

1)  {5, 8}
4
Returns: 0
After she chooses three carrots from box 1, both boxes contain 5 carrots. She will choose the 4th carrot from the lowest indexed box.

2)  {4, 9, 5}
18
Returns: 2

3)  {13, 75, 24, 55}
140
Returns: 0

4)  {14, 36, 52, 86, 27, 97, 3, 67}
300
Returns: 4
*/

public class CarrotBoxesEasy {
    
    static boolean allSameCarrots(int[] arr) {
        boolean allBoxesSameCarrots=true;
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i]!=arr[i+1]) {
                allBoxesSameCarrots=false;
                break;
            }
        }
        return allBoxesSameCarrots;
    }

    static int theIndex(int[] carrots, int K) {
        int lastBox=0;
        int carrotsEaten=0;

        while(!allSameCarrots(carrots) & carrotsEaten<K) {
            //find max carrot box & eat 1 carrot
            int max=-1;
            int index=-1;
            for(int i=0; i<carrots.length; i++) {
                if(carrots[i]>max) {
                    max=carrots[i]; 
                    index=i;    
                }
            }//for loop ends...
            carrots[index]--;
            carrotsEaten++;
            lastBox=index;
        }//while ends...

        //when all boxes have same number of carrots
        while(allSameCarrots(carrots) & carrotsEaten<K) {
            for(int i=0; i<carrots.length&carrotsEaten<K; i++) {
                carrots[i]--;
                lastBox=i;
                carrotsEaten++;
            }
        }
        return lastBox;
    }

    public static void main(String[] args) {
        int[] carrotBoxes1 = {5, 8};
        int[] carrotBoxes2 = {14, 36, 52, 86, 27, 97, 3, 67};
        int[] carrotBoxes3 = {13, 75, 24, 55};
        int[] carrotBoxes4 = {4, 9, 5};
        System.out.println("last box from which carrot was eaten is : " + theIndex(carrotBoxes1,3));
        System.out.println("last box from which carrot was eaten is : " + theIndex(carrotBoxes2,300));
        System.out.println("last box from which carrot was eaten is : " + theIndex(carrotBoxes3,140));
        System.out.println("last box from which carrot was eaten is : " + theIndex(carrotBoxes4,18));
    }
}
