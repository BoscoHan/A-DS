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
    public ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode after_head = new ListNode(0);
        
        ListNode before = before_head;
        ListNode after = after_head;
        
        while (head != null) {
            //if node's val < x, move to before list:
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
            // assign to after list:
                after.next = head;
                after = after.next;
            }
            
            head = head.next;
        }
        //last node points to null
        after.next = null;
        
        //combine before and after lists
        before.next = after_head.next;
        
        return before_head.next;
    }
}