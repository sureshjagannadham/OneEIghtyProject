package answers_i2;

public class KokoEatingBananasFour
{
    public static void main(String[] args)
    {
        int[] arr = {30,11,23,4,20};//{3,6,7,11};
        int hours = 5; //8;
        System.out.println(koko(arr,hours));

    }
    static int koko(int[] piles, int h)
    {
        int n = piles.length;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            maxi = Math.max(piles[i], maxi);
        }
        int low = 1;
        int high = maxi;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(sumOfAll(piles, mid) <= h)
            {
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return low;
    }

    private static int sumOfAll(int[] piles, int mid)
    {
        int n = piles.length;
        int sum = 0;
        for(int i=0; i<n; i++)
        {
            sum += Math.ceil((double)(piles[i])/ (double)(mid));
        }
        return sum;

    }
}
