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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode L1 = head;
        ListNode prev = null; // tail of first half of list
                
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 1 2 3 4 5 6
        // reverse second half
        // 1 2 3 6 5 4
        // merge two lists
        // 1 6 2 5 3 4
        prev.next = null;
        
        ListNode L2 = reverse(slow);
        mergeLists(L1, L2);
    }
    
    private void mergeLists(ListNode L1, ListNode L2) {
        while (L1 != null && L2 != null) {
            ListNode L1Next = L1.next;
            ListNode L2Next = L2.next;
            
            L1.next = L2;
            if (L1Next == null || L2Next == null)
                break;
                
            L2.next = L1Next;
            L1 = L1Next;
            L2 = L2Next;
        }
    }    

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev; // 1 -> N
            
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}