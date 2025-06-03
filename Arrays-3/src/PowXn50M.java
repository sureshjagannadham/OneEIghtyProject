public class PowXn50M {
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        //System.out.println(powBrute(x,n));
        System.out.println(powOptimal(x,n));

    }
   /* static double powBrute(double x, int n)
    {
        double ans = 1.0;
        for(int i=0; i<n; i++)
        {
            ans = ans * x;
        }
        return ans;
    }*/

    static double powOptimal(double x, int n)
    {
        double ans = 1.0;
        long nn = n;
        if(nn < 0)
        {
            nn = -1 * nn;
        }
        while( nn >0 )
        {
            if( n % 2 == 1)
            {
                ans = ans * x;
                nn = nn-1;
            }
            else{
                x = x * x;
                nn = nn/2;
            }
        }
        if( n<0)
            ans = (double)(1.0)/(double) ans;
        return ans;
    }
}
