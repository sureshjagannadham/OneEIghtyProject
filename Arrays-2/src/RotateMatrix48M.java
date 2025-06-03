import java.util.Arrays;

public class RotateMatrix48M {
    public static void main(String[] args) {
    int[][] nums = {
            {1,2,3,},
            {4,5,6},
            {7,8,9}
        };
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // To Print the output in this way
        /*
        741
        852
        963
        */

    //int[][] rotated = rotateBrute(nums);

    /*int[][] rotated = rotateOptimal(nums);

    for(int i =0; i<rotated.length; i++)
    {
        for(int j=0; j<rotated[i].length; j++)
        {
            System.out.print(rotated[i][j] + " ");
        }
        System.out.println();
    }*/


        // To print the output in this way
        // [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
        //System.out.println(Arrays.deepToString(rotateBrute(nums)));
        System.out.println(Arrays.deepToString(rotateOptimal(nums)));
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    }

   /* static int[][] rotateBrute(int[][] nums)
    {
        int n = nums.length;
        int[][] rotated = new int[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                rotated[j][n-1-i]= nums[i][j];
            }
        }
        return rotated;
    }*/

    static int[][] rotateOptimal(int[][] nums)
    {
        int n = nums.length;
        for(int i=0; i<n-1; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }
        for(int i=0; i<n; i++)
        {
            int left = 0;
            int right = n-1;
            while(left<right)
            {
                int temp = nums[i][left];
                nums[i][left] = nums[i][right];
                nums[i][right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }


}
