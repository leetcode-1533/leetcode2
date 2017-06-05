/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode re = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      re = null;
      dfs(root, p);
      return re;
    }
    
    private void dfs(TreeNode root, TreeNode p) {
      if (root != null) {
        if (root.val > p.val) {
          if (re == null || re.val > root.val) {
            re = root;
          }
          dfs(root.left, p);
        } else {
          dfs(root.right, p);
        }
      }
    }
}