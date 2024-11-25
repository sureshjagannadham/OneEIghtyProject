import java.util.ArrayList;
import java.util.List;

public class PascalTriangle118{
    public static void main(String[] args) {
        int numRows = 6;
        List<List<Integer>> pascalTriangle= generate(numRows);
        System.out.println("Printing pascal triangle for" + " " + numRows+ "rows");
        for(List<Integer> num: pascalTriangle)
        {
            System.out.println(num);
        }

    }
    static List<List<Integer>> generate(int n)
    {
        List<List<Integer>> pascal = new ArrayList<>();
        for(int i =0; i<n; i++)
        {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++)//j = i+1 also write
            {
                if(j==0 || j==i)
                {
                    row.add(1);
                }
                else
                {
                    List<Integer> previousRow = pascal.get(i-1);
                    row.add(previousRow.get(j) + previousRow.get(j-1));
                }
            }
            pascal.add(row);
        }
        return pascal;
    }
}