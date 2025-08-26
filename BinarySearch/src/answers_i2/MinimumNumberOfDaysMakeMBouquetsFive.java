package answers_i2;

public class MinimumNumberOfDaysMakeMBouquetsFive
{
    public static void main(String[] args)
    {
        int[] arr ={7,7,7,7,12,7,7};//{1,10,3,10,2}; //{1,10,3,10,2};
        int m = 2;//3;//3;
        int k =3;//2;//1;
        System.out.println(minimumNumberOfDaysMakeMBouquets(arr,m,k));

    }
    static int minimumNumberOfDaysMakeMBouquets(int[] bloomDay, int m, int k)
    {
        int n = bloomDay.length;
        if(n < m*k)
            return -1;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            mini = Math.min(bloomDay[i], mini);
            maxi = Math.max(bloomDay[i], maxi);
        }
        int low = mini;
        int high = maxi;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(isPossible(bloomDay,mid,m,k))
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }

    private static boolean isPossible(int[] bloomDay, int mid, int m, int k)
    {
        int count = 0;
        int noB = 0;
        for(int i=0; i<bloomDay.length; i++)
        {
            if(bloomDay[i] <= mid)
            {
                count++;
            }
            else
            {
                noB += (count/k);
                count = 0;
            }
        }
        noB += count/k;
        return noB >= m;
    }

}
