package basic_recursion_i5;

public class SumFirstNNumbers
{
    public static void main(String[] args)
    {
        int n = 5;
        System.out.println(sumFirstNNumbers(n));
    }
    static int sumFirstNNumbers(int n)
    {
        if(n == 0)
            return 0;
        return n+sumFirstNNumbers(n-1);
    }

}
