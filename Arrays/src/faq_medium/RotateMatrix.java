package faq_medium;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        //rotate(matrix);
        optimal(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    /*static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                temp[j][n - i - 1] = matrix[i][j];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = temp[i][j];
    }*/

    static void optimal(int[][] matrix)
    {
        int n = matrix.length;
        for(int i=0; i<n-1;i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<n; i++)
        {
            int left =0, right = n-1;
            while(left <= right)
            {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
