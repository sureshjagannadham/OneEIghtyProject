package faq_medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix
{
    public static void main(String[] args)
    {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(spiralOrder(matrix));
    }
    // right->bot->left->top

    static List<Integer>  spiralOrder(int[][] matrix)
    {
        int m  = matrix.length;
        int n = matrix[0].length;
        int left =0, right = m-1;
        int top = 0, bot = n-1;
        List<Integer> ans = new ArrayList<>();
        while(top <= bot && left <= right)
        {
            for(int i=left; i<=right; i++)
            {
                ans.add(matrix[top][i]);
            }
            top++;

            for(int i=top; i<=bot; i++)
            {
                ans.add(matrix[i][right]);
            }
            right--;

            if(top<= bot)
            {
                for(int i=right; i>=left; i--)
                {
                    ans.add(matrix[bot][i]);
                }
                bot--;
            }

            if(left <= right)
            {
                for(int i=bot; i>=top; i--)
                {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
