/*
The sum of the squares of the first ten natural numbers is ==> 12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is ==> (1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

Sample Input 0
a) 3
22, (1+2+3)*(1+2+3)-(1*1+2*2+3*3) = 36-14 = 22

b) 10
2640
*/

public class SumSquareDiff {
    static int getDifference(int num) {
        int totalSum = 0;
        int totalSquare = 0;
        for(int i=1; i<=num; i++) {
            totalSum+=i;
            totalSquare+=(i*i);
        }
        return (totalSum*totalSum)-totalSquare;
    }

    public static void main(String[] args) {
        System.out.println("sum square difference b/w 1 to 10 is : " + getDifference(10));
        System.out.println("sum square difference b/w 1 to 3 is : " + getDifference(3));
        System.out.println("sum square difference b/w 1 to 15 is : " + getDifference(15));
        System.out.println("sum square difference is 1 to 8: " + getDifference(8));
    }
}
