package faq_i3;

public class BooksAllocationThree
{
    public static void main(String[] args)
    {
        int[]  arr = {15, 17, 20};//{12, 34, 67, 90}; //{25,46,28,49,24};
        int k = 5; // 2; //4;
        System.out.println(boook(arr,k));
    }
    static int boook(int[] arr, int k)
    {
        int n = arr.length;
        if(k > n)
            return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0; i<n; i++)
        {
            high += arr[i];
            low = Math.max(low, arr[i]);
        }
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            int students = countStudent(arr, mid);
            if(students > k)
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }

    private static int countStudent(int[] arr, int mid)
    {
        int student = 1;
        int pgs = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(pgs+arr[i] <= mid)
                pgs += arr[i];
            else
            {
                student++;
                pgs = arr[i];
            }
        }
        return student;
    }

}
