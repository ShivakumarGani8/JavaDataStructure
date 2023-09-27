import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {  
    int val;  
    ListNode next;  
  
    public ListNode(){
        
    }
    public ListNode(int val) {  
        this.val = val;  
    }  
}  

public class MergeKSortedLists {
    public static void main(String[] args) {
        int[][] lists= {{1,4,5},{1,3,4},{2,6}};
        ListNode[] listNodes=new ListNode[lists.length];
        for(int i=0;i<lists.length;i++){
            ListNode listNode= new ListNode(lists[i][0]);
            ListNode temp=listNode;
            for(int j=1;j<lists[i].length;j++){
                temp.next=new ListNode(lists[i][j]);
                temp= temp.next;
            }
            listNodes[i]= listNode;
        }
        ListNode result= new MergeKSortedLists().mergeKLists(listNodes); // 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 
        while(result !=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        
        //Adding lists to list
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<lists.length;i++){
            ListNode current=lists[i];
            while(current!=null){
                list.add(current.val);
                current=current.next;
            }
        }

        //Sort all the nodes
        Collections.sort(list);
        if(list.size()==0) //If no elements in the list ListNode will be null.
        return null;

        //Main node
        ListNode node=new ListNode(list.get(0));
        ListNode temp=node; //temp node to traverse through ListNode.

        for(int i=1;i<list.size();i++){
            temp.next=new ListNode(list.get(i)); //Add next node to temp node.
            temp=temp.next; //Assign ref of lastly added node to the temp node.
        }
        return node; //Return main node
    }
}
