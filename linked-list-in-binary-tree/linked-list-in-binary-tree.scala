/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def isSubPath(head: ListNode, root: TreeNode): Boolean = {        
        if (head == null)
            return true;
        
        if (root == null)
            return false;
        
        if (dfs(head, root))
            return true;
        
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
    def dfs(head: ListNode, root: TreeNode): Boolean = {
        if (head == null)
            return true;
        
        if (root == null)
            return false;
        
        if (root.value == head.x) {
            var leftPath = dfs(head.next, root.left);
            var rightPath = dfs(head.next, root.right);
            
            return leftPath || rightPath;
        }
        return false;
    }    
}