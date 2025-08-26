package logic_building_i2;

public class RemoveDuplicatesFromSortedArray
{
    public static void main(String[] args)
    {
        int[] arr = { 0,0,1,1,2,2,2,4,5,5,6,6};
        int newLength = removeDuplicatesFromSortedArray(arr);
        System.out.println(newLength);
        // Print the modified array up to newLength
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static int removeDuplicatesFromSortedArray(int[] nums)
    {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++)
        {
            if(i< n-1 && nums[i] == nums[i+1])
                continue;
            nums[count] = nums[i];
            count++;
        }
        return count;
    }

}
