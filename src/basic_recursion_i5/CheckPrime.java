package basic_recursion_i5;

public class CheckPrime
{
    public static void main(String[] args)
    {
        int n = 17;
        System.out.println(isPrime(n, n-1));
    }
    static boolean isPrime(int n, int i)
    {
        if(n<=1)
            return false;
        if(i == 1)
            return true;
        if(n %i == 0)
            return false;
        return isPrime(n,i-1);
    }
}
