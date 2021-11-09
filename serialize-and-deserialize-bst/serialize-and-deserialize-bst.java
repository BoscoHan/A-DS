/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = Arrays.asList(data.split(","));
        
        return buildTree(list, new int[]{0});
    }
    
    private TreeNode buildTree(List<String> list, int[] idx) {
        if (list.get(idx[0]).equals("#")) {
            idx[0]++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(list.get(idx[0]++)));
        root.left = buildTree(list, idx);
        root.right = buildTree(list, idx);
        
        return root;
    }
    
    private void preOrder (TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('#');
            sb.append(',');
            return;
        }
        
        sb.append(root.val);
        sb.append(',');

        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;