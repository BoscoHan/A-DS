/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = null;
    
    public void recoverTree(TreeNode root) {
        inOrder(root);
        
        //swap value of the two nodes that were found out of place:
        int temp = secondElement.val;
        secondElement.val = firstElement.val;
        firstElement.val = temp;
    }
    
    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        
        // If first element has not been found, assign it to prevElement
        // or prevElement null or greater than curr val
        if (firstElement == null && (prevElement == null || prevElement.val >= root.val)) {
            firstElement = prevElement;
        }
        
        // If first element is found, assign the second element to the root
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
            // System.out.println(firstElement.val);
            // System.out.println(secondElement.val);
        }
        
        prevElement = root;
        inOrder(root.right);
    }
}