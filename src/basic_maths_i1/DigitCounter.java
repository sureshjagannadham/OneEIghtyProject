package basic_maths_i1;

public class DigitCounter
{
    public static void main(String[] args)
    {
        int n = 1234567;
        //System.out.println(digitCount(n));
        //System.out.println(OddDigitCounter(n));
        //System.out.println(revereNumber(n));
        //System.out.println(palindromNumber(n));
        /*int div = 12;
        divisorsOfNumber(div);*/
        /*int fac = 5;
        System.out.println(factorial(fac));*/
        /*int arms = 153;
        System.out.println(armstrong(arms));*/

        /*int divi = 16;
        System.out.println(perfect(divi));*/
       /* int prim = 34;
        System.out.println(prime(prim));*/
        /*int pr = 10;
        System.out.println(count(pr));*/

        int x = 48;
        int y = 18;
        System.out.println(gcd(x, y));
        //int x = 12;
        //int y = 18;
        //System.out.println(lcm(x,y));



    }
    // 1. Count all Digits of a Number
    /*static int digitCount(int n)
    {
        n = Math.abs(n);
        if(n == 0)
            return 1;
        int count = 0;
        while(n > 0)
        {
            n = n/10;
            count++;
        }
        return count ;
    }*/

    // 2. Count number of odd digits in a number
    /*static int OddDigitCounter(int n)
    {
        n = Math.abs(n);
        if (n == 0) {
            return 0; // zero has no odd digits
        }
        int count = 0;
        while(n > 0)
        {
            int number = n%10;
            if(number % 2 != 0)
            {
                count++;
            }
            n = n/10;
        }
        return count;
    }
    */
    // Reverse a number
    /*static int revereNumber(int n)
    {
        int rev = 0;
        n = Math.abs(n);
        while(n > 0)
        {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n/10;
        }
        return rev;
    }*/

    // Palindrome Number
    /*
    static boolean palindromNumber(int n)
    {
        int rev = 0;
        int orig = n;
        while(n > 0)
        {
            int rem = n%10;
            rev = rev *10 + rem;
            n = n/10;
        }
        return rev == orig;
    }*/
    //divisorsOfNumber
    /*static void divisorsOfNumber(int n)
    {
        if (n > 0) {
            System.out.println(1);
        }
        for(int i = 2; i< n; i++)
        {

            if(n % i == 0)
            {
                System.out.println(i);
            }
        }
    }*/

    /*//Factorial of a given number
    static int factorial(int n)
    {
        if(n==0 || n==1)
            return 1;
        int fact = 1;
        for(int i=n; i>=1; i--)
        {
            fact = fact * i;
        }
        return fact;
    }*/
    // Check if the Number is Armstrong
   /* static boolean armstrong(int n)
    {
        int orig = n;
        int sum = 0;
        while(n > 0)
        {
            int rem = n %10;
            sum = sum + rem * rem * rem;
            n = n/10;
        }
        return sum == orig;
    }*/

    //Check for Perfect Number
   /* static boolean perfect(int n)
    {
        if (n <= 1) {
            return false; // No perfect numbers less than or equal to 1
        }
        int sum = 1; // 1 is always a divisor (for n > 1)
        int limit = n / 2; // No need to check beyond n/2

        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }*/

    // Check for Prime Number
    /*static boolean prime(int n)
    {
        if(n <= 1)
            return false;
        for(int i=2; i<n; i++)
        {
            if(n % i == 0)
            {
                return false;
            }
        }
        return true;
    }*/

    // Count of Prime Numbers till N
    /*static boolean isPrime(int n)
    {
        if(n <= 1)
            return false;
        for(int i =2; i*i <= n; i++)
        {
            if(n % i == 0)
                return false;
        }
        return true;
    }
    static int count(int n)
    {
        int count =0;
        for(int i=2; i<= n; i++)
        {
            if(isPrime(i))
            {
                count++;
            }
        }
        return count;
    }
*/
    // gcd(a,b)=gcd(b,amodb)
    // gcd of two numbers
    static int gcd(int a, int b)
    {
        while(b != 0)
        {
            int temp =b;
            b = a % b;
            a = temp;
        }
        return a;
    }

//    // LCM of two numbers
//    static int findLcm(int a, int b)
//    {
//        while(b != 0)
//        {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        return a;
//    }
//    static int lcm(int a, int b)
//    {
//        int gcd = findLcm(a, b);
//        int res = Math.abs(a * b)/gcd;
//        return res;
//    }

}
