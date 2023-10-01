class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// https://leetcode.com/problems/add-two-numbers/
public class AddTwoListNodes {

    public static void main(String[] args) {
        ListNode l1= new ListNode(2);
        ListNode templ1=l1;
        templ1.next= new ListNode(4);
        templ1=templ1.next;
        templ1.next= new ListNode(3);
        templ1=templ1.next;

        ListNode l2= new ListNode(5);
        ListNode templ2=l2;
        templ2.next= new ListNode(6);
        templ2=templ2.next;
        templ2.next= new ListNode(4);
        templ2=templ2.next;
        
        ListNode result= addTwoNumbers(l1, l2); // 708: (2->4->3)342+(5->6->4)465=(7->0->8)807
        while(result !=null){
            System.out.print(result.val);
            result=result.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val= l1.val+l2.val;
        //Main node which starts with remainder.
        ListNode resultNode=new ListNode(val%10);
        //temp node for resultNode to traverse.
        ListNode temp=resultNode;
        l1=l1.next;
        l2=l2.next;
        //If summation of values at both the nodes is > 9 we have to include 1 as a carry to next node.
        int digit=(val>9)? 1 : 0;
        

        //Summation until any of the nodes reaches null.
        while(l1 !=null && l2!=null){
            val = l1.val+l2.val+digit;
            temp.next= new ListNode(val%10); //Add remainder of summation as a next node
            digit=(val>9)? 1 : 0; //If summation>9 carry 1 to next node.
            temp=temp.next; //Change temp to latest node.
            l1=l1.next;
            l2=l2.next;
        }

        //If l1 not reached end
        while(l1 != null){
            val=l1.val+digit;
            temp.next= new ListNode(val%10);
            digit=(val>9)? 1 : 0;
            temp=temp.next;
            l1=l1.next;
        }
        //If l2 not reached end
        while(l2 != null){
            val=l2.val+digit;
            temp.next= new ListNode(val%10);
            digit=(val>9)? 1 : 0;
            temp=temp.next;
            l2=l2.next;   
        }

        //If there is a carry.
        if(digit==1){
            temp.next= new ListNode(digit);
        }
        
        return resultNode;
    }

}
