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
    
    private long getSize(ListNode node, long size)
    {
        if(node != null)
        {
            return getSize(node.next, (size+1));
        }
        return size;
    }
    
    private ListNode reverse(ListNode head)
    {
        ListNode newHead = null;
        ListNode curr = head;
        while(curr != null)
        {
            ListNode temp = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = temp;
        }
        
        
        while(newHead!= null && newHead.val < 1)
            newHead = newHead.next;
        
        if(newHead == null)
            return new ListNode(0);
        
        return newHead;
    }
    
    private ListNode dfs(ListNode Lnode, ListNode Snode, long diff)
    {
        if(Lnode == null && Snode == null)
        {
            revHead = new ListNode(0);
            return revHead;
        }
        
        ListNode curr = null, next = new ListNode(0);
        
        if(diff > 0)
        {
            curr = dfs(Lnode.next, Snode, diff-1);
            curr.val += Lnode.val;
        }
        else
        {
            curr = dfs(Lnode.next, Snode.next, diff);
            curr.val += Lnode.val + Snode.val;
        }
        curr.next = next;
        if(curr.val > 9)
        {
            next.val = curr.val/10;
            curr.val %= 10;            
        }
        return next;
    }
    
    ListNode revHead;
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        long s1 = getSize(l1, 0L);
        long s2 = getSize(l2, 0L);
        ListNode tail = null;
        
        revHead = null;
        //ansHead = null;
        
        if(s1 > s2)
        {
            tail = dfs(l1, l2, s1-s2);
        }
        else
        {
            tail = dfs(l2, l1, s2-s1);
        }
        
        if(tail.val > 9)
        {
            ListNode next = new ListNode(0);
            next.val = tail.val/10;
            tail.val %= 10;
            tail.next = next;
        }
        
        return reverse(revHead);
        
        //return ansHead;            
    }
}