import java.util.ArrayList;
import java.util.List;

public class Recursion
{

    public static void main(String[] args)
    {
        /*int n = 4;
        print(n);*/

        /*int n = 5;
        //print(n, 0);
        System.out.println(print(n));*/

        /*int[] arr = {1,2,3,4,5};
        reverse(arr,0);
        for(int i:arr)
        {
            System.out.print(i + " ");
        }*/

        /*String s = "MADAM";
        System.out.println(palin(s, 0));*/

        /*int n=4;
        System.out.println(fibo(n));*/

        int[]  arr = {1,2,1};
        //int n = arr.length;
        int sum = 2;
        int s = 0;
        int index = 0;
        //printSubseq(arr,index,n,sum,s,new ArrayList<>());
        System.out.println(countSubseq(arr, index, s, sum));

    }

    // print numbers from 1 to n
    /*static void print(int i, int n)
    {
        if(i > n)
            return;
        System.out.print(i + " ");
        print(i+1, n);
    }*/
    // print numbers from n to 1
   /* static void print(int n)
    {
        if(n== 0)
            return;
        System.out.print(n + " ");
        print(n-1);
    }*/

    // now print linearly from 1 to n by backtracking
   /* static void print(int n)
    {
        if(n==0)
            return;
        print(n-1);
        System.out.print(n + " ");
    }*/

    // now print linearly from n to 1 by backtracking
    /*static void print(int i, int n)
    {
        if(i > n)
            return;
        print(i+1, n);
        System.out.print(i + " ");
    }*/

    // printing the sum of first n numbers
    /*static void print(int i, int sum)
    {
        if(i < 1)
        {
            System.out.println(sum);
            return;
        }
        print(i-1, sum+i);
    }*/

    /*static int print(int n)
    {
        if(n == 0)
            return 0;
        return n + print(n-1);
    }*/

    // reverse the array
    /*static void reverse(int[] arr, int i)
    {
        int n= arr.length;
        if(i >= n/2)
            return ;
        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;
        reverse(arr,i+1);
    }*/

    // check palindrome or not by recursion
    /*static boolean palin(String s, int i)
    {

        int n = s.length();
        if(i >= n/2)
            return true;
        if(s.charAt(i) != s.charAt(n-i-1))
            return false;
        return palin(s,i+1);
    }*/

    /*static int fibo(int n)
    {
        if(n<=1)
            return n;
        return fibo(n-1)+fibo(n-2);
    }*/

    // printing subsequences whose sum is K
   /* static void printSubseq(int[] arr, int i, int n, int sum, int s, List<Integer> ans)
    {
        if(i==n)
        {
            if(s == sum)
            {
                System.out.println(ans);
            }
            return;
        }

        ans.add(arr[i]);
        s = s+arr[i];
        printSubseq(arr, i+1,n, sum, s, ans);
        s = s-arr[i];
        ans.remove(ans.size()-1);
        printSubseq(arr,i+1,n,sum,s,ans);
    }*/

    // count all the subsequeneces whose sume is equal k =2;

    static int countSubseq(int[] arr, int index, int s, int sum)
    {
        int n = arr.length;
        if(index == n)
        {
            if(s == sum)
            {
                return 1;
            }
            else
                return 0;
        }
        s =s+arr[index];
        int l = countSubseq(arr, index+1, s, sum);
        s = s-arr[index];
        int r = countSubseq(arr, index+1, s, sum);
        return l+r;
    }


}
