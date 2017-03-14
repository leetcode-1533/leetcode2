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
  private class node_level{
    public TreeNode node;
    public int level;
    public node_level(TreeNode node, int level) {
      this.level = level;
      this.node = node;
    }
  }
  private int max = 0, min = 0;
  
  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> re = new ArrayList<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    
    if (root == null)
      return re;
    Queue<node_level> queue = new ArrayDeque<>(1);
    queue.offer(new node_level(root, 0));
    // doing a BFS
    while (queue.size() != 0){ 
      node_level current = queue.poll();
      if (current.level > max)
        max = current.level;
      else if (current.level < min)
        min = current.level;
      
      List<Integer> cur_level;
      if (map.get(current.level) != null) 
        cur_level = map.get(current.level);
      else {
        cur_level = new ArrayList<>(1);
        map.put(current.level, cur_level);
      }
      cur_level.add(current.node.val);
      
      if (current.node.left != null) queue.offer(new node_level(current.node.left, current.level - 1));
      if (current.node.right != null) queue.offer(new node_level(current.node.right, current.level + 1));
    }
    
    for (int i = min; i <= max; i++) {
      re.add(map.get(i));
    }
    return re;
  }
}