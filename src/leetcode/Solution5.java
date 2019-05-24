package leetcode;


import java.util.ArrayList;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        if(next==null){
            return ""+val;
        }else {
            return ""+val+"->"+next.toString();
        }
    }
}

public class Solution5 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        ListNode nowPlace = head;
        while (nowPlace!=null){
            list.add(nowPlace.val);
            nowPlace=nowPlace.next;
        }
        int checkTime = list.size()/k;
        ListNode newHead;
        if (checkTime==0){
            return head;
        }else {
            newHead =new ListNode(list.get(k-1));
            ListNode endPlace=newHead;
            for(int i=1;i<k;i++){
                endPlace.next=new ListNode(list.get(k-1-i));
                endPlace=endPlace.next;
            }
            for (int i=1;i<checkTime;i++){
                for(int j=0;j<k;j++){
                    endPlace.next = new ListNode(list.get((i+1)*k-1-j));
                    endPlace=endPlace.next;
                }
            }
            for (int i=checkTime*k;i<list.size();i++){
                endPlace.next = new ListNode(list.get(i));
                endPlace=endPlace.next;
            }
            return newHead;
        }

    }

}