public class SortPhoneNumber
{
    public static void main(String[] args)
    {
        int[] arr = {6,3,0,1,2,1,7,7,3,6};
        System.out.println("sort this phone number");
        int[] ans = sorting(arr);
        for(int it: ans)
            System.out.print(it);


    }
    public static int[] sorting(int[] arr)
    {
        int n = arr.length;
        for(int i=0; i<n-1; i++)
        {
            for(int j=0; j<n-1-i; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
