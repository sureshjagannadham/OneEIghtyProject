
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] nums = {

                /*
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
                */
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 1}

        };


        //zeroBrute(nums);
        //zeroBetter(nums);
        zeroOptimal(nums);
        for(int row= 0; row<nums.length; row++)
        {
            for(int col =0; col<nums[row].length; col++)
            {
                System.out.print(nums[row][col]);
            }
            System.out.println();
        }
    }
    // BRUTEFORCE- APPROACH
    /*

    static void zeroBrute(int[][] nums)
    {
        int m = nums.length; // m for rows
        int n = nums[0].length; // n for columns
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(nums[i][j] == 0)
                {
                    markRow(nums, i);
                    markCol(nums, j);
                }
            }
        }

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(nums[i][j] == -1)
                {
                    nums[i][j] =0;
                }
            }
        }
    }


    static void markRow(int[][] nums, int i)
    {
        for(int j=0; j<nums[i].length; j++)
        {
            if(nums[i][j] != 0)
            {
                nums[i][j] = -1;
            }
        }
    }
    static void markCol(int[][] nums, int j)
    {
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i][j] != 0)
            {
                nums[i][j] =-1;
            }
        }
    }

*/

    // BETTER- APPROACH
    /*
    static void zeroBetter(int[][] nums)
    {
        int m =  nums.length;
        int n = nums[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for(int i= 0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(nums[i][j] == 0)
                {
                    row[i] = 1;
                    col[j] =1;
                }
            }
        }

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(row[i] == 1 || col[j] == 1)
                {
                    nums[i][j] =0;
                }
            }
        }
    }
*/
    static void zeroOptimal(int[][] nums)
    {
        if(nums == null || nums.length ==0 || nums[0] == null|| nums[0].length==0)
        {
            return;
        }
        int m = nums.length;
        int n = nums[0].length;
        int col0 =1;
        // this loop is for marking first row and first column as zero
        for(int i =0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(nums[i][j] == 0)
                {
                    // mark for rows
                    nums[i][0] = 0;
                    // mark for col
                    if(j != 0)
                    {
                        nums[0][j] = 0;
                    }
                    else {
                        col0 = 0;
                    }
                }
            }
        }

        // this loop is for exclusing first row and first column
        // and working on the remaining part set to be zero if row aor column == 0
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                //
                if(nums[i][j] != 0)
                {
                    if(nums[0][j] == 0 || nums[i][0] == 0)
                    {
                        nums[i][j] =0;
                    }
                }
            }
        }
        // mark first row as zero
         if(nums[0][0] == 0)
         {
             for(int j =0; j<n; j++)
             {
                 nums[0][j] = 0;
             }
         }
        // mark first column as zero
         if(col0 == 0)
         {
             for(int i =0; i<m; i++)
             {
                 nums[i][0] = 0;
             }
         }

    }

}

// OUTPUT
/*
        0001
        0000
        0000
        0000
        */
