package answers_i2;

public class NthRootOfIntegerTwo
{
    public static void main(String[] args)
    {
        /*int n = 4;
        int m = 69;*/
        int n = 3;
        int m =27;
        System.out.println(nthroot(n,m));
    }

    static int nthroot(int n, int m)
    {
        int low = 1;
        int high = m;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            double power = Math.pow(mid, n);
            if(power == m)
                return mid;
            else if(power > m)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}
