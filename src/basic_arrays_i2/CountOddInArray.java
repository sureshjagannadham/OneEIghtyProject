//Time Complexity: O(n) – Each element is checked once

//Space Complexity: O(1) – Only one counter variable is used
package basic_arrays_i2;

public class CountOddInArray
{
    public static void main(String[] args)
    {
        int[] arr = {4,7,1,3,9,11};
        System.out.println(countOddNumbers((arr)));
    }
    static int countOddNumbers(int[] arr)
    {
        int count = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] % 2 != 0)
            {
                count++;
            }
        }
        return count;
    }

}
