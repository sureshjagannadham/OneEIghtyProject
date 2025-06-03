import java.util.Arrays;
public class MergeTwoSortedArrays88E {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        //mergeBrute(nums1, nums2, m, n);
        mergeOptimal(nums1, nums2, m,n);
        for(int i=0; i<m+n; i++)
        {
            System.out.print(nums1[i] + " ");
        }

    }
    /*static void mergeBrute(int[] nums1, int[] nums2, int m, int n )
    {
        int[] nums3 = new int[m+n];
        int left =0;
        int right =0;
        int index =0;
        while(left< m && right<n)
        {
            if(nums1[left] <= nums2[right])
            {
                nums3[index++] = nums1[left++];
            }
            else
            {
                nums3[index++] = nums2[right++];
            }
        }
        while(left < m)
        {
            nums3[index++] = nums1[left++];
        }
        while(right < n)
        {
            nums3[index++] = nums2[right++];
        }
        for(int i=0; i<nums3.length; i++)
        {
            nums1[i] = nums3[i];
        }
        System.out.println(Arrays.toString(nums1));
    }*/

    static void mergeOptimal(int[] nums1, int[] nums2, int m, int n )
    {
        int left = m-1;
        int right = n-1;
        int kight = m+n-1;
        while(right >= 0)
        {
            if(left >=0 && nums1[left] > nums2[right])
            {
                nums1[kight] = nums1[left];
                kight--;
                left--;
            }
            else {
                nums1[kight] = nums2[right];
                kight--;
                right--;
            }
        }
    }
}
