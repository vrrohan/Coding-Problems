/*
The sum of the primes below 10 is 2+3+5+7=17 .
Find the sum of all the primes not greater than given N.

Input Format
The first line contains an integer T i.e. number of the test cases. 
The next T lines will contains an integer N.

Constraints - 
    1<=T<=10000
    1<=N<=1000000

Output Format
Print the value corresponding to each test case in separate line.
Sample Input 0
2
5
10

Sample Output 0
10
17

Explanation - 
a) N=5, 2+3+5=10
b) N=10, 2+3+5+7=17
*/

import java.util.*;
public class SummationPrimes {
    static int primeSummation(int num) {
        int sum=0;
        for(int i=2; i<=num; i++) {
            boolean b=true;
            for(int j=2; j<=i/2; j++) {
                if(i%j==0) {
                    b=false;
                    break;
                }
            }
            if(b) {
                sum+=i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        System.out.println("sum of all primes till " + num + " is : " + primeSummation(num));
    }
}
