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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.add(root.val);

        while (!queue.isEmpty()) {
           int levelSize = queue.size();
           Stack<Integer> currentStack = new Stack<>();
           for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                    currentStack.push(node.left.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    currentStack.push(node.right.val);
                }
           }
           if (!currentStack.isEmpty()) {
                result.add(currentStack.pop());
           }
        }

        return result;
    }
}
