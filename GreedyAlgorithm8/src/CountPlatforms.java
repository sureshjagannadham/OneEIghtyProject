import java.util.Arrays;

public class CountPlatforms {
   /* static int countPlatforms(int n,int arr[],int dep[])
    {
        int ans=1; //final value
        for(int i=0;i<=n-1;i++)
        {
            int count=1; // count of overlapping interval of only this   iteration
            for(int j=i+1;j<=n-1;j++)
            {
                if((arr[i]>=arr[j] && arr[i]<=dep[j]) ||
                        (arr[j]>=arr[i] && arr[j]<=dep[i]))
                {
                    count++;
                }
            }
            ans=Math.max(ans,count); //updating the value
        }
        return ans;
    }*/

    static int countPlatformsOptimal(int n,int arr[],int dep[])
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0;
        int j=0;
        int count =0;
        int platform =0;
        while(i <n)
        {
            if(arr[i] <= dep[j])
            {
                count++;
                i++;
            }
            else {
                count--;
                j++;
            }
            platform = Math.max(platform, count);
        }
        return platform;

    }

    public static void main (String[] args) {

        int[] arr ={900,945,955,1100,1500,1800};
        int[] dep={920,1200,1130,1150,1900,2000};
        int n=arr.length;
        //int totalCount=countPlatforms(n,arr,dep);
        int totalCount= countPlatformsOptimal(n,arr,dep);
        System.out.println("Minimum number of Platforms required "+totalCount);
    }

}
