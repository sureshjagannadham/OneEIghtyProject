import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OnlineStockSpan901M
{
    public static void main(String[] args)
    {
        StockSpanner sp = new StockSpanner();
        System.out.println(sp.next(7));
        System.out.println(sp.next(2));
        System.out.println(sp.next(1));
        System.out.println(sp.next(3));
        System.out.println(sp.next(3));
        System.out.println(sp.next(1));
        System.out.println(sp.next(8));
    }

    /*static class StockSpanner
    {
        ArrayList<Integer> arr;
        public StockSpanner()
        {
            arr = new ArrayList<>();
        }

        public int next(int price)
        {
            arr.add(price);
            int count = 1;

            for(int i=arr.size() -2; i>=0; i--)
            {
                if(arr.get(i) <= price)
                    count++;
                else
                    break;
            }
            return count;
        }
    }
    */


    static class StockSpanner
    {
        // Stack to store pairs of (price, index)
        Stack<AbstractMap.SimpleEntry<Integer, Integer>> st; // Using SimpleEntry as a pair
        int index = -1; // To track the current price index

        // Constructor to initialize the stock spanner
        public StockSpanner() {
            index = -1; // Start from -1 to represent no prices processed
            st = new Stack<>(); // Initialize the stack
        }

        // Method to calculate the stock span for the given price
        public int next(int price) {
            index++; // Increment the index for the new price
            // While there are elements in the stack and the top price is less than or equal to the current price
            while (!st.isEmpty() && st.peek().getKey() <= price) {
                st.pop(); // Pop elements from the stack
            }

            int ans; // Variable to hold the span result

            // If the stack is empty, this means the current price is the highest so far
            if (st.isEmpty()) {
                ans = index + 1; // The span is the number of prices seen so far
            } else {
                // The span is the difference between the current index and the index of the last higher price
                ans = index - st.peek().getValue();
            }

            // Push the current price and its index onto the stack as a pair
            st.push(new AbstractMap.SimpleEntry<>(price, index)); // Push using SimpleEntry
            return ans; // Return the calculated span
        }
    }
}
