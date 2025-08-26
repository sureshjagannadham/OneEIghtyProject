package faq_medium;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> triangle = generate(numRows);

        // Display the triangle row by row
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1); // First and last element are always 1
                } else {
                    List<Integer> prev = ans.get(i - 1);
                    int val = prev.get(j - 1) + prev.get(j); // Sum from previous row
                    row.add(val);
                }
            }

            ans.add(row);
        }

        return ans;
    }
}
