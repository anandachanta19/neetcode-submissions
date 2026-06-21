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
    int goodNodesCount = 0;

    public void dfs (TreeNode root, int currentMax) {
        currentMax = Math.max(currentMax, root.val);

        if (root.val >= currentMax) {
            goodNodesCount++;
        }

        if (root.left != null) {
            dfs(root.left, currentMax);
        }

        if (root.right != null) {
            dfs(root.right, currentMax);
        }

    }

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return goodNodesCount;
    }
}
