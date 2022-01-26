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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        
        inOrder(root1, list1);
        inOrder(root2, list2);
        return mergeList(list1, list2);
    }
    
    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    
    private List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList();
        
        int idx1 = 0, idx2 = 0;
        while (idx1 < list1.size() && idx2 < list2.size()) {
            if (list1.get(idx1) < list2.get(idx2))
                list.add(list1.get(idx1++));
            else
                list.add(list2.get(idx2++));
        }
        while (idx1 < list1.size())
            list.add(list1.get(idx1++));
        while (idx2 < list2.size())
            list.add(list2.get(idx2++));
        
        return list;
    }
}