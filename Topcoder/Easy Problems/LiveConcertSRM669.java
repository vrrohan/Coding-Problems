/*
Original problem statement - https://community.topcoder.com/stat?c=problem_statement&pm=13948
Problem Statement        
Today, a large live concert is going to take place. Some interprets (called "idols") are going to perform at the concert. 
Different idols have different names.
There are M distinct songs that can be included in the concert. The songs are numbered 0 through M-1. Song i can only be performed by the idol s[i]. Including this song in the concert will increase the happiness of the audience by h[i].
We have to choose the set list for this concert. Our goal is to make the audience as happy as possible. However, the concert time is limited and therefore each idol can only perform at most one song.
You are given the int[] h and the String[] s with M elements each. Find the set of songs that should be played at the concert. The set of songs must have the following properties:

Each idol will perform at most one song.
After hearing the songs, the happiness of the audience will increase by the largest amount possible.
Return the largest possible amount of happiness the audience can gain.
 
Definition        
Class:  LiveConcert
Method: maxHappiness
Parameters: int[], String[]
Returns:    int
Method signature:   int maxHappiness(int[] h, String[] s)
(be sure your method is public)
    
Notes
-   The value M is not given explicitly. You can determine M as the length of h.
 
Constraints
-   M will be between 1 and 100, inclusive.
-   h and s will contain exactly M elements each.
-   All numbers in h will be between 1 and 100, inclusive.
-   All strings in s will have between 1 and 10 characters, inclusive.
-   For each valid i, each character in s[i] will be a lowercase letter ('a'-'z').
 
Examples
0)  {10,5,6,7,1,2}
{"ciel","bessie","john","bessie","bessie","john"}
Returns: 23
The optimal concert will contain three songs:
"ciel" will sing the song number 0, which will give the audience 10 happiness
"bessie" will sing the song number 3, which will give the audience 7 happiness
"john" will sing the song number 2, which will give the audience 6 happiness
The total amount of happiness will be 10+7+6 = 23.

1)  {3,3,4,3,3}
{"a","a","a","a","a"}
Returns: 4
There is a single idol, thus the concert will consist of a single song. The optimal choice is the song that gives 4 happiness.

2)  {1,2,3,4,5,6,7,8,9,10,100}
{"a","b","c","d","e","e","d","c","b","a","abcde"}
Returns: 140

3)  {100}
{"oyusop"}
Returns: 100

4) {100,100,100,100,100,100,100,100,100,100,100,100,100}
{"haruka","chihaya","yayoi","iori","yukiho","makoto","ami","mami","azusa","miki","hibiki","takane","ritsuko"}
Returns: 1300
*/

import java.util.*;
public class LiveConcert {
    static int maxHappiness(int[] h, String[] s) {
        int audienceMaxHappiness=0;
        //if only 1 happiness is there
        if(h.length==1) {
            audienceMaxHappiness=h[0];
        }

        //for multiple happiness
        //convert happiness to arraylist & then sort it
        ArrayList<Integer> happi = new ArrayList<Integer>();
        for(int i=0; i<h.length; i++) {
            happi.add(h[i]);
        }
        //now sort the happiness collections
        Collections.sort(happi);

        //Now convert singers[] into set, so that no duplicate singers occur
        //1 singer can sing only once, LinkedHashSet to maintain insertion order
        LinkedHashSet<String> singr = new LinkedHashSet<String>(Arrays.asList(s));

        //loop will run till number of distinct singers left
        for(int i=0, j=happi.size()-1; i<singr.size(); i++,j--) {
            audienceMaxHappiness+=happi.get(j);
        }
        return audienceMaxHappiness;
    }
    public static void main(String[] args) {
        int[] happi1 = {10,5,6,7,1,2};
        String[] singr1 = {"ciel","bessie","john","bessie","bessie","john"};
        System.out.println("maxium happiness audience can get is : " + maxHappiness(happi1,singr1));

        int[] happi2 = {3,3,4,3,3};
        String[] singr2 = {"a","a","a","a","a"};
        System.out.println("maxium happiness audience can get is : " + maxHappiness(happi2,singr2));

        int[] happi3 = {1,2,3,4,5,6,7,8,9,10,100};
        String[] singr3 = {"a","b","c","d","e","e","d","c","b","a","abcde"};
        System.out.println("maxium happiness audience can get is : " + maxHappiness(happi3,singr3));

        int[] happi4 = {100,100,100,100,100,100,100,100,100,100,100,100,100};
        String[] singr4 = {"haruka","chihaya","yayoi","iori","yukiho","makoto","ami","mami","azusa","miki","hibiki","takane","ritsuko"};
        System.out.println("maxium happiness audience can get is : " + maxHappiness(happi4,singr4));
    }
}
