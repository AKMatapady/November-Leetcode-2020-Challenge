/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        if(head == null)
            return head;
        
        ListNode dummy = new ListNode();
        ListNode curr = head;
        dummy.next = head;
        //System.out.println(curr.val);
        while(curr.next != null)
        {
            //System.out.println(curr.val);
            ListNode temp = dummy.next;
            ListNode prev = dummy;
            boolean flag = true;
            while(temp != curr.next)
            {
                //System.out.println("-->" + temp.val);
                if(curr.next.val < temp.val)
                {
                    ListNode nxt = curr.next;
                    curr.next = nxt.next;
                    prev.next = nxt;
                    nxt.next = temp;
                    flag = false;
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
            if(flag)
                curr = curr.next;            
        }
        return dummy.next;
    }
}