public class Multiples3Or5Sum {
    static int getMultiplesSum(int num) {
        int sum=0;
        int i=2;
        while(i<num) {
            sum=(i%3==0|i%5==0)?sum+i:sum;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("sum of multiples of 3 or 5 below 10 are : " + getMultiplesSum(10));
        System.out.println("sum of multiples of 3 or 5 below 30 are : " + getMultiplesSum(30));
        System.out.println("sum of multiples of 3 or 5 below 100 are : " + getMultiplesSum(100));
        System.out.println("sum of multiples of 3 or 5 below 1000 are : " + getMultiplesSum(1000));
    }
}
