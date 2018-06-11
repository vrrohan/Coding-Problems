/*
Original Problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=13125
Problem Statement
        Alex is sleeping soundly. At any moment, his sleepiness can be characterized by an integer. 
        You are given an int S that represents Alex's initial sleepiness. 

Unfortunately, several alarms are going to disturb him. These alarms will be ringing in a cyclic order. 
Each alarm is characterized by its volume. 
You are given a list of alarm volumes in a int[] volume in the order in which the alarms are going to ring. Every minute the first alarm on the list rings, and Alex's sleepiness instantly decreases by its volume. The alarm is then moved to the end of the alarm list. 
While Alex's sleepiness is positive, he's still sleeping. Once it becomes less than or equal to zero, Alex immediately wakes up.
Return the number of alarms after which Alex will wake up.
 
Definition
Class:  WakingUpEasy
Method: countAlarms
Parameters: int[], int
Returns:    int
Method signature:   int countAlarms(int[] volume, int S)
(be sure your method is public)
     
Constraints
-   volume will contain between 1 and 50 elements, inclusive.
-   Each element of volume will be between 1 and 100, inclusive.
-   S will be between 1 and 10000, inclusive.
 
Examples
0)  {5, 2, 4}
13
Returns: 4
Initially, Alex's sleepiness is 13, and the list of alarms is {5, 2, 4}.
After the first alarm, Alex's sleepiness is 8. The list of alarms becomes {2, 4, 5}.
After the second alarm, Alex's sleepiness is 6. The list of alarms becomes {4, 5, 2}.
After the third alarm, Alex's sleepiness is 2. The list of alarms becomes {5, 2, 4}.
After the fourth alarm, Alex's sleepiness is -3, so Alex wakes up.

1)  {5, 2, 4}
3
Returns: 1
The first alarm is enough here.

2)  {1}
10000
Returns: 10000
The only alarm has to ring 10000 times before Alex finally wakes up.

3)  {42, 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37,
  92, 5, 3, 54, 93, 83, 22, 17, 19, 96, 48, 27, 72, 39, 70, 13, 68, 100, 36,
  95, 4, 12, 23, 34, 74, 65, 42, 12, 54, 69}
9999
Returns: 203
*/

public class WakingUpEasy {
    static int countAlarms(int[] volume, int S) {
        int numOfAlarms = 0;
        int index=0;
        while(S>0) {
            //Takes modulus of index to move in cyclic form.
            //If array length is 3. 0%3=0, 1%3=1, 2%3=2, 3%3=0, 4%3=1. Hence it will move like 0,1,2,0,1,2,0,1,2,0.. & so on.
            S-=volume[index%volume.length];
            index++;
            numOfAlarms++;
        }
        return numOfAlarms;
    }

    public static void main(String[] args) {
        int[] alarmVolume1 = {42, 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37,
            92, 5, 3, 54, 93, 83, 22, 17, 19, 96, 48, 27, 72, 39, 70, 13, 68, 100, 36,
            95, 4, 12, 23, 34, 74, 65, 42, 12, 54, 69};

        int[] alarmVolume2 = {5,2,4};
        int[] alarmVolume3 = {1};
        int[] alarmVolume4 = {5,2,4};
        int[] alarmVolume5 = {5,2,8,1,7,13,15,3};
        System.out.println("number of alarms is : " + countAlarms(alarmVolume1,9999));
        System.out.println("number of alarms is : " + countAlarms(alarmVolume2,13));
        System.out.println("number of alarms is : " + countAlarms(alarmVolume3,10000));
        System.out.println("number of alarms is : " + countAlarms(alarmVolume4,3));
        System.out.println("number of alarms is : " + countAlarms(alarmVolume5,550));
    }
}
