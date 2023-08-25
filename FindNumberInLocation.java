/*
You are given  lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in  position of  line.

Input Format
The first line has an integer . In each of the next  lines there will be an integer  denoting number of integers on that line and then there will be  space-separated integers. In the next line there will be an integer  denoting number of queries. Each query will consist of two integers x and y.

Output Format
In each line, output the number located in y position of x line. If there is no such position, just print "ERROR!"

Sample Input
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
*/

import java.util.*;
public class FindNumberInLocation {
    public static void main(String[] args) {
        List<ArrayList<Integer>> list= new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        for(int i=0;i<n;i++){
            ArrayList<Integer> arrayList= new ArrayList<>();
            int d=scan.nextInt();
            for(int j=0;j<d;j++){
                arrayList.add(scan.nextInt());
            }
            list.add(arrayList);
        }
        int q=scan.nextInt();  
        System.out.println("============================================");     
        for(int i=0;i<q;i++){
            int x=scan.nextInt();
            int y=scan.nextInt();
            try{
            System.out.println(list.get(x-1).get(y-1));
            }catch(Exception e){
                System.out.println("ERROR!");
            }
        }
        scan.close();
    }
}
