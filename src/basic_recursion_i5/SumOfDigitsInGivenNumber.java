package basic_recursion_i5;

public class SumOfDigitsInGivenNumber
{
    public static void main(String[] args)
    {
        int n = 12345;
        System.out.println(sumOfNumbers(n));
    }
    static int sumOfNumbers(int n)
    {
        if(n == 0)
            return 0;
        return n%10 + sumOfNumbers(n/10);
    }
}

//"Natural Language to Java: Building a Chat-Based Code Generator"
