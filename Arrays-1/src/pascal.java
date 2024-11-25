import java.util.ArrayList;
import java.util.List;

public class pascal {
    public static void main(String[] args) {
        int rows = 5;
        List<List<Integer>> pascal = generate(rows);
        System.out.println("printing pascal" + rows + " ");
        /*for(List<Integer> all: pascal)
        {
            System.out.print(all);
        }*/
        System.out.println(pascal);

    }
    static List<List<Integer>> generate(int rows)
    {
        List<List<Integer>> allLists = new ArrayList<>();

        for(int i =0; i<rows; i++)
        {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i ; j++)
            {
                if(j==0 || j==i)
                {
                    row.add(1);
                }

                else
                {
                    List<Integer> previousRow = allLists.get(i-1);
                    row.add(previousRow.get(j) + previousRow.get(j-1));
                }
            }
            allLists.add(row);
        }
        return allLists;
    }
}


