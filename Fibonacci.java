import java.util.Scanner;
class Fibonacci {
    static int fib(int n)
    {
        if (n==0)
            return 0;
        else if(n==1 || n==2)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }
 
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number n to know the n th fibonacci number:");
        int n = scanner.nextInt();
        System.out.println(fib(n));
        scanner.close();
    }
}