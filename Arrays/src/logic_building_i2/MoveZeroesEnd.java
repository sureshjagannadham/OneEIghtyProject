package logic_building_i2;

import java.util.Arrays;

public class MoveZeroesEnd {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = -1;

        // Step 1: Find the index of the first zero
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // If there's no zero, no need to do anything
        if (j == -1)
            return;

        // Step 2: Swap non-zero elements with the position at j
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        System.out.println("Original: " + Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println("After moving zeroes: " + Arrays.toString(arr));
    }
}

