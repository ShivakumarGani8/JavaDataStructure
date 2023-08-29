/*
Insert y at index x:
Insert
x y
Delete the element at index x:
Delete
x

Input Format:
The first line contains an integer, N (the initial number of elements in L).
The second line contains N space-separated integers describing .
The third line contains an integer, Q(the number of queries).
The 2Q subsequent lines describe the queries, and each query is described over two lines:

If the first line of a query contains the String Insert, then the second line contains two space separated integers x y, and the value y must be inserted into L at index x.
If the first line of a query contains the String Delete, then the second line contains index x, whose element must be deleted from L.

Sample Input

5
12 0 1 78 12
2
Insert
5 23
Delete
0
Sample Output

0 1 78 12 23

*/
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class InterchageListElements {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        int N=scan.nextInt();
        for(int i=0;i<N;i++)
            list.add(scan.nextInt());
        int Q=scan.nextInt();
        for(int i=0;i<Q;i++){
            String query=scan.next();
            if(query.equals("Insert")){
                int index=scan.nextInt();
                int element=scan.nextInt();
                list.add(index,element);
            }else if(query.equals("Delete")){
                list.remove(scan.nextInt());
            }
        }
        for(Integer i : list)
            System.out.print(i+" ");
        scan.close();     
    }
}
