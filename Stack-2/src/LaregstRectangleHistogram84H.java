import java.util.Stack;

public class LaregstRectangleHistogram84H
{
    public static void main(String[] args)
    {
        int[] arr = {3, 1, 5, 6, 2, 3};
        System.out.println(largestRectangle(arr));
    }

    static int largestRectangle(int[] heights)
    {
        Stack<Integer> st = new Stack<>(); // Stack to store indices of the histogram's bars
        int maxi = 0; // Variable to keep track of the maximum area

        // Iterate through each bar in the histogram
        for (int i = 0; i < heights.length; i++) {
            // Current height being processed
            int ele = heights[i];
            // While the stack is not empty and the current height is less than the height at stack's top index
            while (!st.isEmpty() && heights[st.peek()] > ele) {
                int height = heights[st.peek()]; // Height of the rectangle
                st.pop(); // Remove the top index from the stack

                // Calculate the width
                int width;
                if (st.isEmpty()) {
                    width = i; // If stack is empty, the width is the current index
                } else {
                    width = i - st.peek() - 1; // Width is distance to the next smaller height
                }

                // Calculate the area and update the maximum area encountered
                maxi = Math.max(maxi, width * height);
            }
            // Push the current index onto the stack
            st.push(i);
        }

        // Process remaining indices in the stack
        while (!st.isEmpty()) {
            int height = heights[st.peek()]; // Height of the rectangle
            st.pop(); // Remove the top index from the stack
            int width;
            if (st.isEmpty()) {
                width = heights.length; // If stack is empty, width is the entire length
            } else {
                width = heights.length - st.peek() - 1; // Width to the next smaller height
            }
            maxi = Math.max(maxi, width * height); // Update the maximum area
        }

        return maxi; // Return the maximum area found
    }
}
