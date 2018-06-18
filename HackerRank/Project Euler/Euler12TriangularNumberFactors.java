/*
Problem statement link - https://www.hackerrank.com/contests/projecteuler/challenges/euler012
*/

import java.util.*;
public class TriangularNumberFactors {
    static int getFirstMaximumDivisors(int K) {
        int numWithMaxDivisors=0;
        int num=0;
        for(int i=1; i<=1000; i++) {
            num=num+i;
            int numDivisors=0;
            for(int k=1; k<=num; k++) {
                if(num%k==0) {
                    numDivisors++;
                }
            }
            if(numDivisors>K) {
                numWithMaxDivisors=num;
                break;
            }
       }//for loop ends...
       return numWithMaxDivisors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of divisors : ");
        int divis = sc.nextInt();

        System.out.println("\nFirst Number with divisors greater than " + divis + " is : " + getFirstMaximumDivisors(divis));
    }
}
