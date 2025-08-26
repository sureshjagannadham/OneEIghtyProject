package answers_i2;

public class SquareRootOfNumberOne
{
    public static void main(String[] args)
    {
        int n = 58;
        System.out.println(sqrt(n));
    }
    // brute force approach -> but not work for all the test cases
    /*static int sqrt(int x)
    {
        int ans =1;
        for(int i=1; i<=x; i++)
        {
            if(i*i <= x)
                ans = i;
            else
            {
                break;
            }

        }
        return ans;
    }*/

    static int sqrt(int x)
    {
        if(x<2)
            return x;
        int low = 1;
        int high = x;
        while(low <= high)
        {
            int mid = low+ (high-low)/2;
            long val = (long)mid*mid;
            if(val <= x)
                low = mid+1;
            else
                high = mid-1;
        }
        return high;
        // why i ma returning "high" bcz
        // intitially low is at possible stage and high is at impossible stage
        // while moving, low traverse to the impossible stage and high trvarse to to the possible stage
        // that's why returning high
    }


}
