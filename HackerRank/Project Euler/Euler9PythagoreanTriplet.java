/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler009
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which -
a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/

import java.util.*;
public class PythagoreanTriplet {
    static int maxPythagoreanTripletProduct(int numb) {
        int maxProduct=-1;
        for(int i=1; i<=3000; i++) {
            if(((i+1)+(i+2)+(i+3))==numb) {
                maxProduct=(i+1)*(i+2)*(i+3);
                break;
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to find its Pythagorean Triplet : ");
        int numb = sc.nextInt();
        System.out.println("Max product of Pythagorean Triplet of number " + numb + " is : " + maxPythagoreanTripletProduct(numb));
    }
}
